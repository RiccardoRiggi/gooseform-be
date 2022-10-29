package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseFormDb;

public interface GooseFormInterface {

	ResponseEntity<Object> inserisciForm(GooseFormDb form);

	ResponseEntity<Object> getFormById(String formId);

	ResponseEntity<Object> getListaForm();

	ResponseEntity<Object> modificaForm(GooseFormDb form, String formId);

	ResponseEntity<Object> eliminaForm(String formId);



}
