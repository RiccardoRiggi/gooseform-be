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
	public ResponseEntity<Object> inserisciForm(HttpServletRequest request){

		ObjectMapper mapper = new ObjectMapper();
		GooseHttpRequestDb formInput = new GooseHttpRequestDb();

		try {
			formInput = mapper.readValue(request.getReader(), GooseHttpRequestDb.class);
			chiamataService.inserisciChiamata(formInput);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/pk/{pk}")
	public ResponseEntity<Object> getChiamataByPk(HttpServletRequest request, @PathVariable("pk") int pk){
		try {
			return new ResponseEntity<Object>( chiamataService.getChiamataByPk(pk), HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{componentId}")
	public ResponseEntity<Object> getChiamataById(HttpServletRequest request,@PathVariable("formId") String formId,@PathVariable("componentId") String componentId){
		try {
			return new ResponseEntity<Object>( chiamataService.getChiamataById(formId, componentId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/form/{typeSpecific}/{formId}")
	public ResponseEntity<Object> getChiamataByFormId(HttpServletRequest request,@PathVariable("formId") String formId, @PathVariable("typeSpecific") String typeSpecific){
		try {
			return new ResponseEntity<Object>( chiamataService.getChiamataByFormId(formId,typeSpecific),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modificaForm(HttpServletRequest request, @PathVariable("pk") int pk){
		ObjectMapper mapper = new ObjectMapper();
		GooseHttpRequestDb formInput = new GooseHttpRequestDb();

		try {
			formInput = mapper.readValue(request.getReader(), GooseHttpRequestDb.class);
			chiamataService.modificaChiamata(formInput,pk);
			return new ResponseEntity<Object>( HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{pk}")
	public ResponseEntity<Object> eliminaFormByPk(HttpServletRequest request, @PathVariable("pk") int pk){
		try {
			chiamataService.eliminaChiamata(pk);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
