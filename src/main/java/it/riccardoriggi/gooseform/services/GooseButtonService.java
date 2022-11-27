package it.riccardoriggi.gooseform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GooseButtonDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseButtonInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.mapper.GooseButtonMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseButtonService implements GooseButtonInterface{


	@Autowired
	GooseButtonMapper buttonMapper;


	@Autowired
	GooseFormInterface formService;

	@Override
	public void inserisciButton(GooseButtonDb button) throws GooseFormException{

		if(button.getFormId()==null) {
			throw new GooseFormException(500, "Il campo formId è richiesto");
		}else if(!formService.isFormEsistente(button.getFormId())) {
			throw new GooseFormException(500, GooseErrors.FORM_NON_ESISTENTE);
		}

		try {
			buttonMapper.inserisciButton(button);
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
	public GooseButtonDb getButton(String formId, String type) throws GooseFormException{
		try {
			return buttonMapper.getButton(formId,type);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public void modificaButton(GooseButtonDb button, String type, String formId) throws GooseFormException{
		try {
			buttonMapper.updateButton(button.getTitle(), button.getIcon(),type, formId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public void eliminaButton(String formId, String type) throws GooseFormException{
		try {
			buttonMapper.deleteButton(formId,type);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
			throw new GooseFormException(500,e.getMessage());
		}
	}

	@Override
	public void eliminazioneMassiva(String formId) throws GooseFormException{
		try {
			buttonMapper.deleteButtonByFormId(formId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ",e);
		}
	}


}
