package it.riccardoriggi.gooseform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GooseKvComponentDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKvComponentInterface;
import it.riccardoriggi.gooseform.mapper.GooseKvComponentMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseKvComponentService implements GooseKvComponentInterface {


	@Autowired
	GooseKvComponentMapper mapper;


	@Autowired
	GooseFormInterface formService;


	@Autowired
	GooseComponentiInterface componentService;

	@Override
	public void inserisci(GooseKvComponentDb kv) throws GooseFormException{
		try {

			if(kv.getFormId()==null) {
				throw new GooseFormException(500, "Il campo formId è richiesto");
			}else if(!formService.isFormEsistente(kv.getFormId())) {
				throw new GooseFormException(500, GooseErrors.FORM_NON_ESISTENTE);
			}else if(kv.getComponentId() != null && !componentService.isComponenteEsistente(kv.getFormId(), kv.getComponentId())) {
				throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE);
			}

			mapper.inserisci(kv);
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
	public List<GooseKvComponentDb> getLista(String formId, String componentId) throws GooseFormException{
		try {
			return mapper.getLista(formId,componentId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void elimina(String formId, String componentId, String k) throws GooseFormException{
		try {
			mapper.elimina(formId,componentId,k);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) throws GooseFormException{

		try {
			if(componentId==null) {
				mapper.eliminaByFormId(formId);
			}else {
				mapper.eliminaByComponentId(formId, componentId);
			}
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
		}

	}



}
