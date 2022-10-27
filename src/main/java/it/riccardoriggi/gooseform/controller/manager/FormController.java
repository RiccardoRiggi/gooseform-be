package it.riccardoriggi.gooseform.controller.manager;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.riccardoriggi.gooseform.entity.db.GooseFormDb;
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

		ObjectMapper mapper = new ObjectMapper();
		GooseFormDb formInput = new GooseFormDb();

		try {
			formInput = mapper.readValue(request.getReader(), GooseFormDb.class);
			return formService.inserisciForm(formInput);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}")
	public ResponseEntity<Object> getForm(HttpServletRequest request, @PathVariable("formId") String formId){
		return formService.getForm(formId);
	}

}
