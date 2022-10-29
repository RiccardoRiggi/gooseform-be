package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseButtonDb;

public interface GooseButtonInterface {

	ResponseEntity<Object> inserisciButton(GooseButtonDb form);

	ResponseEntity<Object> getButton(String type, String formId);

	ResponseEntity<Object> modificaButton(GooseButtonDb button, String type, String formId);

	ResponseEntity<Object> eliminaButton(String type, String formId);



}
