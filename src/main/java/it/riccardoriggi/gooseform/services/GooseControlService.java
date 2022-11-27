package it.riccardoriggi.gooseform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GooseControlDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseControlInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKControlInterface;
import it.riccardoriggi.gooseform.mapper.GooseControlMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseControlService implements GooseControlInterface {

	@Autowired
	GooseControlMapper controlMapper;


	@Autowired
	GooseFormInterface formService;


	@Autowired
	GooseComponentiInterface componentService;


	@Autowired
	GooseValidationService validationService;


	@Autowired
	GooseKControlInterface kControlService;

	@Override
	public void inserisciControllo(GooseControlDb controllo) throws GooseFormException{

		if(controllo.getFormId()==null) {
			throw new GooseFormException(500, "Il campo formId è richiesto");
		}else if(!formService.isFormEsistente(controllo.getFormId())) {
			throw new GooseFormException(500, GooseErrors.FORM_NON_ESISTENTE);
		}else if(!validationService.esisteTipoControllo(controllo.getType(),controllo.getTypeSpecific())) {
			throw new GooseFormException(500, GooseErrors.CONTROLLO_NON_ESISTENTE);
		}

		if(controllo.getIdComponentA()!=null && !componentService.isComponenteEsistente(controllo.getFormId(), controllo.getIdComponentA())) {
			throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE_X+"A");
		}

		if(controllo.getIdComponentB()!=null && !componentService.isComponenteEsistente(controllo.getFormId(), controllo.getIdComponentB())) {
			throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE_X+"B");
		}



		try {
			controlMapper.inserisciControllo(controllo);
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
	public void modificaControllo(GooseControlDb controllo, int pk) throws GooseFormException{
		try {
			controlMapper.modificaControllo(controllo.getType(), controllo.getTypeSpecific(), controllo.getIdComponentA(), controllo.getIdComponentB(), controllo.getReferenceValue(), controllo.getErrorMessage(),pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void eliminaControllo(int pk) throws GooseFormException{
		try {
			controlMapper.eliminaControllo(pk);
			kControlService.elimina(pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public GooseControlDb getControllo(int pk) throws GooseFormException{
		try {
			return controlMapper.getControllo(pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public List<GooseControlDb> getControlli(String formId) throws GooseFormException{
		try {
			return controlMapper.getControlliByFormId(formId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public boolean esistonoControlli(String formId, String componentId) throws GooseFormException{
		boolean esiste=false;
		try {
			esiste = !controlMapper.getControlli(formId,componentId).isEmpty();
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public boolean esisteControllo(int pk) throws GooseFormException{
		boolean esiste=false;
		try {
			esiste = controlMapper.getControllo(pk)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_HTTP_REQUEST: ", e);
		}
		return esiste;
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) throws GooseFormException{
		try {

			if(componentId==null) {
				controlMapper.eliminaControlloByFormId(formId);
			}else {
				controlMapper.eliminaControlloByComponentId(formId, componentId);
			}

		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}

	}
}
