package it.riccardoriggi.gooseform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseComponentSpecificiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseControlInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseHttpRequestInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKvComponentInterface;
import it.riccardoriggi.gooseform.interfaces.GoosePopupInterface;
import it.riccardoriggi.gooseform.interfaces.GooseRenderInterface;
import it.riccardoriggi.gooseform.mapper.GooseComponentMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseComponentService implements GooseComponentiInterface{


	@Autowired
	GooseComponentMapper componentMapper;


	@Autowired
	GooseFormInterface formService;


	@Autowired
	GooseValidationService validationService;


	@Autowired
	GooseComponentSpecificiInterface componentSpecificService;


	@Autowired
	GooseKvComponentInterface kvComponentService;


	@Autowired
	GoosePopupInterface popupService;


	@Autowired
	GooseHttpRequestInterface httpService;


	@Autowired
	GooseControlInterface controlService;


	@Autowired
	GooseRenderInterface renderService;

	@Override
	public void inserisciComponente(GooseComponentDb componente) throws GooseFormException{

		if(componente.getFormId()==null) {
			throw new GooseFormException(500, "Il campo formId è richiesto");
		}else if(!formService.isFormEsistente(componente.getFormId())) {
			throw new GooseFormException(500, GooseErrors.FORM_NON_ESISTENTE);
		}else if(!validationService.esisteTipoComponente(componente.getType())) {
			throw new GooseFormException(500, GooseErrors.TIPO_COMPONENTE_NON_ESISTENTE);
		}

		try {
			componentMapper.inserisciComponent(componente);
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
	public void modificaComponente(GooseComponentDb componente, String formId, String id) throws GooseFormException{
		try {
			componentMapper.updateComponent(componente.getLabel(), componente.getWidthXl(), componente.getWidthLg(), componente.getWidthMd(), componente.getWidthSm(), componente.getWidth(), componente.isRequiredMark(), formId, id, componente.getOrdination(), componente.getPaddingBottom(), componente.getPaddingLeft(), componente.getPaddingRight(), componente.getPaddingTop());
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public void eliminaComponente(String formId, String id) throws GooseFormException{
		try {
			controlService.eliminazioneMassiva(formId, id);
			renderService.eliminazioneMassiva(formId, id);
			componentSpecificService.eliminazioneMassiva(formId, id);
			kvComponentService.eliminazioneMassiva(formId, id);
			popupService.eliminazioneMassiva(formId, id);
			httpService.eliminazioneMassiva(formId, id);
			componentMapper.deleteComponent(formId,id);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public GooseComponentDb getComponent(String formId, String id) throws GooseFormException{
		try {
			return componentMapper.getComponent(formId,id);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public List<GooseComponentDb> getComponenti(String formId) throws GooseFormException{
		try {
			return componentMapper.getComponents(formId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public boolean isComponenteEsistente(String formId, String componentId) throws GooseFormException{
		log.info("formId: "+formId);
		log.info("componentId: "+componentId);
		boolean esiste = false;
		try {
			esiste = componentMapper.getComponent(formId,componentId)!=null;
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_COMPONENT: ",e);
		}
		log.info("Esiste il componente: "+esiste);
		return esiste;
	}

	@Override
	public void eliminazioneMassiva(String formId) throws GooseFormException{
		try {
			componentMapper.deleteComponentByFormId(formId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
		}

	}

}
