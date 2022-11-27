package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GooseTooltipDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseTooltipInterface;
import it.riccardoriggi.gooseform.mapper.GooseTooltipMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseTooltipService implements GooseTooltipInterface{


	@Autowired
	GooseTooltipMapper mapper;


	@Autowired
	GooseFormInterface formService;


	@Autowired
	GooseComponentiInterface componentService;

	@Override
	public void inserisciTooltip(GooseTooltipDb button) throws GooseFormException{

		if(button.getFormId()==null) {
			throw new GooseFormException(500, "Il campo formId è richiesto");
		}else if(!formService.isFormEsistente(button.getFormId())) {
			throw new GooseFormException(500, GooseErrors.FORM_NON_ESISTENTE);
		}else if(button.getComponentId() != null && !componentService.isComponenteEsistente(button.getFormId(), button.getComponentId())) {
			throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE);
		}

		if(button.getComponentId()==null && esisteTooltipByFormId(button.getFormId())) {
			throw new GooseFormException(500, GooseErrors.TOOLTIP_ESISTENTE_FORM);
		}else if(button.getComponentId()!=null && esisteTooltipById(button.getFormId(), button.getComponentId())) {
			throw new GooseFormException(501, GooseErrors.TOOLTIP_ESISTENTE_COMPONENTE);
		}

		try {
			mapper.inserisciTooltip(button);
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
	public GooseTooltipDb getTooltipById(String formId, String componentId) throws GooseFormException{
		try {
			return mapper.getTooltipById(formId,componentId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public boolean esisteTooltipById(String formId, String componentId) throws GooseFormException{
		boolean esiste = false;
		try {
			esiste = mapper.getTooltipById(formId,componentId)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
		}
		return esiste;
	}

	@Override
	public GooseTooltipDb getTooltipByFormId(String formId) throws GooseFormException{
		try {
			return mapper.getTooltipByFormId(formId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public boolean esisteTooltipByFormId(String formId) throws GooseFormException{
		boolean esiste = false;
		try {
			esiste = mapper.getTooltipByFormId(formId) != null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
		}
		return esiste;
	}

	@Override
	public void modificaTooltip(GooseTooltipDb button, int pk) throws GooseFormException{
		try {
			mapper.updatTooltip(button.getIcon(), button.getTooltip(), pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public void eliminaTooltip(int pk) throws GooseFormException{
		try {
			mapper.deleteTooltip(pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) throws GooseFormException{
		try {
			if(componentId==null) {
				mapper.deleteTooltipByFormId(formId);
			}else {
				mapper.deleteTooltipByComponentId(formId, componentId);
			}
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
		}
	}


}
