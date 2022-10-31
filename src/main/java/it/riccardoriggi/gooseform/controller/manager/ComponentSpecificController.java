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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.riccardoriggi.gooseform.entity.db.GooseComponentSpecificDb;
import it.riccardoriggi.gooseform.services.GooseComponentSpecificService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/component-specific")
public class ComponentSpecificController {

	@Autowired
	private GooseComponentSpecificService componentSpecificService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciForm(HttpServletRequest request){

		ObjectMapper mapper = new ObjectMapper();
		GooseComponentSpecificDb buttonInput = new GooseComponentSpecificDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GooseComponentSpecificDb.class);
			return componentSpecificService.insericiRiga(buttonInput);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{formId}/{id}/{nomeAttributo}")
	public ResponseEntity<Object> getRiga(HttpServletRequest request, @PathVariable("id") String id, @PathVariable("formId") String formId, @PathVariable("nomeAttributo") String nomeAttributo){
		return componentSpecificService.getRiga(formId,id,nomeAttributo);
	}

	@GetMapping("/{formId}/{id}")
	public ResponseEntity<Object> getRighe(HttpServletRequest request, @PathVariable("formId") String formId, @PathVariable("id") String id){
		return componentSpecificService.getRighe(formId,id);
	}

	@DeleteMapping("/elimina/{formId}/{id}/{nomeAttributo}")
	public ResponseEntity<Object> eliminaRiga(HttpServletRequest request, @PathVariable("id") String id, @PathVariable("formId") String formId, @PathVariable("nomeAttributo") String nomeAttributo){
		return componentSpecificService.eliminaRiga(formId,id,nomeAttributo);
	}

}
