package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseKvComponentDb;

public interface GooseKvComponentInterface {

	ResponseEntity<Object> inserisci(GooseKvComponentDb kv);

	ResponseEntity<Object> getLista(String formId, String componentId);

	ResponseEntity<Object> elimina(String formId, String componentId, String k);


}
