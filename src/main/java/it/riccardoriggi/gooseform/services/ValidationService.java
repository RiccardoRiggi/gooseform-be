package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseError;
import it.riccardoriggi.gooseform.interfaces.ValidationInterface;
import it.riccardoriggi.gooseform.mapper.ValidationMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidationService implements ValidationInterface {

	@Autowired
	ValidationMapper mapper;

	@Override
	public ResponseEntity<Object> verificaAttributoPerComponente(String type, String k) {
		try {
			return new ResponseEntity<Object>(mapper.verificaAttributoPerComponente(type,k),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> listaAttributiPerComponente(String type) {
		try {
			return new ResponseEntity<Object>(mapper.listaAttributiPerComponente(type),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> verificaTipoControllo(String type, String k) {
		try {
			return new ResponseEntity<Object>(mapper.verificaTipoControllo(type,k),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> listaTipoControlliSpecificoDatoControllo(String type) {
		try {
			return new ResponseEntity<Object>(mapper.listaTipoControlliSpecificoDatoControllo(type),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> verificaTipoRender(String type, String k) {
		try {
			return new ResponseEntity<Object>(mapper.verificaTipoRender(type,k),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> listaTipoRenderSpecificoDatoRender(String type) {
		try {
			return new ResponseEntity<Object>(mapper.listaTipoRenderSpecificoDatoRender(type),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseError(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
