package it.riccardoriggi.gooseform.interfaces;

import org.springframework.http.ResponseEntity;

import it.riccardoriggi.gooseform.entity.db.GooseKvHttpRequestDb;

public interface GooseKvHttpRequestInterface {

	ResponseEntity<Object> inserisci(GooseKvHttpRequestDb kv);

	ResponseEntity<Object> getLista(int pkHttp);

	ResponseEntity<Object> elimina(int pkHttp, String k);

	ResponseEntity<Object> elimina(int pkHttp);


}
