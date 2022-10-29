package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseError;
import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.mapper.GooseComponentMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseComponentService implements GooseComponentiInterface{

	@Autowired
	GooseComponentMapper componentMapper;

	@Override
	public ResponseEntity<Object> inserisciComponente(GooseComponentDb componente) {
		try {
			componentMapper.inserisciComponent(componente);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> modificaComponente(GooseComponentDb componente, String formId, String id) {
		try {
			componentMapper.updateComponent(componente.getLabel(), componente.getWidthXl(), componente.getWidthLg(), componente.getWidthMd(), componente.getWidthSm(), componente.getWidth(), componente.isRequiredMark(), formId, id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaComponente(String formId, String id) {
		try {
			componentMapper.deleteComponent(formId,id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getComponent(String formId, String id) {
		try {
			return new ResponseEntity<Object>(componentMapper.getComponent(formId,id),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getComponenti(String formId) {
		try {
			return new ResponseEntity<Object>(componentMapper.getComponents(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseError(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
