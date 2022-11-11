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
import it.riccardoriggi.gooseform.interfaces.GooseRenderInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/render")
public class RenderController {

	@Autowired
	private GooseRenderInterface service;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciForm(HttpServletRequest request){

		ObjectMapper mapper = new ObjectMapper();
		GooseRenderDb buttonInput = new GooseRenderDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GooseRenderDb.class);
			return service.inserisciRender(buttonInput);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/lista/{formId}")
	public ResponseEntity<Object> getComponents(HttpServletRequest request, @PathVariable("formId") String formId){
		return service.getRenders(formId);
	}

	@GetMapping("/{pk}")
	public ResponseEntity<Object> getComponents(HttpServletRequest request, @PathVariable("pk") int pk){
		return service.getRender(pk);
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modificaButton(HttpServletRequest request, @PathVariable("pk") int pk){
		ObjectMapper mapper = new ObjectMapper();
		GooseRenderDb buttonInput= new GooseRenderDb();

		try {
			buttonInput = mapper.readValue(request.getReader(), GooseRenderDb.class);
			return  service.modificaRender(buttonInput,pk);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{pk}")
	public ResponseEntity<Object> eliminaButton(HttpServletRequest request, @PathVariable("pk") int pk){
		return service.eliminaRender(pk);
	}

}
