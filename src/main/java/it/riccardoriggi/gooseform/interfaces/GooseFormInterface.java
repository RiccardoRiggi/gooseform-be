package it.riccardoriggi.gooseform.interfaces;

import java.util.List;

import it.riccardoriggi.gooseform.entity.db.GooseFormDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseFormInterface {

	void inserisciForm(GooseFormDb form) throws GooseFormException;

	GooseFormDb getFormById(String formId) throws GooseFormException;

	List<GooseFormDb> getListaForm() throws GooseFormException;

	void modificaForm(GooseFormDb form, String formId) throws GooseFormException;

	void eliminaForm(String formId) throws GooseFormException;

	boolean isFormEsistente (String formId) throws GooseFormException;



}
