package it.riccardoriggi.gooseform.controller.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.interfaces.ValidationInterface;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/validation")
public class ValidationController {

	@Autowired
	private ValidationInterface service;

	@GetMapping("/componente/{type}")
	public ResponseEntity<Object> listaAttributiPerComponente(HttpServletRequest request, @PathVariable("type") String type){
		return service.listaAttributiPerComponente(type);
	}

	@GetMapping("/componente/{type}/{k}")
	public ResponseEntity<Object> verificaAttributoPerComponente(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("k") String k){
		return service.verificaAttributoPerComponente(type,k);
	}

	@GetMapping("/control/{type}")
	public ResponseEntity<Object> listaTipoControlliSpecificoDatoControllo(HttpServletRequest request, @PathVariable("type") String type){
		return service.listaTipoControlliSpecificoDatoControllo(type);
	}

	@GetMapping("/componente/{type}/{k}")
	public ResponseEntity<Object> verificaTipoControllo(HttpServletRequest request, @PathVariable("type") String type, @PathVariable("k") String k){
		return service.verificaTipoControllo(type,k);
	}

}
