package it.riccardoriggi.gooseform.interfaces;

import java.util.List;

import it.riccardoriggi.gooseform.entity.db.GooseControlDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseControlInterface {

	void inserisciControllo(GooseControlDb controllo) throws GooseFormException;

	void modificaControllo(GooseControlDb controllo, int pk) throws GooseFormException;

	void eliminaControllo(int pk) throws GooseFormException;

	GooseControlDb getControllo(int pk) throws GooseFormException;

	List<GooseControlDb> getControlli(String formId) throws GooseFormException;

	boolean esisteControllo(int pk) throws GooseFormException;

	void eliminazioneMassiva(String formId, String componentId) throws GooseFormException;

	boolean esistonoControlli(String formId, String componentId) throws GooseFormException;

}
