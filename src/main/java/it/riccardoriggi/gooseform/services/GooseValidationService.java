package it.riccardoriggi.gooseform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.entity.GooseKeyValue;
import it.riccardoriggi.gooseform.entity.db.TComponentSpecific;
import it.riccardoriggi.gooseform.entity.db.TControl;
import it.riccardoriggi.gooseform.entity.db.TRender;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseValidationInterface;
import it.riccardoriggi.gooseform.mapper.GooseValidationMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseValidationService implements GooseValidationInterface {


	@Autowired
	GooseValidationMapper mapper;

	@Override
	public TComponentSpecific verificaAttributoPerComponente(String type, String k) throws GooseFormException{
		try {
			return mapper.verificaAttributoPerComponente(type,k);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public List<TComponentSpecific> listaAttributiPerComponente(String type) throws GooseFormException{
		try {
			return mapper.listaAttributiPerComponente(type);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public TControl verificaTipoControllo(String type, String k) throws GooseFormException{
		try {
			return mapper.verificaTipoControllo(type,k);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public List<TControl> listaTipoControlliSpecificoDatoControllo(String type) throws GooseFormException{
		try {
			return mapper.listaTipoControlliSpecificoDatoControllo(type);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public TRender verificaTipoRender(String type, String k) throws GooseFormException{
		try {
			return mapper.verificaTipoRender(type,k);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public List<TRender> listaTipoRenderSpecificoDatoRender(String type) throws GooseFormException{
		try {
			return mapper.listaTipoRenderSpecificoDatoRender(type);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public GooseKeyValue getPlaceholder(String type) throws GooseFormException{
		log.error(type);
		try {
			return mapper.getPlaceholder(type);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public boolean esisteTipoComponente(String type) throws GooseFormException{
		boolean esiste = false;
		try {
			esiste = mapper.listaAttributiPerComponente(type).size()>0;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public boolean esisteAttributoPerComponente(String type, String k) throws GooseFormException{
		boolean esiste=false;
		try {
			esiste = mapper.verificaAttributoPerComponente(type,k) != null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public boolean esisteTipoControllo(String type, String typeSpecific) throws GooseFormException{
		boolean esiste = false;
		try {
			esiste = mapper.verificaTipoControllo(type,typeSpecific)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}

	@Override
	public boolean esisteTipoRender(String type, String typeSpecific) throws GooseFormException{
		boolean esiste = false;
		try {
			esiste = mapper.verificaTipoRender(type,typeSpecific)!=null;
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_BUTTON: ", e);
		}
		return esiste;
	}
}
