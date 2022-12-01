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

import it.riccardoriggi.gooseform.entity.db.GooseFormDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.services.GooseFormService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/form")
public class FormController {

	@Autowired
	private GooseFormService formService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciForm(HttpServletRequest request){
		log.debug("FormController - inserisciForm");

		ObjectMapper mapper = new ObjectMapper();
		GooseFormDb formInput = new GooseFormDb();

		try {
			formInput = mapper.readValue(request.getReader(), GooseFormDb.class);
			log.debug("body "+formInput);
			formService.inserisciForm(formInput);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}")
	public ResponseEntity<Object> getFormById(HttpServletRequest request, @PathVariable("formId") String formId){
		log.debug("FormController - getFormById");
		log.debug("formId "+formId);
		try {
			return new ResponseEntity<>( formService.getFormById(formId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/")
	public ResponseEntity<Object> getForms(HttpServletRequest request){
		log.debug("FormController - getForms");
		try {
			return new ResponseEntity<>( formService.getListaForm(),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifica/{formId}")
	public ResponseEntity<Object> modificaForm(HttpServletRequest request, @PathVariable("formId") String formId){
		log.debug("FormController - modificaForm");
		log.debug("formId "+formId);
		ObjectMapper mapper = new ObjectMapper();
		GooseFormDb formInput = new GooseFormDb();

		try {
			formInput = mapper.readValue(request.getReader(), GooseFormDb.class);
			log.debug("body: "+formInput);
			formService.modificaForm(formInput,formId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{formId}")
	public ResponseEntity<Object> eliminaFormById(HttpServletRequest request, @PathVariable("formId") String formId){
		log.debug("FormController - eliminaFormById");
		log.debug("formId "+formId);
		try {
			formService.eliminaForm(formId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
