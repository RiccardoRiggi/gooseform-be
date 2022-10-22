package it.riccardoriggi.gooseform.controller.documentazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.entity.GooseHttpRequest;
import it.riccardoriggi.gooseform.entity.GooseKeyValue;
import it.riccardoriggi.gooseform.utils.DemoUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/documentazione")
public class EsempiController {

	@GetMapping("/dati/esempioUno")
	public ResponseEntity<Object> datiEsempioUno(HttpServletRequest request){
		Map<String,String> mappa = new HashMap<String,String>();
		mappa.put("nome", "Riccardo");
		mappa.put("cognome", "Riggi");
		mappa.put("dataDiNascita", "2000-06-12");
		mappa.put("colorePreferito", "blu");
		return new ResponseEntity<Object>(mappa,HttpStatus.OK);
	}

	@GetMapping("/esempioUno")
	public ResponseEntity<Object> esempioUno(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextField("nome","Nome"));
		componenti.add(DemoUtil.generaGooseTextField("cognome","Cognome"));
		componenti.add(DemoUtil.generaGooseDateField("dataDiNascita","Data di nascita"));
		List<GooseKeyValue> valori = new ArrayList<>();
		valori.add(new GooseKeyValue("", "Scegli..."));
		valori.add(new GooseKeyValue("rosso", "Rosso"));
		valori.add(new GooseKeyValue("verde", "Verde"));
		valori.add(new GooseKeyValue("blu", "Blu"));
		valori.add(new GooseKeyValue("giallo", "Giallo"));
		valori.add(new GooseKeyValue("arancione", "Arancione"));
		componenti.add(DemoUtil.generaGooseSelectStatica("colorePreferito",valori,"Colore preferito"));
		form.setComponents(componenti);
		GooseHttpRequest originUrl = new GooseHttpRequest();
		originUrl.setMethod("GET");
		originUrl.setUrl("http://localhost:8080/gooseform/documentazione/dati/esempioUno");
		form.setOriginUrl(originUrl);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}



}
