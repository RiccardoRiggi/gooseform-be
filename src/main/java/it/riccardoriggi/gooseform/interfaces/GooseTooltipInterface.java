package it.riccardoriggi.gooseform.interfaces;

import it.riccardoriggi.gooseform.entity.db.GooseTooltipDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseTooltipInterface {

	void inserisciTooltip(GooseTooltipDb form) throws GooseFormException;

	GooseTooltipDb getTooltipById(String formId, String componentId) throws GooseFormException;

	GooseTooltipDb getTooltipByFormId(String formId) throws GooseFormException;

	void modificaTooltip(GooseTooltipDb button, int pk) throws GooseFormException;

	void eliminaTooltip(int pk) throws GooseFormException;

	void eliminazioneMassiva(String formId, String componentId) throws GooseFormException;

	boolean esisteTooltipByFormId(String formId) throws GooseFormException;

	boolean esisteTooltipById(String formId, String componentId) throws GooseFormException;

}
