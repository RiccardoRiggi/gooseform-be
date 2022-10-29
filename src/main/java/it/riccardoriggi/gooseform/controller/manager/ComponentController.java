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

import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;
import it.riccardoriggi.gooseform.services.GooseComponentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/component")
public class ComponentController {

	@Autowired
	private GooseComponentService componentService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciForm(HttpServletRequest request){

		ObjectMapper mapper = new ObjectMapper();
		GooseComponentDb buttonInput = new GooseComponentDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GooseComponentDb.class);
			return componentService.inserisciComponente(buttonInput);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{id}")
	public ResponseEntity<Object> getComponent(HttpServletRequest request, @PathVariable("id") String id, @PathVariable("formId") String formId){
		return componentService.getComponent(formId,id);
	}

	@GetMapping("/{formId}")
	public ResponseEntity<Object> getComponents(HttpServletRequest request, @PathVariable("formId") String formId){
		return componentService.getComponenti(formId);
	}

	@PutMapping("/modifica/{formId}/{id}")
	public ResponseEntity<Object> modificaButton(HttpServletRequest request, @PathVariable("id") String id, @PathVariable("formId") String formId){
		ObjectMapper mapper = new ObjectMapper();
		GooseComponentDb buttonInput= new GooseComponentDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GooseComponentDb.class);
			return componentService.modificaComponente(buttonInput,formId,id);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{formId}/{id}")
	public ResponseEntity<Object> eliminaButton(HttpServletRequest request, @PathVariable("id") String id, @PathVariable("formId") String formId){
		return componentService.eliminaComponente(formId,id);
	}

}
