package it.riccardoriggi.gooseform.interfaces;

import java.util.List;

import it.riccardoriggi.gooseform.entity.db.GooseKvComponentDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseKvComponentInterface {

	void inserisci(GooseKvComponentDb kv) throws GooseFormException;

	List<GooseKvComponentDb> getLista(String formId, String componentId) throws GooseFormException;

	void elimina(String formId, String componentId, String k) throws GooseFormException;

	void eliminazioneMassiva(String formId, String componentId) throws GooseFormException;

}
