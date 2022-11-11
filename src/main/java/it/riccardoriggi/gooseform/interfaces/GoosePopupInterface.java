package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GoosePopupDb;

public interface GoosePopupInterface {

	ResponseEntity<Object> inserisciPopup(GoosePopupDb form);

	ResponseEntity<Object> getPopupById(String formId, String componentId);

	ResponseEntity<Object> getPopupByFormId(String formId);

	ResponseEntity<Object> modificaPopup(GoosePopupDb button, int pk);

	ResponseEntity<Object> eliminaPopup(int pk);



}
