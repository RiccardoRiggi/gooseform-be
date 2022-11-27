package it.riccardoriggi.gooseform.interfaces;

import it.riccardoriggi.gooseform.entity.db.GooseHttpRequestDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;

public interface GooseHttpRequestInterface {

	void inserisciChiamata(GooseHttpRequestDb chiamata) throws GooseFormException;

	void modificaChiamata(GooseHttpRequestDb chiamata, int id) throws GooseFormException;

	void eliminaChiamata(int id) throws GooseFormException;

	GooseHttpRequestDb getChiamataById(String formId, String componentId) throws GooseFormException;

	GooseHttpRequestDb getChiamataByFormId(String formId, String typeSpecific) throws GooseFormException;

	GooseHttpRequestDb getChiamataByPk(int pk) throws GooseFormException;

	boolean esisteChiamata(int pk) throws GooseFormException;

	void eliminazioneMassiva(String formId, String componentId) throws GooseFormException;

	boolean isChiamataEsistente(String formId, String componentId) throws GooseFormException;

}
