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
import it.riccardoriggi.gooseform.entity.GooseRender;
import it.riccardoriggi.gooseform.utils.DemoControlliUtil;
import it.riccardoriggi.gooseform.utils.DemoRenderUtil;
import it.riccardoriggi.gooseform.utils.DemoUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/documentazione/goose-checkbox")
public class GooseCheckboxController {

	@GetMapping("/standard/required")
	public ResponseEntity<Object> getgooseCheckboxStandardRequired(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox("gooseCheckbox"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardRequired("gooseCheckbox"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseCheckboxSimpleRenderHIDE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox("a"));
		componenti.add(DemoUtil.generaGooseCheckbox("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseCheckboxSimpleRenderDISABLE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox("a"));
		componenti.add(DemoUtil.generaGooseCheckbox("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseCheckboxSimpleRenderHIDE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox("a"));
		componenti.add(DemoUtil.generaGooseCheckbox("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_NOT_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseCheckboxSimpleRenderDISABLE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox("a"));
		componenti.add(DemoUtil.generaGooseCheckbox("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_NOT_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseCheckboxComplexRenderHIDE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox("a"));
		componenti.add(DemoUtil.generaGooseCheckbox("b"));
		componenti.add(DemoUtil.generaGooseCheckbox("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseCheckboxComplexRenderDISABLE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox("a"));
		componenti.add(DemoUtil.generaGooseCheckbox("b"));
		componenti.add(DemoUtil.generaGooseCheckbox("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseCheckboxComplexRenderHIDE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox("a"));
		componenti.add(DemoUtil.generaGooseCheckbox("b"));
		componenti.add(DemoUtil.generaGooseCheckbox("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseCheckboxComplexRenderDISABLE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox("a"));
		componenti.add(DemoUtil.generaGooseCheckbox("b"));
		componenti.add(DemoUtil.generaGooseCheckbox("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

}
