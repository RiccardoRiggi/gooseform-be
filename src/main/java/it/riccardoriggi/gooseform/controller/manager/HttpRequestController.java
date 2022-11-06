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

import it.riccardoriggi.gooseform.entity.db.GooseHttpRequestDb;
import it.riccardoriggi.gooseform.interfaces.GooseHttpRequestInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/http")
public class HttpRequestController {

	@Autowired
	private GooseHttpRequestInterface chiamataService;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisciForm(HttpServletRequest request){

		ObjectMapper mapper = new ObjectMapper();
		GooseHttpRequestDb formInput = new GooseHttpRequestDb();

		try {
			formInput = mapper.readValue(request.getReader(), GooseHttpRequestDb.class);
			return chiamataService.inserisciChiamata(formInput);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/pk/{pk}")
	public ResponseEntity<Object> getChiamataByPk(HttpServletRequest request, @PathVariable("pk") int pk){
		return chiamataService.getChiamataByPk(pk);
	}

	@GetMapping("/{formId}/{componentId}")
	public ResponseEntity<Object> getChiamataById(HttpServletRequest request,@PathVariable("formId") String formId,@PathVariable("componentId") String componentId){
		return chiamataService.getChiamataById(formId, componentId);
	}

	@GetMapping("/{formId}")
	public ResponseEntity<Object> getChiamataByFormId(HttpServletRequest request,@PathVariable("formId") String formId){
		return chiamataService.getChiamataByFormId(formId);
	}

	@PutMapping("/modifica/{pk}")
	public ResponseEntity<Object> modificaForm(HttpServletRequest request, @PathVariable("pk") int pk){
		ObjectMapper mapper = new ObjectMapper();
		GooseHttpRequestDb formInput = new GooseHttpRequestDb();

		try {
			formInput = mapper.readValue(request.getReader(), GooseHttpRequestDb.class);
			return chiamataService.modificaChiamata(formInput,pk);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/elimina/{pk}")
	public ResponseEntity<Object> eliminaFormByPk(HttpServletRequest request, @PathVariable("pk") int pk){
		return chiamataService.eliminaChiamata(pk);
	}

}
