package it.riccardoriggi.gooseform.interfaces;

import java.util.List;

import it.riccardoriggi.gooseform.entity.db.GooseKControlDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseKControlInterface {

	void inserisci(GooseKControlDb kv) throws GooseFormException;

	List<GooseKControlDb> getLista(int pkControl) throws GooseFormException;

	void elimina(int pkControl, String k) throws GooseFormException;

	void elimina(int pkControl) throws GooseFormException;



}
