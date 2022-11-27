package it.riccardoriggi.gooseform.interfaces;

import java.util.List;

import it.riccardoriggi.gooseform.entity.db.GooseRenderDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseRenderInterface {

	void inserisciRender(GooseRenderDb controllo) throws GooseFormException;

	void modificaRender(GooseRenderDb controllo, int pk) throws GooseFormException;

	void eliminaRender(int pk) throws GooseFormException;

	GooseRenderDb getRender(int pk) throws GooseFormException;

	List<GooseRenderDb> getRenders(String formId) throws GooseFormException;

	void eliminazioneMassiva(String formId, String componentId) throws GooseFormException;

	boolean esistonoRenders(String formId, String componentId) throws GooseFormException;

}
