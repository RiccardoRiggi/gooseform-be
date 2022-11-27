package it.riccardoriggi.gooseform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;
import it.riccardoriggi.gooseform.entity.db.GooseComponentSpecificDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseComponentSpecificiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseValidationInterface;
import it.riccardoriggi.gooseform.mapper.GooseComponentSpecificMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseComponentSpecificService implements GooseComponentSpecificiInterface {


	@Autowired
	GooseComponentSpecificMapper componentSpecificMapper;


	@Autowired
	GooseComponentiInterface componentService;


	@Autowired
	GooseValidationInterface validationService;

	@Override
	public void insericiRiga(GooseComponentSpecificDb riga) throws GooseFormException{

		if(riga.getFormId()==null || riga.getId()==null) {
			throw new GooseFormException(500, "Il campo formId è richiesto");
		}else if(!componentService.isComponenteEsistente(riga.getFormId(), riga.getId())) {
			throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE);
		}


		GooseComponentDb componente = componentService.getComponent(riga.getFormId(), riga.getId());

		if(riga.getNomeAttributo() == null || !validationService.esisteAttributoPerComponente(componente.getType(), riga.getNomeAttributo())) {
			throw new GooseFormException(500, GooseErrors.ATTRIBUTO_NON_ESISTENTE);
		}

		try {
			componentSpecificMapper.inserisciRiga(riga);
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
	public void eliminaRiga(String formId, String id, String nomeAttributo) throws GooseFormException{
		try {
			componentSpecificMapper.deleteRiga(formId, id, nomeAttributo);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public GooseComponentSpecificDb getRiga(String formId, String id, String nomeAttributo) throws GooseFormException{
		try {
			return componentSpecificMapper.getRiga(formId,id,nomeAttributo);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public List<GooseComponentSpecificDb> getRighe(String formId, String id) throws GooseFormException{
		try {
			return componentSpecificMapper.getRighe(formId,id);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) throws GooseFormException{
		try {

			if(componentId==null) {
				componentSpecificMapper.deleteRigaByFormId(formId);
			}else {
				componentSpecificMapper.deleteRigaByComponentId(formId, componentId);
			}

		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}

	}

}
