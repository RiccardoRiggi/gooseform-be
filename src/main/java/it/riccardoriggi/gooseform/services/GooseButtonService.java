package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseError;
import it.riccardoriggi.gooseform.entity.db.GooseButtonDb;
import it.riccardoriggi.gooseform.interfaces.GooseButtonInterface;
import it.riccardoriggi.gooseform.mapper.GooseButtonMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseButtonService implements GooseButtonInterface{

	@Autowired
	GooseButtonMapper buttonMapper;

	@Override
	public ResponseEntity<Object> inserisciButton(GooseButtonDb button) {
		try {
			buttonMapper.inserisciButton(button);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getButton(String formId, String type) {
		try {
			return new ResponseEntity<Object>(buttonMapper.getButton(formId,type),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> modificaButton(GooseButtonDb button, String type, String formId) {
		try {
			buttonMapper.updateButton(button.getTitle(), button.getIcon(),type, formId);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaButton(String formId, String type) {
		try {
			buttonMapper.deleteButton(formId,type);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
