package it.riccardoriggi.gooseform.interfaces;

import it.riccardoriggi.gooseform.entity.db.GoosePopupDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GoosePopupInterface {

	void inserisciPopup(GoosePopupDb form) throws GooseFormException;

	GoosePopupDb getPopupById(String formId, String componentId) throws GooseFormException;

	GoosePopupDb getPopupByFormId(String formId) throws GooseFormException;

	void modificaPopup(GoosePopupDb button, int pk) throws GooseFormException;

	void eliminaPopup(int pk) throws GooseFormException;

	void eliminazioneMassiva(String formId, String componentId) throws GooseFormException;

	boolean esistePopupByFormId(String formId) throws GooseFormException;

	boolean esistePopupById(String formId, String componentId) throws GooseFormException;

}
