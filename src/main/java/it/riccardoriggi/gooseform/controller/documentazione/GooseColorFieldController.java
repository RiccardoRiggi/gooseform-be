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
@RequestMapping(path = "/documentazione/goose-color-field")
public class GooseColorFieldController {

	@GetMapping("/standard/required")
	public ResponseEntity<Object> getgooseColorFieldStandardRequired(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("gooseColorField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardRequired("gooseColorField"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/equal")
	public ResponseEntity<Object> getgooseColorFieldStandardEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("gooseColorField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardEqual("gooseColorField", "PAPERA"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-equal")
	public ResponseEntity<Object> getgooseColorFieldStandardNotEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("gooseColorField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardNotEqual("gooseColorField", "PAPERA"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/in")
	public ResponseEntity<Object> getgooseColorFieldStandardIn(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("gooseColorField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("GOOSE");
		lista.add("PAPERA");
		listaControlli.add(DemoControlliUtil.getStandardIn("gooseColorField", lista));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-in")
	public ResponseEntity<Object> getgooseColorFieldStandardNotIn(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("gooseColorField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("PAPERA");
		lista.add("PAPERELLA");
		listaControlli.add(DemoControlliUtil.getStandardNotIn("gooseColorField", lista));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/equal")
	public ResponseEntity<Object> getgooseColorFieldComplexEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexEqual("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/not-equal")
	public ResponseEntity<Object> getgooseColorFieldComplexNotEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexNotEqual("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseColorFieldSimpleRenderHIDE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseColorFieldSimpleRenderDISABLE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseColorFieldSimpleRenderHIDE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_NOT_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseColorFieldSimpleRenderDISABLE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_NOT_EQUAL_X("a", "b", "GOOSE"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseColorFieldComplexRenderHIDE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		componenti.add(DemoUtil.generaGooseColorField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseColorFieldComplexRenderDISABLE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		componenti.add(DemoUtil.generaGooseColorField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseColorFieldComplexRenderHIDE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		componenti.add(DemoUtil.generaGooseColorField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseColorFieldComplexRenderDISABLE_C_IF_A_NOT_EQUAL_B(
			HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("a"));
		componenti.add(DemoUtil.generaGooseColorField("b"));
		componenti.add(DemoUtil.generaGooseColorField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

}
