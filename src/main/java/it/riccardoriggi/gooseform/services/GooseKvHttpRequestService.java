package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.entity.db.GooseKvHttpRequestDb;
import it.riccardoriggi.gooseform.interfaces.GooseHttpRequestInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKvHttpRequestInterface;
import it.riccardoriggi.gooseform.mapper.GooseKvHttpRequestMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseKvHttpRequestService implements GooseKvHttpRequestInterface {


	@Autowired
	GooseKvHttpRequestMapper mapper;


	@Autowired
	GooseHttpRequestInterface serviceChiamata;

	@Override
	public ResponseEntity<Object> inserisci(GooseKvHttpRequestDb kv) {

		if(!serviceChiamata.esisteChiamata(kv.getPkHttp())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.CHIAMATA_HTTP_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			mapper.inserisci(kv);
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
	public ResponseEntity<Object> getLista(int pkHttp) {
		try {
			return new ResponseEntity<Object>(mapper.getLista(pkHttp),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> elimina(int pkHttp, String k) {
		try {
			mapper.eliminaById(pkHttp,k);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> elimina(int pkHttp) {
		try {
			mapper.elimina(pkHttp);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
