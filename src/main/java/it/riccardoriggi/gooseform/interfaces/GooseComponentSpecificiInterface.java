package it.riccardoriggi.gooseform.interfaces;

import java.util.List;

import it.riccardoriggi.gooseform.entity.db.GooseComponentSpecificDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseComponentSpecificiInterface {

	void insericiRiga(GooseComponentSpecificDb riga) throws GooseFormException;

	void eliminaRiga(String formId, String id, String nomeAttributo) throws GooseFormException;

	GooseComponentSpecificDb getRiga(String formId, String id, String nomeAttributo) throws GooseFormException;

	List<GooseComponentSpecificDb> getRighe(String formId, String id) throws GooseFormException;

	void eliminazioneMassiva(String formId, String componentId) throws GooseFormException;


}
