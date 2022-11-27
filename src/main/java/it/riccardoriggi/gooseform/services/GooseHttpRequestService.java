package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GooseHttpRequestDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseHttpRequestInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKvHttpRequestInterface;
import it.riccardoriggi.gooseform.mapper.GooseHttpRequestMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseHttpRequestService implements GooseHttpRequestInterface {


	@Autowired
	GooseHttpRequestMapper chiamataMapper;


	@Autowired
	GooseFormInterface formService;


	@Autowired
	GooseComponentiInterface componentService;


	@Autowired
	GooseKvHttpRequestInterface kvHttpService;

	@Override
	public void inserisciChiamata(GooseHttpRequestDb chiamata) throws GooseFormException{

		if(chiamata.getFormId()==null) {
			throw new GooseFormException(500, "Il campo formId è richiesto");
		}else if(!formService.isFormEsistente(chiamata.getFormId())) {
			throw new GooseFormException(500, GooseErrors.FORM_NON_ESISTENTE);
		}else if(chiamata.getComponentId() != null && !componentService.isComponenteEsistente(chiamata.getFormId(), chiamata.getComponentId())) {
			throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE);
		}else if(isChiamataEsistente(chiamata.getFormId(), chiamata.getComponentId())) {
			throw new GooseFormException(500, "CHIAMATA ESISTENTE");
		}

		try {
			chiamataMapper.inserisciChiamata(chiamata);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			if(e.getMessage().contains("SQLIntegrityConstraintViolationException")){
				throw new GooseFormException(500, "Chiave primaria duplicata");
			}else {
				throw new GooseFormException(500, e.getMessage());
			}
		}
	}

	@Override
	public void modificaChiamata(GooseHttpRequestDb chiamata, int pk) throws GooseFormException{
		try {
			chiamataMapper.updateChiamata(chiamata.getUrl(), chiamata.getMethod(), chiamata.getBody(), pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void eliminaChiamata(int pk) throws GooseFormException{
		try {
			kvHttpService.elimina(pk);
			chiamataMapper.deleteChiamata(pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public GooseHttpRequestDb getChiamataById(String formId, String componentId) throws GooseFormException{
		try {
			return chiamataMapper.getChiamataById(formId, componentId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public boolean isChiamataEsistente(String formId, String componentId) throws GooseFormException{
		boolean esiste = false;
		try {
			esiste = chiamataMapper.getChiamataById(formId, componentId) != null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
		}
		return esiste;
	}

	@Override
	public GooseHttpRequestDb getChiamataByFormId(String formId, String typeSpecific) throws GooseFormException{
		try {
			return chiamataMapper.getChiamataByFormId(formId, typeSpecific);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public GooseHttpRequestDb getChiamataByPk(int pk) throws GooseFormException {
		try {
			return chiamataMapper.getChiamataByPk(pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public boolean esisteChiamata(int pk) throws GooseFormException{
		boolean esiste=false;
		try {
			esiste = chiamataMapper.getChiamataByPk(pk)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_HTTP_REQUEST: ", e);
		}
		return esiste;
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) throws GooseFormException{
		try {

			if(componentId==null) {
				chiamataMapper.deleteChiamataByFormId(formId);
			}else {
				chiamataMapper.deleteChiamataByComponentId(formId, componentId);
			}

		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
		}
	}



}
