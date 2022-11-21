package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;

public interface GooseComponentiInterface {

	ResponseEntity<Object> inserisciComponente(GooseComponentDb componente);

	ResponseEntity<Object> modificaComponente(GooseComponentDb componente, String formId, String id);

	ResponseEntity<Object> eliminaComponente(String formId, String id);

	ResponseEntity<Object> getComponent(String formId, String id);

	ResponseEntity<Object> getComponenti(String formId);

	boolean isComponenteEsistente(String formId, String componentId);

	void eliminazioneMassiva(String formId);






}
