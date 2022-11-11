package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseRenderDb;

public interface GooseRenderInterface {

	ResponseEntity<Object> inserisciRender(GooseRenderDb controllo);

	ResponseEntity<Object> modificaRender(GooseRenderDb controllo, int pk);

	ResponseEntity<Object> eliminaRender(int pk);

	ResponseEntity<Object> getRender(int pk);

	ResponseEntity<Object> getRenders(String formId);





}
