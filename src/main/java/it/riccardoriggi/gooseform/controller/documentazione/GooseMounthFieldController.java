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
@RequestMapping(path = "/goose-mounth-field")
public class GooseMounthFieldController {

	@GetMapping("/standard/required")
	public ResponseEntity<Object> getgooseMounthFieldStandardRequired(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("gooseMounthField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardRequired("gooseMounthField"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/equal")
	public ResponseEntity<Object> getgooseMounthFieldStandardEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("gooseMounthField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardEqual("gooseMounthField", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-equal")
	public ResponseEntity<Object> getgooseMounthFieldStandardNotEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("gooseMounthField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardNotEqual("gooseMounthField", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/in")
	public ResponseEntity<Object> getgooseMounthFieldStandardIn(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("gooseMounthField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("2022-10");
		lista.add("2022-11");
		listaControlli.add(DemoControlliUtil.getStandardIn("gooseMounthField", lista));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-in")
	public ResponseEntity<Object> getgooseMounthFieldStandardNotIn(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("gooseMounthField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("2022-10");
		lista.add("2022-11");
		listaControlli.add(DemoControlliUtil.getStandardNotIn("gooseMounthField", lista));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/min")
	public ResponseEntity<Object> getgooseMounthFieldStandardMin(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("gooseMounthField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMin("gooseMounthField", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/max")
	public ResponseEntity<Object> getgooseMounthFieldStandardMax(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("gooseMounthField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMax("gooseMounthField", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/equal")
	public ResponseEntity<Object> getgooseMounthFieldComplexEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexEqual("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/not-equal")
	public ResponseEntity<Object> getgooseMounthFieldComplexNotEqual(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexNotEqual("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/min")
	public ResponseEntity<Object> getgooseMounthFieldComplexMin(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMin("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/max")
	public ResponseEntity<Object> getgooseMounthFieldComplexMax(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMax("a", "b"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseMounthFieldSimpleRenderHIDE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_EQUAL_X("a", "b", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseMounthFieldSimpleRenderDISABLE_B_IF_A_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_EQUAL_X("a", "b", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseMounthFieldSimpleRenderHIDE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_NOT_EQUAL_X("a", "b", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseMounthFieldSimpleRenderDISABLE_B_IF_A_NOT_EQUAL_X(
			HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_NOT_EQUAL_X("a", "b", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getgooseMounthFieldSimpleRenderHIDE_B_IF_A_MIN_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MIN_X("a", "b", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getgooseMounthFieldSimpleRenderDISABLE_B_IF_A_MIN_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MIN_X("a", "b", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getgooseMounthFieldSimpleRenderHIDE_B_IF_A_MAX_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MAX_X("a", "b", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getgooseMounthFieldSimpleRenderDISABLE_B_IF_A_MAX_X(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MAX_X("a", "b", "2022-10"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseMounthFieldComplexRenderHIDE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		componenti.add(DemoUtil.generaGooseMounthField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseMounthFieldComplexRenderDISABLE_C_IF_A_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		componenti.add(DemoUtil.generaGooseMounthField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseMounthFieldComplexRenderHIDE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		componenti.add(DemoUtil.generaGooseMounthField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseMounthFieldComplexRenderDISABLE_C_IF_A_NOT_EQUAL_B(
			HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		componenti.add(DemoUtil.generaGooseMounthField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_NOT_EQUAL_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getgooseMounthFieldComplexRenderHIDE_C_IF_A_MIN_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		componenti.add(DemoUtil.generaGooseMounthField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MIN_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getgooseMounthFieldComplexRenderDISABLE_C_IF_A_MIN_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		componenti.add(DemoUtil.generaGooseMounthField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MIN_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getgooseMounthFieldComplexRenderHIDE_C_IF_A_MAX_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		componenti.add(DemoUtil.generaGooseMounthField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MAX_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getgooseMounthFieldComplexRenderDISABLE_C_IF_A_MAX_B(HttpServletRequest request) {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("a"));
		componenti.add(DemoUtil.generaGooseMounthField("b"));
		componenti.add(DemoUtil.generaGooseMounthField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MAX_B("a", "b", "c"));
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

}
