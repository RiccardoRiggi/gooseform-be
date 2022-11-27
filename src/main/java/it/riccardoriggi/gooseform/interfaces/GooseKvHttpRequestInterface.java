package it.riccardoriggi.gooseform.interfaces;

import java.util.List;

import it.riccardoriggi.gooseform.entity.db.GooseKvHttpRequestDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseKvHttpRequestInterface {

	void inserisci(GooseKvHttpRequestDb kv) throws GooseFormException;

	List<GooseKvHttpRequestDb> getLista(int pkHttp) throws GooseFormException;

	void elimina(int pkHttp, String k) throws GooseFormException;

	void elimina(int pkHttp) throws GooseFormException;


}
