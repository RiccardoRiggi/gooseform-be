package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.entity.db.GoosePopupDb;
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
	public ResponseEntity<Object> inserisciPopup(GoosePopupDb button) {

		if(button.getFormId()==null) {
			return new ResponseEntity<Object>(new GooseProblem(500, "Il campo formId è richiesto"), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!formService.isFormEsistente(button.getFormId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.FORM_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(button.getComponentId() != null && !componentService.isComponenteEsistente(button.getFormId(), button.getComponentId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.COMPONENTE_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(button.getComponentId()==null && getPopupByFormId(button.getFormId()) !=null) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.POPUP_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(button.getComponentId()!=null && getPopupById(button.getFormId(), button.getComponentId()) !=null) {
			return new ResponseEntity<Object>(new GooseProblem(501, GooseErrors.POPUP_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			mapper.inserisciPopup(button);
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
	public ResponseEntity<Object> getPopupById(String formId, String componentId) {
		try {
			return new ResponseEntity<Object>(mapper.getPopupById(formId,componentId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getPopupByFormId(String formId) {
		try {
			return new ResponseEntity<Object>(mapper.getPopupByFormId(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> modificaPopup(GoosePopupDb button, int pk) {
		try {
			mapper.updatPopup(button.getTitle(), button.getIcon(), button.getTextTooltip(), button.getDescription(), pk);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaPopup(int pk) {
		try {
			mapper.deletePopup(pk);
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
				mapper.deletePopupByFormId(formId);
			}else {
				mapper.deletePopupByComponentId(formId, componentId);
			}
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
		}
	}


}
