package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.entity.db.GooseTooltipDb;
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
	public ResponseEntity<Object> inserisciTooltip(GooseTooltipDb button) {

		if(button.getFormId()==null) {
			return new ResponseEntity<Object>(new GooseProblem(500, "Il campo formId è richiesto"), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!formService.isFormEsistente(button.getFormId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.FORM_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(button.getComponentId() != null && !componentService.isComponenteEsistente(button.getFormId(), button.getComponentId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.COMPONENTE_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(button.getComponentId()==null && esisteTooltipByFormId(button.getFormId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.TOOLTIP_ESISTENTE_FORM), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(button.getComponentId()!=null && esisteTooltipById(button.getFormId(), button.getComponentId())) {
			return new ResponseEntity<Object>(new GooseProblem(501, GooseErrors.TOOLTIP_ESISTENTE_COMPONENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			mapper.inserisciTooltip(button);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			if(e.getMessage().contains("SQLIntegrityConstraintViolationException")){
				return new ResponseEntity<Object>(new GooseProblem(500, "Chiave primaria duplicata"), HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@Override
	public ResponseEntity<Object> getTooltipById(String formId, String componentId) {
		try {
			return new ResponseEntity<Object>(mapper.getTooltipById(formId,componentId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public boolean esisteTooltipById(String formId, String componentId) {
		boolean esiste = false;
		try {
			esiste = mapper.getTooltipById(formId,componentId)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
		}
		return esiste;
	}

	@Override
	public ResponseEntity<Object> getTooltipByFormId(String formId) {
		try {
			return new ResponseEntity<Object>(mapper.getTooltipByFormId(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public boolean esisteTooltipByFormId(String formId) {
		boolean esiste = false;
		try {
			esiste = mapper.getTooltipByFormId(formId) != null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
		}
		return esiste;
	}

	@Override
	public ResponseEntity<Object> modificaTooltip(GooseTooltipDb button, int pk) {
		try {
			mapper.updatTooltip(button.getIcon(), button.getTooltip(), pk);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaTooltip(int pk) {
		try {
			mapper.deleteTooltip(pk);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) {
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
