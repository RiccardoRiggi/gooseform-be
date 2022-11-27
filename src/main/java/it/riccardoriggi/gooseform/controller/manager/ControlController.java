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
	public ResponseEntity<Object> inserisciForm(HttpServletRequest request){

		ObjectMapper mapper = new ObjectMapper();
		GooseControlDb buttonInput = new GooseControlDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GooseControlDb.class);
			controlService.inserisciControllo(buttonInput);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/lista/{formId}")
	public ResponseEntity<Object> getComponents(HttpServletRequest request, @PathVariable("formId") String formId){
		try {
			return new ResponseEntity<Object>( controlService.getControlli(formId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{pk}")
	public ResponseEntity<Object> getComponents(HttpServletRequest request, @PathVariable("pk") int pk){
		try {
			return new ResponseEntity<Object>( controlService.getControllo(pk),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modificaButton(HttpServletRequest request, @PathVariable("pk") int pk){
		ObjectMapper mapper = new ObjectMapper();
		GooseControlDb buttonInput= new GooseControlDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GooseControlDb.class);
			controlService.modificaControllo(buttonInput,pk);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{pk}")
	public ResponseEntity<Object> eliminaButton(HttpServletRequest request, @PathVariable("pk") int pk){
		try {
			controlService.eliminaControllo(pk);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
