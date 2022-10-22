package it.riccardoriggi.gooseform.controller.documentazione;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseControl;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.utils.DemoControlliUtil;
import it.riccardoriggi.gooseform.utils.DemoUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/documentazione/goose-linked-select")
public class GooseLinkedSelectController {

	@GetMapping("/standard/required")
	public ResponseEntity<Object> getGooseLinkedSelectStandardRequired(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseLinkedSelectPadre("padre", "figlia"));
		componenti.add(DemoUtil.generaGooseLinkedSelectFiglia("figlia", "padre"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardRequired("padre"));
		listaControlli.add(DemoControlliUtil.getStandardRequired("figlia"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

}
