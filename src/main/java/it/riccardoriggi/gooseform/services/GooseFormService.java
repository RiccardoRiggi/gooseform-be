package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseError;
import it.riccardoriggi.gooseform.entity.db.GooseFormDb;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.mapper.GooseFormMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseFormService implements GooseFormInterface{

	@Autowired
	GooseFormMapper formMapper;

	@Override
	public ResponseEntity<Object> inserisciForm(GooseFormDb form) {
		try {
			formMapper.inserisciForm(form);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Object> getFormById(String formId) {
		try {
			return new ResponseEntity<Object>(formMapper.getFormById(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Object> getListaForm() {
		try {
			return new ResponseEntity<Object>(formMapper.getForms(),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> modificaForm(GooseFormDb form, String formId) {
		try {
			formMapper.updateForm(form.getTitle(), form.getIcon(), form.getDescription(), formId);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaForm(String formId) {
		try {
			formMapper.deleteForm(formId);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
