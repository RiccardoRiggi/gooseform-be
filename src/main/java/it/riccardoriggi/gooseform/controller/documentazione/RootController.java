package it.riccardoriggi.gooseform.controller.documentazione;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.entity.GooseChiaveValore;
import it.riccardoriggi.gooseform.entity.GooseKeyValue;
import it.riccardoriggi.gooseform.enums.GooseComponentEnum;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/documentazione")
public class RootController {

	@Value("${variabile}")
	private String variabile;

	@GetMapping("/")
	public ResponseEntity<Object> rootPage(HttpServletRequest request){
		return new ResponseEntity<Object>("GOOSE",HttpStatus.OK);
	}

	@GetMapping("/gooseComponentEnum")
	public ResponseEntity<Object> gooseComponentEnum(HttpServletRequest request){
		return new ResponseEntity<Object>(Arrays.asList(GooseComponentEnum.values()),HttpStatus.OK);
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
		listaValori.add(new GooseKeyValue("goose", "Goose Dinamico"));
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
		listaValori.add(new GooseChiaveValore("goose", "Goose Dinamico"));
		return new ResponseEntity<Object>(listaValori,HttpStatus.OK);
	}

	@PostMapping("/linked/{id}")
	public ResponseEntity<Object> getDynamicOptionsDue(HttpServletRequest request, @PathVariable String id){

		log.info("HEADER_2: "+request.getHeader("HEADER_2"));
		try {
			log.info("BODY: "+request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
		} catch (IOException e) {
			log.error("Errore lettura body");
		}


		List<GooseChiaveValore> listaValori = new ArrayList<>();
		listaValori.add(new GooseChiaveValore("unoLinked", "Uno LINKED "+id));
		listaValori.add(new GooseChiaveValore("dueLinked", "Due LINKED "+id));
		listaValori.add(new GooseChiaveValore("treLinked", "Tre LINKED "+id));
		listaValori.add(new GooseChiaveValore("quattroLinked", "Quattro LINKED "+id));
		listaValori.add(new GooseChiaveValore("cinqueLinked", "Cinque LINKED "+id));
		listaValori.add(new GooseChiaveValore("goose", "Goose Dinamico"));
		return new ResponseEntity<Object>(listaValori,HttpStatus.OK);
	}



}
