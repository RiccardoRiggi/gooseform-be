package it.riccardoriggi.gooseform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.db.GooseFormDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseButtonInterface;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseControlInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseHttpRequestInterface;
import it.riccardoriggi.gooseform.interfaces.GoosePopupInterface;
import it.riccardoriggi.gooseform.interfaces.GooseRenderInterface;
import it.riccardoriggi.gooseform.mapper.GooseFormMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseFormService implements GooseFormInterface {


	@Autowired
	GooseFormMapper formMapper;


	@Autowired
	GooseComponentiInterface componentiService;


	@Autowired
	GooseRenderInterface renderService;


	@Autowired
	GooseControlInterface controlService;


	@Autowired
	GooseButtonInterface buttonService;


	@Autowired
	GoosePopupInterface popupService;


	@Autowired
	GooseHttpRequestInterface httpService;



	@Override
	public boolean isFormEsistente(String formId) throws GooseFormException{
		boolean esiste = false;
		try {
			esiste = formMapper.getFormById(formId) != null;
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ", e);
		}
		return esiste;
	}

	@Override
	public void inserisciForm(GooseFormDb form) throws GooseFormException{
		try {
			formMapper.inserisciForm(form);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			if (e.getMessage().contains("SQLIntegrityConstraintViolationException")) {
				throw new GooseFormException(500, "Chiave primaria duplicata");
			} else {
				throw new GooseFormException(500, e.getMessage());
			}
		}

	}

	@Override
	public GooseFormDb getFormById(String formId) throws GooseFormException{
		try {
			return formMapper.getFormById(formId);
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}

	}

	@Override
	public List<GooseFormDb> getListaForm() throws GooseFormException{
		try {
			return formMapper.getForms();
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void modificaForm(GooseFormDb form, String formId) throws GooseFormException{
		try {
			formMapper.updateForm(form.getTitle(), form.getIcon(), form.getDescription(), formId);
		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void eliminaForm(String formId) throws GooseFormException{
		try {

			componentiService.eliminazioneMassiva(formId);
			controlService.eliminazioneMassiva(formId, null);
			renderService.eliminazioneMassiva(formId, null);
			buttonService.eliminazioneMassiva(formId);
			popupService.eliminazioneMassiva(formId, null);
			httpService.eliminazioneMassiva(formId, null);
			formMapper.deleteForm(formId);

		} catch (Exception e) {
			log.error("Errore durante la ricerca in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}

	}

}
