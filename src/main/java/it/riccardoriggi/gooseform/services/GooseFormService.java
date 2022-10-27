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
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.CREATED);
		}

	}

	@Override
	public ResponseEntity<Object> getForm(String formId) {
		try {
			return new ResponseEntity<Object>(formMapper.getFormById(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.CREATED);
		}

	}

}
