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

import it.riccardoriggi.gooseform.entity.db.GooseControlDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseControlInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/control")
public class ControlController {

	@Autowired
	private GooseControlInterface controlService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciControllo(HttpServletRequest request){
		log.debug("ControlController - inserisciControllo");

		ObjectMapper mapper = new ObjectMapper();
		GooseControlDb input = new GooseControlDb();

		try {
			input = mapper.readValue(request.getReader(), GooseControlDb.class);
			log.debug("body "+input);
			controlService.inserisciControllo(input);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/lista/{formId}")
	public ResponseEntity<Object> getControlli(HttpServletRequest request, @PathVariable("formId") String formId){
		log.debug("ControlController - getControlli");
		log.debug("formId "+formId);
		try {
			return new ResponseEntity<>( controlService.getControlli(formId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{pk}")
	public ResponseEntity<Object> getControllo(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("ControlController - getControllo");
		log.debug("pk "+pk);
		try {
			return new ResponseEntity<>( controlService.getControllo(pk),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modificaControllo(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("ControlController - modificaControllo");
		log.debug("pk "+pk);
		ObjectMapper mapper = new ObjectMapper();
		GooseControlDb input= new GooseControlDb();
		try {
			input = mapper.readValue(request.getReader(), GooseControlDb.class);
			log.debug("body "+input);
			controlService.modificaControllo(input,pk);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{pk}")
	public ResponseEntity<Object> eliminaControllo(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("ControlController - eliminaControllo");
		log.debug("pk "+pk);
		try {
			controlService.eliminaControllo(pk);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
