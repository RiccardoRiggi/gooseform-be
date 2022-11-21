package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.entity.db.GooseControlDb;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseControlInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKControlInterface;
import it.riccardoriggi.gooseform.mapper.GooseControlMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseControlService implements GooseControlInterface {

	@Autowired
	GooseControlMapper controlMapper;


	@Autowired
	GooseFormInterface formService;


	@Autowired
	GooseComponentiInterface componentService;


	@Autowired
	GooseValidationService validationService;


	@Autowired
	GooseKControlInterface kControlService;

	@Override
	public ResponseEntity<Object> inserisciControllo(GooseControlDb controllo) {

		if(controllo.getFormId()==null) {
			return new ResponseEntity<Object>(new GooseProblem(500, "Il campo formId è richiesto"), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!formService.isFormEsistente(controllo.getFormId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.FORM_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!validationService.esisteTipoControllo(controllo.getType(),controllo.getTypeSpecific())) {
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
			controlMapper.inserisciControllo(controllo);
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
	public ResponseEntity<Object> modificaControllo(GooseControlDb controllo, int pk) {
		try {
			controlMapper.modificaControllo(controllo.getType(), controllo.getTypeSpecific(), controllo.getIdComponentA(), controllo.getIdComponentB(), controllo.getIdComponentC(), controllo.getReferenceValue(), controllo.getErrorMessage(),pk);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaControllo(int pk) {
		try {
			controlMapper.eliminaControllo(pk);
			kControlService.elimina(pk);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getControllo(int pk) {
		try {
			return new ResponseEntity<Object>(controlMapper.getControllo(pk),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getControlli(String formId) {
		try {
			return new ResponseEntity<Object>(controlMapper.getControlliByFormId(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public boolean esistonoControlli(String formId, String componentId) {
		boolean esiste=false;
		try {
			esiste = !controlMapper.getControlli(formId,componentId).isEmpty();
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public boolean esisteControllo(int pk) {
		boolean esiste=false;
		try {
			esiste = controlMapper.getControllo(pk)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_HTTP_REQUEST: ", e);
		}
		return esiste;
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) {
		try {

			if(componentId==null) {
				controlMapper.eliminaControlloByFormId(formId);
			}else {
				controlMapper.eliminaControlloByComponentId(formId, componentId);
			}

		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}

	}
}
