package it.riccardoriggi.gooseform.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.entity.GooseSelect;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "")
public class RootController {

	@Value("${variabile}")
	private String variabile;

	/*
	 * CREA classe DemoUtil
	 * */

	@GetMapping("/")
	public ResponseEntity<Object> rootPage(HttpServletRequest request){
		log.info(request.getPathInfo());
		GooseForm form = new GooseForm();
		List<GooseComponent> listaComponenti = new ArrayList<>();
		GooseComponent componenteUno = new GooseComponent();
		componenteUno.setId("uno");
		componenteUno.setLabel("LABEL");
		componenteUno.setSetting(new GooseSelect());
		listaComponenti.add(componenteUno );
		form.setComponents(listaComponenti );
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

}
