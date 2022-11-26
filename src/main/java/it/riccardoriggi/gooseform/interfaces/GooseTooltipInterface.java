package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseTooltipDb;

public interface GooseTooltipInterface {

	ResponseEntity<Object> inserisciTooltip(GooseTooltipDb form);

	ResponseEntity<Object> getTooltipById(String formId, String componentId);

	ResponseEntity<Object> getTooltipByFormId(String formId);

	ResponseEntity<Object> modificaTooltip(GooseTooltipDb button, int pk);

	ResponseEntity<Object> eliminaTooltip(int pk);

	void eliminazioneMassiva(String formId, String componentId);

	boolean esisteTooltipByFormId(String formId);

	boolean esisteTooltipById(String formId, String componentId);

}
