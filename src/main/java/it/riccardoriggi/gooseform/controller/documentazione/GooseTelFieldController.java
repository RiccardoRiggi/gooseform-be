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
@RequestMapping(path = "/goose-tel-field")
public class GooseTelFieldController {


	@GetMapping("/standard/required")
	public ResponseEntity<Object> getgooseTelFieldStandardRequired(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardRequired("gooseTelField"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/equal")
	public ResponseEntity<Object> getgooseTelFieldStandardEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardEqual("gooseTelField","PAPERA"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/not-equal")
	public ResponseEntity<Object> getgooseTelFieldStandardNotEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardNotEqual("gooseTelField","PAPERA"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/pattern")
	public ResponseEntity<Object> getgooseTelFieldStandardPattern(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardPattern("gooseTelField"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/in")
	public ResponseEntity<Object> getgooseTelFieldStandardIn(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("GOOSE");
		lista.add("PAPERA");
		listaControlli.add(DemoControlliUtil.getStandardIn("gooseTelField",lista));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/not-in")
	public ResponseEntity<Object> getgooseTelFieldStandardNotIn(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		List<String> lista = new ArrayList<>();
		lista.add("PAPERA");
		lista.add("PAPERELLA");
		listaControlli.add(DemoControlliUtil.getStandardNotIn("gooseTelField",lista ));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/min-text")
	public ResponseEntity<Object> getgooseTelFieldStandardMinText(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMinText("gooseTelField","6"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/max-text")
	public ResponseEntity<Object> getgooseTelFieldStandardMaxText(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMaxText("gooseTelField","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/min")
	public ResponseEntity<Object> getgooseTelFieldStandardMin(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMin("gooseTelField","8"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/max")
	public ResponseEntity<Object> getgooseTelFieldStandardMax(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getStandardMax("gooseTelField","10"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/equal")
	public ResponseEntity<Object> getgooseTelFieldComplexEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexEqual("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/not-equal")
	public ResponseEntity<Object> getgooseTelFieldComplexNotEqual(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexNotEqual("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/min")
	public ResponseEntity<Object> getgooseTelFieldComplexMin(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMin("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complex/max")
	public ResponseEntity<Object> getgooseTelFieldComplexMax(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseControl> listaControlli = form.getControls();
		listaControlli.add(DemoControlliUtil.getComplexMax("a","b"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseTelFieldSimpleRenderHIDE_B_IF_A_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_EQUAL_X")
	public ResponseEntity<Object> getgooseTelFieldSimpleRenderDISABLE_B_IF_A_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseTelFieldSimpleRenderHIDE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_NOT_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_NOT_EQUAL_X")
	public ResponseEntity<Object> getgooseTelFieldSimpleRenderDISABLE_B_IF_A_NOT_EQUAL_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_NOT_EQUAL_X("a","b","GOOSE"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getgooseTelFieldSimpleRenderHIDE_B_IF_A_MIN_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MIN_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MIN_X")
	public ResponseEntity<Object> getgooseTelFieldSimpleRenderDISABLE_B_IF_A_MIN_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MIN_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/HIDE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getgooseTelFieldSimpleRenderHIDE_B_IF_A_MAX_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_B_IF_A_MAX_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/simpleRender/DISABLE_B_IF_A_MAX_X")
	public ResponseEntity<Object> getgooseTelFieldSimpleRenderDISABLE_B_IF_A_MAX_X(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_B_IF_A_MAX_X("a","b","5"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseTelFieldComplexRenderHIDE_C_IF_A_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		componenti.add(DemoUtil.generaGooseTelField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_EQUAL_B")
	public ResponseEntity<Object> getgooseTelFieldComplexRenderDISABLE_C_IF_A_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		componenti.add(DemoUtil.generaGooseTelField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseTelFieldComplexRenderHIDE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		componenti.add(DemoUtil.generaGooseTelField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_NOT_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_NOT_EQUAL_B")
	public ResponseEntity<Object> getgooseTelFieldComplexRenderDISABLE_C_IF_A_NOT_EQUAL_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		componenti.add(DemoUtil.generaGooseTelField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_NOT_EQUAL_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getgooseTelFieldComplexRenderHIDE_C_IF_A_MIN_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		componenti.add(DemoUtil.generaGooseTelField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MIN_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MIN_B")
	public ResponseEntity<Object> getgooseTelFieldComplexRenderDISABLE_C_IF_A_MIN_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		componenti.add(DemoUtil.generaGooseTelField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MIN_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/HIDE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getgooseTelFieldComplexRenderHIDE_C_IF_A_MAX_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		componenti.add(DemoUtil.generaGooseTelField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getHIDE_C_IF_A_MAX_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/complexRender/DISABLE_C_IF_A_MAX_B")
	public ResponseEntity<Object> getgooseTelFieldComplexRenderDISABLE_C_IF_A_MAX_B(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("a"));
		componenti.add(DemoUtil.generaGooseTelField("b"));
		componenti.add(DemoUtil.generaGooseTelField("c"));
		form.setComponents(componenti);
		List<GooseRender> listaRender = form.getRenders();
		listaRender.add(DemoRenderUtil.getDISABLE_C_IF_A_MAX_B("a","b","c"));
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

}
