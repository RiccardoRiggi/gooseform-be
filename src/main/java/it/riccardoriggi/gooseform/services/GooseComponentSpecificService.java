package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;
import it.riccardoriggi.gooseform.entity.db.GooseComponentSpecificDb;
import it.riccardoriggi.gooseform.interfaces.GooseComponentSpecificiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseValidationInterface;
import it.riccardoriggi.gooseform.mapper.GooseComponentSpecificMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseComponentSpecificService implements GooseComponentSpecificiInterface {

	@Autowired
	GooseComponentSpecificMapper componentSpecificMapper;

	@Autowired
	GooseComponentiInterface componentService;

	@Autowired
	GooseValidationInterface validationService;

	@Override
	public ResponseEntity<Object> insericiRiga(GooseComponentSpecificDb riga) {

		if(riga.getFormId()==null || riga.getId()==null) {
			return new ResponseEntity<Object>(new GooseProblem(500, "Il campo formId è richiesto"), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!componentService.isComponenteEsistente(riga.getFormId(), riga.getId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.COMPONENTE_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}


		GooseComponentDb componente = (GooseComponentDb) componentService.getComponent(riga.getFormId(), riga.getId()).getBody();

		if(riga.getNomeAttributo() == null || !validationService.esisteAttributoPerComponente(componente.getType(), riga.getNomeAttributo())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.ATTRIBUTO_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			componentSpecificMapper.inserisciRiga(riga);
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
	public ResponseEntity<Object> eliminaRiga(String formId, String id, String nomeAttributo) {
		try {
			componentSpecificMapper.deleteRiga(formId, id, nomeAttributo);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getRiga(String formId, String id, String nomeAttributo) {
		try {
			return new ResponseEntity<Object>(componentSpecificMapper.getRiga(formId,id,nomeAttributo),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getRighe(String formId, String id) {
		try {
			return new ResponseEntity<Object>(componentSpecificMapper.getRighe(formId,id),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
