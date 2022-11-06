package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseHttpRequestDb;

public interface GooseHttpRequestInterface {

	ResponseEntity<Object> inserisciChiamata(GooseHttpRequestDb chiamata);

	ResponseEntity<Object> modificaChiamata(GooseHttpRequestDb chiamata, int id);

	ResponseEntity<Object> eliminaChiamata(int id);

	ResponseEntity<Object> getChiamataById(String formId, String componentId);

	ResponseEntity<Object> getChiamataByFormId(String formId);

	ResponseEntity<Object> getChiamataByPk(int pk);







}
