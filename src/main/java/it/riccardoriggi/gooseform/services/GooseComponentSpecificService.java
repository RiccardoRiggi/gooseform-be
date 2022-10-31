package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseError;
import it.riccardoriggi.gooseform.entity.db.GooseComponentSpecificDb;
import it.riccardoriggi.gooseform.interfaces.GooseComponentSpecificiInterface;
import it.riccardoriggi.gooseform.mapper.GooseComponentSpecificMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseComponentSpecificService implements GooseComponentSpecificiInterface {

	@Autowired
	GooseComponentSpecificMapper componentSpecificMapper;

	@Override
	public ResponseEntity<Object> insericiRiga(GooseComponentSpecificDb riga) {
		try {
			componentSpecificMapper.inserisciRiga(riga);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaRiga(String formId, String id, String nomeAttributo) {
		try {
			componentSpecificMapper.deleteRiga(formId, id, nomeAttributo);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getRiga(String formId, String id, String nomeAttributo) {
		try {
			return new ResponseEntity<Object>(componentSpecificMapper.getRiga(formId,id,nomeAttributo),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getRighe(String formId, String id) {
		try {
			return new ResponseEntity<Object>(componentSpecificMapper.getRighe(formId,id),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
