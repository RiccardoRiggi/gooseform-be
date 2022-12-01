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

import it.riccardoriggi.gooseform.entity.db.GooseKControlDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseKControlInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/k-control")
public class KControlController {

	@Autowired
	private GooseKControlInterface service;


	@PostMapping("/inserisci")
	public ResponseEntity<Object> inserisci(HttpServletRequest request){
		log.debug("KControlController - inserisci");
		ObjectMapper mapper = new ObjectMapper();
		GooseKControlDb input = new GooseKControlDb();

		try {
			input = mapper.readValue(request.getReader(), GooseKControlDb.class);
			log.debug("body: "+input);
			service.inserisci(input);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IOException e) {
			log.error("Errore durante la conversione del JSON Body: ",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{pkControl}")
	public ResponseEntity<Object> getChiamataById(HttpServletRequest request,@PathVariable("pkControl") int pkControl){
		log.debug("KControlController - getChiamataById");
		log.debug("pkControl "+pkControl);
		try {
			return new ResponseEntity<>( service.getLista(pkControl),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@DeleteMapping("/elimina/{pkControl}/{k}")
	public ResponseEntity<Object> eliminaFormByPk(HttpServletRequest request, @PathVariable("pkControl") int pkControl,@PathVariable("k") String k){
		log.debug("KControlController - getChiamataById");
		log.debug("pkControl "+pkControl);
		log.debug("k "+k);
		try {
			service.elimina(pkControl,k);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
