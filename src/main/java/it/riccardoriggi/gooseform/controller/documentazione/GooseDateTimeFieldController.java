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
@RequestMapping(path = "/goose-date-time-field")
public class GooseDateTimeFieldController {


	@GetMapping("/standard/required")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardRequired(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardRequired("gooseDateTimeField"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/equal")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardEqual("gooseDateTimeField","PAPERA"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/not-equal")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardNotEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardNotEqual("gooseDateTimeField","PAPERA"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/pattern")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardPattern(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardPattern("gooseDateTimeField"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/in")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardIn(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("GOOSE");
		lista.add("PAPERA");
		listaControlli.add(DemoControlliUtil.getStandardIn("gooseDateTimeField",lista));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/not-in")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardNotIn(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("PAPERA");
		lista.add("PAPERELLA");
		listaControlli.add(DemoControlliUtil.getStandardNotIn("gooseDateTimeField",lista ));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/min-text")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardMinText(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMinText("gooseDateTimeField","6"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/max-text")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardMaxText(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMaxText("gooseDateTimeField","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/min")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardMin(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMin("gooseDateTimeField","8"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/max")
	public ResponseEntity<Object> getgooseDateTimeFieldStandardMax(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMax("gooseDateTimeField","10"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/equal")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexEqual("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/not-equal")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexNotEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexNotEqual("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/min")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexMin(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMin("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/max")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexMax(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMax("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseDateTimeFieldSimpleRenderHIDE_B_IF_A_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseDateTimeFieldSimpleRenderDISABLE_B_IF_A_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseDateTimeFieldSimpleRenderHIDE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_NOT_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseDateTimeFieldSimpleRenderDISABLE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_NOT_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getgooseDateTimeFieldSimpleRenderHIDE_B_IF_A_MIN_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MIN_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getgooseDateTimeFieldSimpleRenderDISABLE_B_IF_A_MIN_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MIN_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getgooseDateTimeFieldSimpleRenderHIDE_B_IF_A_MAX_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MAX_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getgooseDateTimeFieldSimpleRenderDISABLE_B_IF_A_MAX_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MAX_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexRenderHIDE_C_IF_A_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		componenti.add(DemoUtil.generaGooseDateTimeField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexRenderDISABLE_C_IF_A_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		componenti.add(DemoUtil.generaGooseDateTimeField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexRenderHIDE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		componenti.add(DemoUtil.generaGooseDateTimeField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_NOT_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexRenderDISABLE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		componenti.add(DemoUtil.generaGooseDateTimeField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_NOT_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexRenderHIDE_C_IF_A_MIN_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		componenti.add(DemoUtil.generaGooseDateTimeField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MIN_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexRenderDISABLE_C_IF_A_MIN_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		componenti.add(DemoUtil.generaGooseDateTimeField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MIN_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexRenderHIDE_C_IF_A_MAX_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		componenti.add(DemoUtil.generaGooseDateTimeField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MAX_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getgooseDateTimeFieldComplexRenderDISABLE_C_IF_A_MAX_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("a"));
		componenti.add(DemoUtil.generaGooseDateTimeField("b"));
		componenti.add(DemoUtil.generaGooseDateTimeField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MAX_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

}
