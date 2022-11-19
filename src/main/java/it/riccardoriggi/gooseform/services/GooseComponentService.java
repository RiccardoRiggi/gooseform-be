package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseProblem;
import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.mapper.GooseComponentMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseComponentService implements GooseComponentiInterface{

	@Autowired
	GooseComponentMapper componentMapper;

	@Autowired
	GooseFormInterface formService;

	@Autowired
	GooseValidationService validationService;

	@Override
	public ResponseEntity<Object> inserisciComponente(GooseComponentDb componente) {

		if(componente.getFormId()==null) {
			return new ResponseEntity<Object>(new GooseProblem(500, "Il campo formId è richiesto"), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!formService.isFormEsistente(componente.getFormId())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.FORM_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}else if(!validationService.esisteTipoComponente(componente.getType())) {
			return new ResponseEntity<Object>(new GooseProblem(500, GooseErrors.TIPO_COMPONENTE_NON_ESISTENTE), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			componentMapper.inserisciComponent(componente);
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
	public ResponseEntity<Object> modificaComponente(GooseComponentDb componente, String formId, String id) {
		try {
			componentMapper.updateComponent(componente.getLabel(), componente.getWidthXl(), componente.getWidthLg(), componente.getWidthMd(), componente.getWidthSm(), componente.getWidth(), componente.isRequiredMark(), formId, id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> eliminaComponente(String formId, String id) {
		try {
			componentMapper.deleteComponent(formId,id);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getComponent(String formId, String id) {
		try {
			return new ResponseEntity<Object>(componentMapper.getComponent(formId,id),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getComponenti(String formId) {
		try {
			return new ResponseEntity<Object>(componentMapper.getComponents(formId),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			return new ResponseEntity<Object>(new GooseProblem(500,e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public boolean isComponenteEsistente(String formId, String componentId) {
		log.info("formId: "+formId);
		log.info("componentId: "+componentId);
		boolean esiste = false;
		try {
			esiste = componentMapper.getComponent(formId,componentId)!=null;
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_COMPONENT: ",e);
		}
		log.info("Esiste il componente: "+esiste);
		return esiste;
	}

}
