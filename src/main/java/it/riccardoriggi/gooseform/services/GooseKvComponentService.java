package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.entity.db.GooseKvComponentDb;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKvComponentInterface;
import it.riccardoriggi.gooseform.mapper.GooseKvComponentMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseKvComponentService implements GooseKvComponentInterface {


	@Autowired
	GooseKvComponentMapper mapper;


	@Autowired
	GooseFormInterface formService;


	@Autowired
	GooseComponentiInterface componentService;

	@Override
	public ResponseEntity<Object> inserisci(GooseKvComponentDb kv) {
		try {

			if(kv.getFormId()==null) {
				return new ResponseEntity<Object>(new GooseProblem(500, "Il campo formId è richiesto"), HttpStatus.INTERNAL_SERVER_ERROR);
			}else if(!formService.isFormEsistente(kv.getFormId())) {
				return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.FORM_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
			}else if(kv.getComponentId() != null && !componentService.isComponenteEsistente(kv.getFormId(), kv.getComponentId())) {
				return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.COMPONENTE_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
			}

			mapper.inserisci(kv);
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
	public ResponseEntity<Object> getLista(String formId, String componentId) {
		try {
			return new ResponseEntity<Object>(mapper.getLista(formId,componentId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> elimina(String formId, String componentId, String k) {
		try {
			mapper.elimina(formId,componentId,k);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) {

		try {
			if(componentId==null) {
				mapper.eliminaByFormId(formId);
			}else {
				mapper.eliminaByComponentId(formId, componentId);
			}
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
		}

	}



}
