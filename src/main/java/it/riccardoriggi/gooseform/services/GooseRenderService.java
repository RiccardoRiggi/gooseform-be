package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseError;
import it.riccardoriggi.gooseform.entity.db.GooseRenderDb;
import it.riccardoriggi.gooseform.interfaces.GooseRenderInterface;
import it.riccardoriggi.gooseform.mapper.GooseRenderMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseRenderService implements GooseRenderInterface {

	@Autowired
	GooseRenderMapper mapper;

	@Override
	public ResponseEntity<Object> inserisciRender(GooseRenderDb controllo) {
		try {
			mapper.inserisciRender(controllo);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> modificaRender(GooseRenderDb controllo, int pk) {
		try {
			mapper.modificaRender(controllo.getType(), controllo.getTypeSpecific(), controllo.getIdComponentA(), controllo.getIdComponentB(), controllo.getIdComponentC(), controllo.getValue(),pk);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaRender(int pk) {
		try {
			mapper.eliminaRender(pk);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getRender(int pk) {
		try {
			return new ResponseEntity<Object>(mapper.getRender(pk),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getRenders(String formId) {
		try {
			return new ResponseEntity<Object>(mapper.getRenders(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
