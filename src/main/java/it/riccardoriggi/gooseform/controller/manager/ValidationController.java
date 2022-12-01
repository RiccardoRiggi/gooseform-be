package it.riccardoriggi.gooseform.controller.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseValidationInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/validation")
public class ValidationController {

	@Autowired
	private GooseValidationInterface service;

	@GetMapping("/componente/{type}")
	public ResponseEntity<Object> listaAttributiPerComponente(HttpServletRequest request, @PathVariable("type") String type){
		log.debug("ValidationController - listaAttributiPerComponente");
		log.debug("type "+type);
		try {
			return new ResponseEntity<>( service.listaAttributiPerComponente(type),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/componente/{type}/{k}")
	public ResponseEntity<Object> verificaAttributoPerComponente(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("k") String k){
		log.debug("ValidationController - verificaAttributoPerComponente");
		log.debug("type "+type);
		log.debug("k "+k);
		try {
			return new ResponseEntity<>( service.verificaAttributoPerComponente(type,k),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/control/{type}")
	public ResponseEntity<Object> listaTipoControlliSpecificoDatoControllo(HttpServletRequest request, @PathVariable("type") String type){
		log.debug("ValidationController - listaTipoControlliSpecificoDatoControllo");
		log.debug("type "+type);
		try {
			return new ResponseEntity<>( service.listaTipoControlliSpecificoDatoControllo(type),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/control/{type}/{k}")
	public ResponseEntity<Object> verificaTipoControllo(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("k") String k){
		log.debug("ValidationController - verificaTipoControllo");
		log.debug("type "+type);
		log.debug("k "+k);
		try {
			return new ResponseEntity<>( service.verificaTipoControllo(type,k),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/render/{type}")
	public ResponseEntity<Object> listaTipoRenderSpecificoDatoRender(HttpServletRequest request, @PathVariable("type") String type){
		log.debug("ValidationController - listaTipoRenderSpecificoDatoRender");
		log.debug("type "+type);
		try {
			return new ResponseEntity<>( service.listaTipoRenderSpecificoDatoRender(type),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/render/{type}/{k}")
	public ResponseEntity<Object> verificaTipoRender(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("k") String k){
		log.debug("ValidationController - verificaTipoRender");
		log.debug("type "+type);
		log.debug("k "+k);
		try {
			return new ResponseEntity<>( service.verificaTipoRender(type,k),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/placeholder/{type}")
	public ResponseEntity<Object> getPlaceholder(HttpServletRequest request, @PathVariable("type") String type){
		log.debug("ValidationController - getPlaceholder");
		log.debug("type "+type);
		try {
			return new ResponseEntity<>( service.getPlaceholder(type),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
