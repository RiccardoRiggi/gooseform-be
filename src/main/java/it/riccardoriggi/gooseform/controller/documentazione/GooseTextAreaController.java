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
@RequestMapping(path = "/goose-text-area")
public class GooseTextAreaController {


	@GetMapping("/standard/required")
	public ResponseEntity<Object> getGooseTextAreaStandardRequired(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardRequired("gooseTextArea"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/equal")
	public ResponseEntity<Object> getGooseTextAreaStandardEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardEqual("gooseTextArea","PAPERA"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/not-equal")
	public ResponseEntity<Object> getGooseTextAreaStandardNotEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardNotEqual("gooseTextArea","PAPERA"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/pattern")
	public ResponseEntity<Object> getGooseTextAreaStandardPattern(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardPattern("gooseTextArea"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/in")
	public ResponseEntity<Object> getGooseTextAreaStandardIn(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("GOOSE");
		lista.add("PAPERA");
		listaControlli.add(DemoControlliUtil.getStandardIn("gooseTextArea",lista));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/not-in")
	public ResponseEntity<Object> getGooseTextAreaStandardNotIn(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("PAPERA");
		lista.add("PAPERELLA");
		listaControlli.add(DemoControlliUtil.getStandardNotIn("gooseTextArea",lista ));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/min-text")
	public ResponseEntity<Object> getGooseTextAreaStandardMinText(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMinText("gooseTextArea","6"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/max-text")
	public ResponseEntity<Object> getGooseTextAreaStandardMaxText(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMaxText("gooseTextArea","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/min")
	public ResponseEntity<Object> getGooseTextAreaStandardMin(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMin("gooseTextArea","8"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/max")
	public ResponseEntity<Object> getGooseTextAreaStandardMax(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMax("gooseTextArea","10"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/equal")
	public ResponseEntity<Object> getGooseTextAreaComplexEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexEqual("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/not-equal")
	public ResponseEntity<Object> getGooseTextAreaComplexNotEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexNotEqual("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/min")
	public ResponseEntity<Object> getGooseTextAreaComplexMin(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMin("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/max")
	public ResponseEntity<Object> getGooseTextAreaComplexMax(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMax("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getGooseTextAreaSimpleRenderHIDE_B_IF_A_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getGooseTextAreaSimpleRenderDISABLE_B_IF_A_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getGooseTextAreaSimpleRenderHIDE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_NOT_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getGooseTextAreaSimpleRenderDISABLE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_NOT_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getGooseTextAreaSimpleRenderHIDE_B_IF_A_MIN_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MIN_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getGooseTextAreaSimpleRenderDISABLE_B_IF_A_MIN_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MIN_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getGooseTextAreaSimpleRenderHIDE_B_IF_A_MAX_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MAX_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getGooseTextAreaSimpleRenderDISABLE_B_IF_A_MAX_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MAX_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getGooseTextAreaComplexRenderHIDE_C_IF_A_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		componenti.add(DemoUtil.generaGooseTextArea("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getGooseTextAreaComplexRenderDISABLE_C_IF_A_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		componenti.add(DemoUtil.generaGooseTextArea("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getGooseTextAreaComplexRenderHIDE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		componenti.add(DemoUtil.generaGooseTextArea("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_NOT_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getGooseTextAreaComplexRenderDISABLE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		componenti.add(DemoUtil.generaGooseTextArea("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_NOT_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getGooseTextAreaComplexRenderHIDE_C_IF_A_MIN_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		componenti.add(DemoUtil.generaGooseTextArea("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MIN_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getGooseTextAreaComplexRenderDISABLE_C_IF_A_MIN_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		componenti.add(DemoUtil.generaGooseTextArea("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MIN_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getGooseTextAreaComplexRenderHIDE_C_IF_A_MAX_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		componenti.add(DemoUtil.generaGooseTextArea("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MAX_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getGooseTextAreaComplexRenderDISABLE_C_IF_A_MAX_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseTextArea("b"));
		componenti.add(DemoUtil.generaGooseTextArea("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MAX_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

}
