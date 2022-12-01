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
	public ResponseEntity<Object> inserisci(HttpServletRequest request){
		log.debug("PopupController - inserisci");
		ObjectMapper mapper = new ObjectMapper();
		GoosePopupDb input = new GoosePopupDb();

		try {
			input = mapper.readValue(request.getReader(), GoosePopupDb.class);
			log.debug("body "+input);
			popupService.inserisciPopup(input);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}")
	public ResponseEntity<Object> getPopupByFormId(HttpServletRequest request, @PathVariable("formId") String formId){
		log.debug("PopupController - getPopupByFormId");
		log.debug("formId "+formId);
		try {
			return new ResponseEntity<>( popupService.getPopupByFormId(formId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{componentId}")
	public ResponseEntity<Object> getPopupById(HttpServletRequest request, @PathVariable("componentId") String componentId, @PathVariable("formId") String formId){
		log.debug("PopupController - getPopupByFormId");
		log.debug("formId "+formId);
		log.debug("componentId "+componentId);
		try {
			return new ResponseEntity<>(popupService.getPopupById(formId,componentId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modificaPopup(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("PopupController - modificaPopup");
		log.debug("pk "+pk);
		ObjectMapper mapper = new ObjectMapper();
		GoosePopupDb input= new GoosePopupDb();

		try {
			input = mapper.readValue(request.getReader(), GoosePopupDb.class);
			log.debug("body "+input);
			popupService.modificaPopup(input,pk);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{pk}")
	public ResponseEntity<Object> eliminaPopup(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("PopupController - eliminaPopup");
		log.debug("pk "+pk);
		try {
			popupService.eliminaPopup(pk);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
