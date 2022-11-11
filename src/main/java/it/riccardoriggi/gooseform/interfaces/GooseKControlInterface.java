package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseKControlDb;

public interface GooseKControlInterface {

	ResponseEntity<Object> inserisci(GooseKControlDb kv);

	ResponseEntity<Object> getLista(int pkControl);

	ResponseEntity<Object> elimina(int pkControl, String k);


}
