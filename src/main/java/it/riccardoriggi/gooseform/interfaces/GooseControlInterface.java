package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseControlDb;

public interface GooseControlInterface {

	ResponseEntity<Object> inserisciControllo(GooseControlDb controllo);

	ResponseEntity<Object> modificaControllo(GooseControlDb controllo, int pk);

	ResponseEntity<Object> eliminaControllo(int pk);

	ResponseEntity<Object> getControllo(int pk);

	ResponseEntity<Object> getControlli(String formId);

	boolean esisteControllo(int pk);

	void eliminazioneMassiva(String formId, String componentId);

	boolean esistonoControlli(String formId, String componentId);

}
