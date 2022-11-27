package it.riccardoriggi.gooseform.interfaces;

import it.riccardoriggi.gooseform.entity.db.GooseButtonDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseButtonInterface {

	public void inserisciButton(GooseButtonDb form) throws GooseFormException;

	public GooseButtonDb getButton(String type, String formId) throws GooseFormException;

	public void modificaButton(GooseButtonDb button, String type, String formId) throws GooseFormException;

	public void eliminaButton(String type, String formId) throws GooseFormException;

	public void eliminazioneMassiva(String formId) throws GooseFormException;



}
