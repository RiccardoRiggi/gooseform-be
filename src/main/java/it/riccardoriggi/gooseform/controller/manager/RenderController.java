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

import it.riccardoriggi.gooseform.entity.db.GooseRenderDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseRenderInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/render")
public class RenderController {

	@Autowired
	private GooseRenderInterface service;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciRender(HttpServletRequest request){
		log.debug("RenderController - inserisciRender");
		ObjectMapper mapper = new ObjectMapper();
		GooseRenderDb input = new GooseRenderDb();

		try {
			input = mapper.readValue(request.getReader(), GooseRenderDb.class);
			log.debug("body "+input);
			service.inserisciRender(input);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/lista/{formId}")
	public ResponseEntity<Object> getRenders(HttpServletRequest request, @PathVariable("formId") String formId){
		log.debug("RenderController - getRenders");
		log.debug("formId "+formId);
		try {
			return new ResponseEntity<>( service.getRenders(formId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{pk}")
	public ResponseEntity<Object> getRender(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("RenderController - getRenders");
		log.debug("pk "+pk);
		try {
			return new ResponseEntity<>( service.getRender(pk),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modificaRender(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("RenderController - modificaRender");
		log.debug("pk "+pk);
		ObjectMapper mapper = new ObjectMapper();
		GooseRenderDb input= new GooseRenderDb();

		try {
			input = mapper.readValue(request.getReader(), GooseRenderDb.class);
			log.debug("body "+input);
			service.modificaRender(input,pk);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{pk}")
	public ResponseEntity<Object> eliminaRender(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("RenderController - eliminaRender");
		log.debug("pk "+pk);
		try {
			service.eliminaRender(pk);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
