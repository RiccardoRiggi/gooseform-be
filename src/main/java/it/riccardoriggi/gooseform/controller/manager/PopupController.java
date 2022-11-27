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

import it.riccardoriggi.gooseform.entity.db.GoosePopupDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.services.GoosePopupService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/popup")
public class PopupController {

	@Autowired
	private GoosePopupService popupService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciForm(HttpServletRequest request){

		ObjectMapper mapper = new ObjectMapper();
		GoosePopupDb buttonInput = new GoosePopupDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GoosePopupDb.class);
			popupService.inserisciPopup(buttonInput);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}")
	public ResponseEntity<Object> getPopupByFormId(HttpServletRequest request, @PathVariable("formId") String formId){
		try {
			return new ResponseEntity<Object>( popupService.getPopupByFormId(formId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{componentId}")
	public ResponseEntity<Object> getPopupById(HttpServletRequest request, @PathVariable("componentId") String componentId, @PathVariable("formId") String formId){
		try {
			return new ResponseEntity<Object>(popupService.getPopupById(formId,componentId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modificaButton(HttpServletRequest request, @PathVariable("pk") int pk){
		ObjectMapper mapper = new ObjectMapper();
		GoosePopupDb buttonInput= new GoosePopupDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GoosePopupDb.class);
			popupService.modificaPopup(buttonInput,pk);
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
			popupService.eliminaPopup(pk);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
