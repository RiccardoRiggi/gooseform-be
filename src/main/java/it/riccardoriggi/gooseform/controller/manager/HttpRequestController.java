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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.riccardoriggi.gooseform.entity.db.GooseHttpRequestDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseHttpRequestInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/http")
public class HttpRequestController {

	@Autowired
	private GooseHttpRequestInterface chiamataService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciChiamata(HttpServletRequest request){
		log.debug("HttpRequestController - inserisciChiamata");

		ObjectMapper mapper = new ObjectMapper();
		GooseHttpRequestDb input = new GooseHttpRequestDb();

		try {
			input = mapper.readValue(request.getReader(), GooseHttpRequestDb.class);
			log.debug("body: "+input);
			chiamataService.inserisciChiamata(input);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/pk/{pk}")
	public ResponseEntity<Object> getChiamataByPk(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("HttpRequestController - inserisciChiamata");
		log.debug("pk "+pk);
		try {
			return new ResponseEntity<>( chiamataService.getChiamataByPk(pk), HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{componentId}")
	public ResponseEntity<Object> getChiamataById(HttpServletRequest request,@PathVariable("formId") String formId,@PathVariable("componentId") String componentId){
		log.debug("HttpRequestController - getChiamataById");
		log.debug("formId "+formId);
		log.debug("componentId "+componentId);
		try {
			return new ResponseEntity<>( chiamataService.getChiamataById(formId, componentId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/form/{typeSpecific}/{formId}")
	public ResponseEntity<Object> getChiamataByFormId(HttpServletRequest request,@PathVariable("formId") String formId, @PathVariable("typeSpecific") String typeSpecific){
		log.debug("HttpRequestController - getChiamataByFormId");
		log.debug("formId "+formId);
		log.debug("typeSpecific "+typeSpecific);
		try {
			return new ResponseEntity<>( chiamataService.getChiamataByFormId(formId,typeSpecific),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modificaForm(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("HttpRequestController - modificaForm");
		log.debug("pk "+pk);
		ObjectMapper mapper = new ObjectMapper();
		GooseHttpRequestDb input = new GooseHttpRequestDb();

		try {
			input = mapper.readValue(request.getReader(), GooseHttpRequestDb.class);
			log.debug("body: "+input);
			chiamataService.modificaChiamata(input,pk);
			return new ResponseEntity<>( HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{pk}")
	public ResponseEntity<Object> eliminaFormByPk(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("HttpRequestController - eliminaFormByPk");
		log.debug("pk "+pk);
		try {
			chiamataService.eliminaChiamata(pk);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
