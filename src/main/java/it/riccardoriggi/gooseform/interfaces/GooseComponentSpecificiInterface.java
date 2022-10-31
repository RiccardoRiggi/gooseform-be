package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseComponentSpecificDb;

public interface GooseComponentSpecificiInterface {

	ResponseEntity<Object> insericiRiga(GooseComponentSpecificDb riga);

	ResponseEntity<Object> eliminaRiga(String formId, String id, String nomeAttributo);

	ResponseEntity<Object> getRiga(String formId, String id, String nomeAttributo);

	ResponseEntity<Object> getRighe(String formId, String id);


}
