package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.entity.db.GooseHttpRequestDb;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseHttpRequestInterface;
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

	@Override
	public ResponseEntity<Object> inserisciChiamata(GooseHttpRequestDb chiamata) {

		if(chiamata.getFormId()==null) {
			return new ResponseEntity<Object>(new GooseProblem(500, "Il campo formId è richiesto"), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!formService.isFormEsistente(chiamata.getFormId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.FORM_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(chiamata.getComponentId() != null && !componentService.isComponenteEsistente(chiamata.getFormId(), chiamata.getComponentId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.COMPONENTE_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			chiamataMapper.inserisciChiamata(chiamata);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			if(e.getMessage().contains("SQLIntegrityConstraintViolationException")){
				return new ResponseEntity<Object>(new GooseProblem(500, "Chiave primaria duplicata"), HttpStatus.INTERNAL_SERVER_ERROR);
			}else {
				return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@Override
	public ResponseEntity<Object> modificaChiamata(GooseHttpRequestDb chiamata, int pk) {
		try {
			chiamataMapper.updateChiamata(chiamata.getUrl(), chiamata.getMethod(), chiamata.getBody(), pk);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaChiamata(int pk) {
		try {
			chiamataMapper.deleteChiamata(pk);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getChiamataById(String formId, String componentId) {
		try {
			return new ResponseEntity<Object>(chiamataMapper.getChiamataById(formId, componentId), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getChiamataByFormId(String formId) {
		try {
			return new ResponseEntity<Object>(chiamataMapper.getChiamataByFormId(formId), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getChiamataByPk(int pk) {
		try {
			return new ResponseEntity<Object>(chiamataMapper.getChiamataByPk(pk), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public boolean esisteChiamata(int pk) {
		boolean esiste=false;
		try {
			esiste = chiamataMapper.getChiamataByPk(pk)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_HTTP_REQUEST: ", e);
		}
		return esiste;
	}

}
