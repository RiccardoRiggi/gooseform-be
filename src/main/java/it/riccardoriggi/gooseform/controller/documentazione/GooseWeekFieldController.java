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
@RequestMapping(path = "/documentazione/goose-week-field")
public class GooseWeekFieldController {

	@GetMapping("/standard/required")
	public ResponseEntity<Object> getgooseWeekFieldStandardRequired(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("gooseWeekField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardRequired("gooseWeekField"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/equal")
	public ResponseEntity<Object> getgooseWeekFieldStandardEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("gooseWeekField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardEqual("gooseWeekField", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-equal")
	public ResponseEntity<Object> getgooseWeekFieldStandardNotEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("gooseWeekField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardNotEqual("gooseWeekField", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/in")
	public ResponseEntity<Object> getgooseWeekFieldStandardIn(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("gooseWeekField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("2022-W42");
		lista.add("2022-W43");
		listaControlli.add(DemoControlliUtil.getStandardIn("gooseWeekField", lista));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-in")
	public ResponseEntity<Object> getgooseWeekFieldStandardNotIn(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("gooseWeekField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("2022-W42");
		lista.add("2022-W43");
		listaControlli.add(DemoControlliUtil.getStandardNotIn("gooseWeekField", lista));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/min")
	public ResponseEntity<Object> getgooseWeekFieldStandardMin(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("gooseWeekField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMin("gooseWeekField", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/max")
	public ResponseEntity<Object> getgooseWeekFieldStandardMax(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("gooseWeekField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMax("gooseWeekField", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/equal")
	public ResponseEntity<Object> getgooseWeekFieldComplexEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexEqual("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/not-equal")
	public ResponseEntity<Object> getgooseWeekFieldComplexNotEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexNotEqual("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/min")
	public ResponseEntity<Object> getgooseWeekFieldComplexMin(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMin("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/max")
	public ResponseEntity<Object> getgooseWeekFieldComplexMax(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMax("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseWeekFieldSimpleRenderHIDE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_EQUAL_X("a", "b", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseWeekFieldSimpleRenderDISABLE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_EQUAL_X("a", "b", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseWeekFieldSimpleRenderHIDE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_NOT_EQUAL_X("a", "b", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseWeekFieldSimpleRenderDISABLE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_NOT_EQUAL_X("a", "b", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getgooseWeekFieldSimpleRenderHIDE_B_IF_A_MIN_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MIN_X("a", "b", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getgooseWeekFieldSimpleRenderDISABLE_B_IF_A_MIN_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MIN_X("a", "b", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getgooseWeekFieldSimpleRenderHIDE_B_IF_A_MAX_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MAX_X("a", "b", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getgooseWeekFieldSimpleRenderDISABLE_B_IF_A_MAX_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MAX_X("a", "b", "2022-W42"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseWeekFieldComplexRenderHIDE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		componenti.add(DemoUtil.generaGooseWeekField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseWeekFieldComplexRenderDISABLE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		componenti.add(DemoUtil.generaGooseWeekField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseWeekFieldComplexRenderHIDE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		componenti.add(DemoUtil.generaGooseWeekField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseWeekFieldComplexRenderDISABLE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		componenti.add(DemoUtil.generaGooseWeekField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getgooseWeekFieldComplexRenderHIDE_C_IF_A_MIN_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		componenti.add(DemoUtil.generaGooseWeekField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MIN_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getgooseWeekFieldComplexRenderDISABLE_C_IF_A_MIN_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		componenti.add(DemoUtil.generaGooseWeekField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MIN_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getgooseWeekFieldComplexRenderHIDE_C_IF_A_MAX_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		componenti.add(DemoUtil.generaGooseWeekField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MAX_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getgooseWeekFieldComplexRenderDISABLE_C_IF_A_MAX_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("a"));
		componenti.add(DemoUtil.generaGooseWeekField("b"));
		componenti.add(DemoUtil.generaGooseWeekField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MAX_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

}
