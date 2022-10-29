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

import it.riccardoriggi.gooseform.entity.db.GooseButtonDb;
import it.riccardoriggi.gooseform.services.GooseButtonService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/button")
public class ButtonController {

	@Autowired
	private GooseButtonService buttonService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciForm(HttpServletRequest request){

		ObjectMapper mapper = new ObjectMapper();
		GooseButtonDb buttonInput = new GooseButtonDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GooseButtonDb.class);
			return buttonService.inserisciButton(buttonInput);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//TIPO: RESET/SEND
	@GetMapping("/{formId}/{type}")
	public ResponseEntity<Object> getButton(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("formId") String formId){
		return buttonService.getButton(formId,type);
	}

	@PutMapping("/modifica/{formId}/{type}")
	public ResponseEntity<Object> modificaButton(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("formId") String formId){
		ObjectMapper mapper = new ObjectMapper();
		GooseButtonDb buttonInput= new GooseButtonDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GooseButtonDb.class);
			return buttonService.modificaButton(buttonInput,type,formId);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{formId}/{type}")
	public ResponseEntity<Object> eliminaButton(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("formId") String formId){
		return buttonService.eliminaButton(formId,type);
	}

}
