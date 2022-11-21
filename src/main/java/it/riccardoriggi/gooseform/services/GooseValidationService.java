package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.interfaces.GooseValidationInterface;
import it.riccardoriggi.gooseform.mapper.GooseValidationMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseValidationService implements GooseValidationInterface {


	@Autowired
	GooseValidationMapper mapper;

	@Override
	public ResponseEntity<Object> verificaAttributoPerComponente(String type, String k) {
		try {
			return new ResponseEntity<Object>(mapper.verificaAttributoPerComponente(type,k),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> listaAttributiPerComponente(String type) {
		try {
			return new ResponseEntity<Object>(mapper.listaAttributiPerComponente(type),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> verificaTipoControllo(String type, String k) {
		try {
			return new ResponseEntity<Object>(mapper.verificaTipoControllo(type,k),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> listaTipoControlliSpecificoDatoControllo(String type) {
		try {
			return new ResponseEntity<Object>(mapper.listaTipoControlliSpecificoDatoControllo(type),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> verificaTipoRender(String type, String k) {
		try {
			return new ResponseEntity<Object>(mapper.verificaTipoRender(type,k),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> listaTipoRenderSpecificoDatoRender(String type) {
		try {
			return new ResponseEntity<Object>(mapper.listaTipoRenderSpecificoDatoRender(type),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getPlaceholder(String type) {
		log.error(type);
		try {
			return new ResponseEntity<Object>(mapper.getPlaceholder(type),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			return new ResponseEntity<Object>(new GooseProblem(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public boolean esisteTipoComponente(String type) {
		boolean esiste = false;
		try {
			esiste = mapper.listaAttributiPerComponente(type).size()>0;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public boolean esisteAttributoPerComponente(String type, String k) {
		boolean esiste=false;
		try {
			esiste = mapper.verificaAttributoPerComponente(type,k) != null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public boolean esisteTipoControllo(String type, String typeSpecific) {
		boolean esiste = false;
		try {
			esiste = mapper.verificaTipoControllo(type,typeSpecific)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public boolean esisteTipoRender(String type, String typeSpecific) {
		boolean esiste = false;
		try {
			esiste = mapper.verificaTipoRender(type,typeSpecific)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}
}
