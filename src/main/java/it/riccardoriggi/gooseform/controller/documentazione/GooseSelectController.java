package it.riccardoriggi.gooseform.controller.documentazione;

import java.util.ArrayList;
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
import it.riccardoriggi.gooseform.entity.GooseRender;
import it.riccardoriggi.gooseform.utils.DemoControlliUtil;
import it.riccardoriggi.gooseform.utils.DemoRenderUtil;
import it.riccardoriggi.gooseform.utils.DemoUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/documentazione/goose-select")
public class GooseSelectController {

	@GetMapping("/standard/required")
	public ResponseEntity<Object> getGooseSelectStandardRequired(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("GooseSelect"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardRequired("GooseSelect"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/equal")
	public ResponseEntity<Object> getGooseSelectStandardEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("GooseSelect"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardEqual("GooseSelect", "PAPERA"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-equal")
	public ResponseEntity<Object> getGooseSelectStandardNotEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("GooseSelect"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardNotEqual("GooseSelect", "PAPERA"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/in")
	public ResponseEntity<Object> getGooseSelectStandardIn(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("GooseSelect"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("GOOSE");
		lista.add("PAPERA");
		listaControlli.add(DemoControlliUtil.getStandardIn("GooseSelect", lista));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-in")
	public ResponseEntity<Object> getGooseSelectStandardNotIn(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("GooseSelect"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("PAPERA");
		lista.add("PAPERELLA");
		listaControlli.add(DemoControlliUtil.getStandardNotIn("GooseSelect", lista));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/equal")
	public ResponseEntity<Object> getGooseSelectComplexEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexEqual("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/not-equal")
	public ResponseEntity<Object> getGooseSelectComplexNotEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexNotEqual("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getGooseSelectSimpleRenderHIDE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getGooseSelectSimpleRenderDISABLE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getGooseSelectSimpleRenderHIDE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_NOT_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getGooseSelectSimpleRenderDISABLE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_NOT_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getGooseSelectComplexRenderHIDE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		componenti.add(DemoUtil.generaGooseSelectStatica("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getGooseSelectComplexRenderDISABLE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		componenti.add(DemoUtil.generaGooseSelectStatica("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getGooseSelectComplexRenderHIDE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		componenti.add(DemoUtil.generaGooseSelectStatica("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getGooseSelectComplexRenderDISABLE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		componenti.add(DemoUtil.generaGooseSelectStatica("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}
}
