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

import it.riccardoriggi.gooseform.entity.db.GooseComponentSpecificDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.services.GooseComponentSpecificService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/component-specific")
public class ComponentSpecificController {

	@Autowired
	private GooseComponentSpecificService componentSpecificService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciComponentSpecific(HttpServletRequest request){
		log.debug("ComponentSpecificController - inserisciComponentSpecific");

		ObjectMapper mapper = new ObjectMapper();
		GooseComponentSpecificDb input = new GooseComponentSpecificDb();

		try {
			input = mapper.readValue(request.getReader(), GooseComponentSpecificDb.class);
			log.debug("body: "+input);
			componentSpecificService.insericiRiga(input);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{id}/{nomeAttributo}")
	public ResponseEntity<Object> getRiga(HttpServletRequest request, @PathVariable("id") String id, @PathVariable("formId") String formId, @PathVariable("nomeAttributo") String nomeAttributo){
		log.debug("ComponentSpecificController - getRiga");
		log.debug("id "+id);
		log.debug("formId "+formId);
		log.debug("nomeAttributo "+nomeAttributo);
		try {
			return new ResponseEntity<>( componentSpecificService.getRiga(formId,id,nomeAttributo),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{id}")
	public ResponseEntity<Object> getRighe(HttpServletRequest request, @PathVariable("formId") String formId, @PathVariable("id") String id){
		log.debug("ComponentSpecificController - getRighe");
		log.debug("id "+id);
		log.debug("formId "+formId);
		try {
			return new ResponseEntity<>( componentSpecificService.getRighe(formId,id),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{formId}/{id}/{nomeAttributo}")
	public ResponseEntity<Object> eliminaRiga(HttpServletRequest request, @PathVariable("id") String id, @PathVariable("formId") String formId, @PathVariable("nomeAttributo") String nomeAttributo){
		log.debug("ComponentSpecificController - eliminaRiga");
		log.debug("id "+id);
		log.debug("formId "+formId);
		log.debug("nomeAttributo "+nomeAttributo);
		try {
			componentSpecificService.eliminaRiga(formId,id,nomeAttributo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
