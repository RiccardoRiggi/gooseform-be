package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseError;
import it.riccardoriggi.gooseform.entity.db.GoosePopupDb;
import it.riccardoriggi.gooseform.interfaces.GoosePopupInterface;
import it.riccardoriggi.gooseform.mapper.GoosePopupMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoosePopupService implements GoosePopupInterface{

	@Autowired
	GoosePopupMapper mapper;

	@Override
	public ResponseEntity<Object> inserisciPopup(GoosePopupDb button) {
		try {
			mapper.inserisciPopup(button);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getPopupById(String formId, String componentId) {
		try {
			return new ResponseEntity<Object>(mapper.getPopupById(formId,componentId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getPopupByFormId(String formId) {
		try {
			return new ResponseEntity<Object>(mapper.getPopupByFormId(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> modificaPopup(GoosePopupDb button, int pk) {
		try {
			mapper.updatPopup(button.getTitle(), button.getIcon(), button.getTextTooltip(), button.getDescription(), pk);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaPopup(int pk) {
		try {
			mapper.deletePopup(pk);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
