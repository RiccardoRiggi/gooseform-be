package it.riccardoriggi.gooseform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GooseRenderDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseRenderInterface;
import it.riccardoriggi.gooseform.mapper.GooseRenderMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseRenderService implements GooseRenderInterface {


	@Autowired
	GooseRenderMapper mapper;


	@Autowired
	GooseFormInterface formService;


	@Autowired
	GooseComponentiInterface componentService;


	@Autowired
	GooseValidationService validationService;

	@Override
	public void inserisciRender(GooseRenderDb controllo) throws GooseFormException{

		if(controllo.getFormId()==null) {
			throw new GooseFormException(500, "Il campo formId è richiesto");
		}else if(!formService.isFormEsistente(controllo.getFormId())) {
			throw new GooseFormException(500, GooseErrors.FORM_NON_ESISTENTE);
		}else if(!validationService.esisteTipoRender(controllo.getType(),controllo.getTypeSpecific())) {
			throw new GooseFormException(500, GooseErrors.CONTROLLO_NON_ESISTENTE);
		}

		if(controllo.getIdComponentA()!=null && !componentService.isComponenteEsistente(controllo.getFormId(), controllo.getIdComponentA())) {
			throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE_X+"A");
		}

		if(controllo.getIdComponentB()!=null && !componentService.isComponenteEsistente(controllo.getFormId(), controllo.getIdComponentB())) {
			throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE_X+"B");
		}

		if(controllo.getIdComponentC()!=null && !componentService.isComponenteEsistente(controllo.getFormId(), controllo.getIdComponentC())) {
			throw new GooseFormException(500, GooseErrors.COMPONENTE_NON_ESISTENTE_X+"C");
		}

		try {
			mapper.inserisciRender(controllo);
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
	public void modificaRender(GooseRenderDb controllo, int pk) throws GooseFormException{
		try {
			mapper.modificaRender(controllo.getType(), controllo.getTypeSpecific(), controllo.getIdComponentA(), controllo.getIdComponentB(), controllo.getIdComponentC(), controllo.getValue(),pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void eliminaRender(int pk) throws GooseFormException{
		try {
			mapper.eliminaRender(pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public GooseRenderDb getRender(int pk) throws GooseFormException{
		try {
			return mapper.getRender(pk);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public List<GooseRenderDb> getRenders(String formId) throws GooseFormException{
		try {
			return mapper.getRendersByFormId(formId);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public boolean esistonoRenders(String formId, String componentId) throws GooseFormException{
		boolean esiste=false;
		try {
			esiste = !mapper.getRenders(formId,componentId).isEmpty();
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public void eliminazioneMassiva(String formId, String componentId) throws GooseFormException{
		try {
			if(componentId==null) {
				mapper.eliminaControlloByFormId(formId);
			}else {
				mapper.eliminaControlloByComponentId(formId, componentId);
			}
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
		}

	}
}
