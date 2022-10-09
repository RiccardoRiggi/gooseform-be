package it.riccardoriggi.gooseform.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.entity.GooseChiaveValore;
import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.entity.GooseKeyValue;
import it.riccardoriggi.gooseform.utils.DemoUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "")
public class RootController {

	@Value("${variabile}")
	private String variabile;

	@GetMapping("/")
	public ResponseEntity<Object> rootPage(HttpServletRequest request){
		log.info(request.getPathInfo());
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea());

		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@PostMapping("/opzioni")
	public ResponseEntity<Object> getDynamicOptions(HttpServletRequest request){

		log.info("HEADER_1: "+request.getHeader("HEADER_1"));
		try {
			log.info("BODY: "+request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
		} catch (IOException e) {
			log.error("Errore lettura body");
		}


		List<GooseKeyValue> listaValori = new ArrayList<>();
		listaValori.add(new GooseKeyValue("unoDinamico", "Uno Dinamico"));
		listaValori.add(new GooseKeyValue("dueDinamico", "Due Dinamico"));
		listaValori.add(new GooseKeyValue("treDinamico", "Tre Dinamico"));
		listaValori.add(new GooseKeyValue("quattroDinamico", "Quattro Dinamico"));
		listaValori.add(new GooseKeyValue("cinqueDinamico", "Cinque Dinamico"));
		return new ResponseEntity<Object>(listaValori,HttpStatus.OK);
	}

	@PostMapping("/opzioniDue")
	public ResponseEntity<Object> getDynamicOptionsDue(HttpServletRequest request){

		log.info("HEADER_2: "+request.getHeader("HEADER_2"));
		try {
			log.info("BODY: "+request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
		} catch (IOException e) {
			log.error("Errore lettura body");
		}


		List<GooseChiaveValore> listaValori = new ArrayList<>();
		listaValori.add(new GooseChiaveValore("unoDinamico", "Uno Dinamico DUE"));
		listaValori.add(new GooseChiaveValore("dueDinamico", "Due Dinamico DUE"));
		listaValori.add(new GooseChiaveValore("treDinamico", "Tre Dinamico DUE"));
		listaValori.add(new GooseChiaveValore("quattroDinamico", "Quattro Dinamico DUE"));
		listaValori.add(new GooseChiaveValore("cinqueDinamico", "Cinque Dinamico DUE"));
		return new ResponseEntity<Object>(listaValori,HttpStatus.OK);
	}

}
