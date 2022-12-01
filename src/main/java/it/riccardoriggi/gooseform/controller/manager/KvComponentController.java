package it.riccardoriggi.gooseform.controller.manager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.riccardoriggi.gooseform.entity.db.GooseKvComponentDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseKvComponentInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/kv-component")
public class KvComponentController {

	@Autowired
	private GooseKvComponentInterface service;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisci(HttpServletRequest request){
		log.debug("KvComponentController - inserisci");
		ObjectMapper mapper = new ObjectMapper();
		GooseKvComponentDb input = new GooseKvComponentDb();

		try {
			input = mapper.readValue(request.getReader(), GooseKvComponentDb.class);
			log.debug("body: "+input);
			service.inserisci(input);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{componentId}")
	public ResponseEntity<Object> get(HttpServletRequest request,@PathVariable("formId") String formId,@PathVariable("componentId") String componentId){
		log.debug("KvComponentController - get");
		log.debug("formId "+formId);
		log.debug("componentId "+componentId);
		try {
			return new ResponseEntity<>( service.getLista(formId, componentId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@DeleteMapping("/elimina/{formId}/{componentId}/{k}")
	public ResponseEntity<Object> eliminaFormByPk(HttpServletRequest request, @PathVariable("formId") String formId,@PathVariable("componentId") String componentId,@PathVariable("k") String k){
		log.debug("KvComponentController - get");
		log.debug("formId "+formId);
		log.debug("componentId "+componentId);
		log.debug("k "+k);
		try {
			service.elimina(formId,componentId,k);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
