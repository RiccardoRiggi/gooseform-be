package it.riccardoriggi.gooseform.interfaces;

import java.util.List;

import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseComponentiInterface {

	public void inserisciComponente(GooseComponentDb componente) throws GooseFormException;

	public void modificaComponente(GooseComponentDb componente, String formId, String id) throws GooseFormException;

	public void eliminaComponente(String formId, String id) throws GooseFormException;

	public GooseComponentDb getComponent(String formId, String id) throws GooseFormException;

	public List<GooseComponentDb> getComponenti(String formId) throws GooseFormException;

	boolean isComponenteEsistente(String formId, String componentId) throws GooseFormException;

	void eliminazioneMassiva(String formId) throws GooseFormException;






}
