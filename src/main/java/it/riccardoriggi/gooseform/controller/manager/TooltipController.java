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

import it.riccardoriggi.gooseform.entity.db.GooseTooltipDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseTooltipInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/tooltip")
public class TooltipController {

	@Autowired
	private GooseTooltipInterface tooltipService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisci(HttpServletRequest request){
		log.debug("TooltipController - inserisci");
		ObjectMapper mapper = new ObjectMapper();
		GooseTooltipDb input = new GooseTooltipDb();

		try {
			input = mapper.readValue(request.getReader(), GooseTooltipDb.class);
			log.debug("body "+input);
			tooltipService.inserisciTooltip(input);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}")
	public ResponseEntity<Object> getTooltipByFormId(HttpServletRequest request, @PathVariable("formId") String formId){
		log.debug("TooltipController - getTooltipByFormId");
		log.debug("formId "+formId);
		try {
			return new ResponseEntity<>( tooltipService.getTooltipByFormId(formId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{componentId}")
	public ResponseEntity<Object> getFormById(HttpServletRequest request, @PathVariable("componentId") String componentId, @PathVariable("formId") String formId){
		log.debug("TooltipController - getFormById");
		log.debug("formId "+formId);
		log.debug("componentId "+componentId);
		try {
			return new ResponseEntity<>( tooltipService.getTooltipById(formId,componentId),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modifica(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("TooltipController - modifica");
		log.debug("pk "+pk);
		ObjectMapper mapper = new ObjectMapper();
		GooseTooltipDb input= new GooseTooltipDb();
		try {
			input = mapper.readValue(request.getReader(), GooseTooltipDb.class);
			log.debug("body: "+input);
			tooltipService.modificaTooltip(input,pk);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{pk}")
	public ResponseEntity<Object> elimina(HttpServletRequest request, @PathVariable("pk") int pk){
		log.debug("TooltipController - elimina");
		log.debug("pk "+pk);
		try {
			tooltipService.eliminaTooltip(pk);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
