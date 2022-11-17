package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseError;
import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;
import it.riccardoriggi.gooseform.entity.db.GooseKvComponentDb;
import it.riccardoriggi.gooseform.interfaces.GooseKvComponentInterface;
import it.riccardoriggi.gooseform.mapper.GooseComponentMapper;
import it.riccardoriggi.gooseform.mapper.GooseKvComponentMapper;
import it.riccardoriggi.gooseform.mapper.ValidationMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseKvComponentService implements GooseKvComponentInterface {

	@Autowired
	GooseKvComponentMapper mapper;

	@Autowired
	GooseComponentMapper mapperComponenti;

	@Autowired
	ValidationMapper mapperValidazione;

	@Override
	public ResponseEntity<Object> inserisci(GooseKvComponentDb kv) {
		try {

			GooseComponentDb componente = mapperComponenti.getComponent(kv.getFormId(), kv.getComponentId());

			if(componente==null) {
				return new ResponseEntity<Object>("Componente non trovato!",HttpStatus.INTERNAL_SERVER_ERROR);
			}

			if(mapperValidazione.verificaAttributoPerComponente(componente.getType(), kv.getK())==null) {
				return new ResponseEntity<Object>("Attributo non supportato!",HttpStatus.INTERNAL_SERVER_ERROR);
			}

			mapper.inserisci(kv);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getLista(String formId, String componentId) {
		try {
			return new ResponseEntity<Object>(mapper.getLista(formId,componentId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> elimina(String formId, String componentId, String k) {
		try {
			mapper.elimina(formId,componentId,k);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
