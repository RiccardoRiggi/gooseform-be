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

import it.riccardoriggi.gooseform.entity.db.GooseKvHttpRequestDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseKvHttpRequestInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/kv-http")
public class KvHttpRequestController {

	@Autowired
	private GooseKvHttpRequestInterface service;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisci(HttpServletRequest request){
		log.debug("KvHttpRequestController - inserisci");
		ObjectMapper mapper = new ObjectMapper();
		GooseKvHttpRequestDb input = new GooseKvHttpRequestDb();
		try {
			input = mapper.readValue(request.getReader(), GooseKvHttpRequestDb.class);
			log.debug("body "+input);
			service.inserisci(input);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{pkHttp}")
	public ResponseEntity<Object> get(HttpServletRequest request,@PathVariable("pkHttp") int pkHttp){
		log.debug("KvHttpRequestController - get");
		log.debug("pkHttp "+pkHttp);
		try {
			return new ResponseEntity<>(service.getLista(pkHttp),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@DeleteMapping("/elimina/{pkHttp}/{k}")
	public ResponseEntity<Object> elimina(HttpServletRequest request, @PathVariable("pkHttp") int pkHttp,@PathVariable("k") String k){
		log.debug("KvHttpRequestController - elimina");
		log.debug("pkHttp "+pkHttp);
		log.debug("k "+k);
		try {
			service.elimina(pkHttp,k);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
