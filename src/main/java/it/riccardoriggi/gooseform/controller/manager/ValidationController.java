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
		try {
			return new ResponseEntity<Object>( service.listaAttributiPerComponente(type),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/componente/{type}/{k}")
	public ResponseEntity<Object> verificaAttributoPerComponente(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("k") String k){
		try {
			return new ResponseEntity<Object>( service.verificaAttributoPerComponente(type,k),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/control/{type}")
	public ResponseEntity<Object> listaTipoControlliSpecificoDatoControllo(HttpServletRequest request, @PathVariable("type") String type){
		try {
			return new ResponseEntity<Object>( service.listaTipoControlliSpecificoDatoControllo(type),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/control/{type}/{k}")
	public ResponseEntity<Object> verificaTipoControllo(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("k") String k){
		try {
			return new ResponseEntity<Object>( service.verificaTipoControllo(type,k),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/render/{type}")
	public ResponseEntity<Object> listaTipoRenderSpecificoDatoRender(HttpServletRequest request, @PathVariable("type") String type){
		try {
			return new ResponseEntity<Object>( service.listaTipoRenderSpecificoDatoRender(type),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/render/{type}/{k}")
	public ResponseEntity<Object> verificaTipoRender(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("k") String k){
		try {
			return new ResponseEntity<Object>( service.verificaTipoRender(type,k),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/placeholder/{type}")
	public ResponseEntity<Object> getPlaceholder(HttpServletRequest request, @PathVariable("type") String type){
		try {
			return new ResponseEntity<Object>( service.getPlaceholder(type),HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<Object>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
