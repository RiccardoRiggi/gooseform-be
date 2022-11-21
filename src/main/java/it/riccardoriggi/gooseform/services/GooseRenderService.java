package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.entity.db.GooseRenderDb;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseRenderInterface;
import it.riccardoriggi.gooseform.mapper.GooseRenderMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseRenderService implements GooseRenderInterface {

	@Autowired
	GooseRenderMapper mapper;

	@Autowired
	GooseFormInterface formService;

	@Autowired
	GooseComponentiInterface componentService;

	@Autowired
	GooseValidationService validationService;

	@Override
	public ResponseEntity<Object> inserisciRender(GooseRenderDb controllo) {

		if(controllo.getFormId()==null) {
			return new ResponseEntity<>(new GooseProblem(500, "Il campo formId è richiesto"), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!formService.isFormEsistente(controllo.getFormId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.FORM_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!validationService.esisteTipoRender(controllo.getType(),controllo.getTypeSpecific())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.CONTROLLO_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(controllo.getIdComponentA()!=null && !componentService.isComponenteEsistente(controllo.getFormId(), controllo.getIdComponentA())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.COMPONENTE_NON_ESISTENTE_X+"A"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(controllo.getIdComponentB()!=null && !componentService.isComponenteEsistente(controllo.getFormId(), controllo.getIdComponentB())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.COMPONENTE_NON_ESISTENTE_X+"B"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(controllo.getIdComponentC()!=null && !componentService.isComponenteEsistente(controllo.getFormId(), controllo.getIdComponentC())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.COMPONENTE_NON_ESISTENTE_X+"C"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			mapper.inserisciRender(controllo);
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
	public ResponseEntity<Object> modificaRender(GooseRenderDb controllo, int pk) {
		try {
			mapper.modificaRender(controllo.getType(), controllo.getTypeSpecific(), controllo.getIdComponentA(), controllo.getIdComponentB(), controllo.getIdComponentC(), controllo.getValue(),pk);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaRender(int pk) {
		try {
			mapper.eliminaRender(pk);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getRender(int pk) {
		try {
			return new ResponseEntity<Object>(mapper.getRender(pk),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getRenders(String formId) {
		try {
			return new ResponseEntity<Object>(mapper.getRenders(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public boolean esistonoRenders(String formId, String componentId) {
		boolean esiste=false;
		try {
			esiste = !mapper.getRenders(formId,componentId).isEmpty();
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) {
		try {
			if(componentId==null) {
				mapper.eliminaControlloByFormId(formId);
			}else {
				mapper.eliminaControlloByComponentId(formId, componentId);
			}
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
		}

	}
}
