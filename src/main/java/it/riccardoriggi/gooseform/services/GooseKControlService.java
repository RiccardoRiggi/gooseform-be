package it.riccardoriggi.gooseform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.db.GooseKControlDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseControlInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKControlInterface;
import it.riccardoriggi.gooseform.mapper.GooseKControlMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GooseKControlService implements GooseKControlInterface {


	@Autowired
	GooseKControlMapper mapper;


	@Autowired
	GooseControlInterface serviceControl;

	@Override
	public void inserisci(GooseKControlDb kv) throws GooseFormException{

		if(!serviceControl.esisteControllo(kv.getPkControl())) {
			throw new GooseFormException(500, GooseErrors.CHIAMATA_HTTP_NON_ESISTENTE);
		}

		try {
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
	public List<GooseKControlDb> getLista(int pkHttp) throws GooseFormException{
		try {
			return mapper.getLista(pkHttp);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void elimina(int pkHttp, String k) throws GooseFormException{
		try {
			mapper.eliminaById(pkHttp,k);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}

	@Override
	public void elimina(int pkHttp) throws GooseFormException{
		try {
			mapper.elimina(pkHttp);
		} catch (Exception e) {
			log.error("Errore durante l'inserimento in GOOSE_FORM: ", e);
			throw new GooseFormException(500, e.getMessage());
		}
	}



}
