package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GoosePopupDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GoosePopupInterface;
import it.riccardoriggi.gooseform.mapper.GoosePopupMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoosePopupService implements GoosePopupInterface{


	@Autowired
	GoosePopupMapper mapper;


	@Autowired
	GooseFormInterface formService;


	@Autowired
	GooseComponentiInterface componentService;

	@Override
	public void inserisciPopup(GoosePopupDb button) throws GooseFormException{

		if(button.getFormId()==null) {
			throw new GooseFormException(500, "Il campo formId è richiesto");
		}else if(!formService.isFormEsistente(button.getFormId())) {
			throw new GooseFormException(500, GooseErrors.FORM_NON_ESISTENTE);
		}else if(button.getComponentId() != null && !componentService.isComponenteEsistente(button.getFormId(), button.getComponentId())) {
			throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE);
		}

		if(button.getComponentId()==null && esistePopupByFormId(button.getFormId())) {
			throw new GooseFormException(500, GooseErrors.POPUP_ESISTENTE_FORM);
		}else if(button.getComponentId()!=null && esistePopupById(button.getFormId(), button.getComponentId())) {
			throw new GooseFormException(501, GooseErrors.POPUP_ESISTENTE_COMPONENTE);
		}

		try {
			mapper.inserisciPopup(button);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			if(e.getMessage().contains("SQLIntegrityConstraintViolationException")){
				throw new GooseFormException(500, "Chiave primaria duplicata");
			}else {
				throw new GooseFormException(500, e.getMessage());
			}
		}
	}

	@Override
	public GoosePopupDb getPopupById(String formId, String componentId) throws GooseFormException{
		try {
			return mapper.getPopupById(formId,componentId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public boolean esistePopupById(String formId, String componentId) throws GooseFormException{
		boolean esiste = false;
		try {
			esiste = mapper.getPopupById(formId,componentId)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
		}
		return esiste;
	}

	@Override
	public GoosePopupDb getPopupByFormId(String formId) throws GooseFormException{
		try {
			return mapper.getPopupByFormId(formId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public boolean esistePopupByFormId(String formId) throws GooseFormException{
		boolean esiste = false;
		try {
			esiste = mapper.getPopupByFormId(formId) != null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
		}
		return esiste;
	}

	@Override
	public void modificaPopup(GoosePopupDb button, int pk) throws GooseFormException{
		try {
			mapper.updatPopup(button.getTitle(), button.getIcon(), button.getTextTooltip(), button.getDescription(), pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public void eliminaPopup(int pk) throws GooseFormException{
		try {
			mapper.deletePopup(pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) throws GooseFormException{
		try {
			if(componentId==null) {
				mapper.deletePopupByFormId(formId);
			}else {
				mapper.deletePopupByComponentId(formId, componentId);
			}
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
		}
	}


}
