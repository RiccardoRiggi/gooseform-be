package it.riccardoriggi.gooseform.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.entity.GooseComplexControl;
import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseControl;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.entity.GooseStandardControl;
import it.riccardoriggi.gooseform.enums.GooseComplexControlEnum;
import it.riccardoriggi.gooseform.enums.GooseControlEnum;
import it.riccardoriggi.gooseform.enums.GooseStandardControlEnum;
import it.riccardoriggi.gooseform.utils.DemoUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/controlli")
public class ControlliController {

	private List<String> getListaId(List<GooseComponent> listaComponenti) {
		List<String> lista = new ArrayList<>();
		for (GooseComponent componente : listaComponenti) {
			lista.add(componente.getId());
		}
		return lista;
	}

	private GooseForm getCompleteForm() {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("a"));
		componenti.add(DemoUtil.generaGooseSelectStatica("b"));
		componenti.add(DemoUtil.generaGooseSelectDinamica("c"));
		componenti.add(DemoUtil.generaGooseLinkedSelectPadre("padre", "figlio"));
		componenti.add(DemoUtil.generaGooseLinkedSelectFiglia("figlio", "padre"));
		componenti.add(DemoUtil.generaGooseDataListStatica("f"));
		componenti.add(DemoUtil.generaGooseDataListDinamica("g"));
		componenti.add(DemoUtil.generaGooseTextField("h"));
		componenti.add(DemoUtil.generaGoosePasswordField("i"));
		componenti.add(DemoUtil.generaGooseNumberField("l"));
		componenti.add(DemoUtil.generaGooseRadioStatica("m"));
		componenti.add(DemoUtil.generaGooseRadioDinamica("n"));
		componenti.add(DemoUtil.generaGooseCheckbox());
		componenti.add(DemoUtil.generaGooseEmailField("o"));
		componenti.add(DemoUtil.generaGooseDateField("p"));
		componenti.add(DemoUtil.generaGooseDateTimeField("q"));
		componenti.add(DemoUtil.generaGooseMounthField("r"));
		componenti.add(DemoUtil.generaGooseWeekField("s"));
		componenti.add(DemoUtil.generaGooseTimeField("t"));
		componenti.add(DemoUtil.generaGooseColorField("u"));
		componenti.add(DemoUtil.generaGooseRangeField("v"));
		form.setComponents(componenti);
		return form;
	}

	@GetMapping("/standard/required")
	public ResponseEntity<Object> getStandardRequired(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			control.setType(GooseStandardControlEnum.REQUIRED.getValue());
			control.setErrorMessage("Il campo " + id + " è richiesto");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/equal")
	public ResponseEntity<Object> getStandardEqual(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			control.setReferenceValue("goose");
			control.setType(GooseStandardControlEnum.EQUAL.getValue());
			control.setErrorMessage("Il campo " + id + " deve essere uguale a <goose>");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-equal")
	public ResponseEntity<Object> getStandardNotEqual(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			control.setReferenceValue("goose");
			control.setType(GooseStandardControlEnum.NOT_EQUAL.getValue());
			control.setErrorMessage("Il campo " + id + " non deve essere uguale a <goose>");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/pattern")
	public ResponseEntity<Object> getStandardPattern(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			control.setReferenceValue("[abc]");
			control.setType(GooseStandardControlEnum.PATTERN.getValue());
			control.setErrorMessage("Il campo " + id + " deve contenere almeno a, b o c");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/in")
	public ResponseEntity<Object> getStandardIn(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			List<String> lista = new ArrayList<>();
			lista.add("A");
			lista.add("B");
			lista.add("C");
			control.setReferenceValues(lista);
			control.setType(GooseStandardControlEnum.IN.getValue());
			control.setErrorMessage("Il campo " + id + " deve essere uguale ad A B o C");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/not-in")
	public ResponseEntity<Object> getStandardNotIn(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			List<String> lista = new ArrayList<>();
			lista.add("A");
			lista.add("B");
			lista.add("C");
			control.setReferenceValues(lista);
			control.setType(GooseStandardControlEnum.NOT_IN.getValue());
			control.setErrorMessage("Il campo " + id + " non deve essere uguale ad A B o C");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/min-text")
	public ResponseEntity<Object> getStandardMinText(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			control.setReferenceValue("5");
			control.setType(GooseStandardControlEnum.MIN_TEXT.getValue());
			control.setErrorMessage("Il campo " + id + " deve essere lungo almeno 5 caratteri");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/max-text")
	public ResponseEntity<Object> getStandardMaxText(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			control.setReferenceValue("5");
			control.setType(GooseStandardControlEnum.MAX_TEXT.getValue());
			control.setErrorMessage("Il campo " + id + " deve essere lungo al massimo 5 caratteri");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/min")
	public ResponseEntity<Object> getStandardMin(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			control.setReferenceValue("2022-10-18");
			control.setType(GooseStandardControlEnum.MIN.getValue());
			control.setErrorMessage(
					"Il campo " + id + " deve essere maggiore o uguale a " + control.getReferenceValue());
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/standard/max")
	public ResponseEntity<Object> getStandardMax(HttpServletRequest request) {
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			control.setReferenceValue("2022-10-18");
			control.setType(GooseStandardControlEnum.MAX.getValue());
			control.setErrorMessage("Il campo " + id + " deve essere minore o uguale a " + control.getReferenceValue());
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/equal")
	public ResponseEntity<Object> getComplexEqual(HttpServletRequest request) {

		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> listaComponenti = new ArrayList<>();
		listaComponenti.add(DemoUtil.generaGooseTextField("a"));
		listaComponenti.add(DemoUtil.generaGooseTextField("b"));
		form.setComponents(listaComponenti);

		List<GooseControl> listaControlli = new ArrayList<>();

		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.COMPLEX.getValue());
		GooseComplexControl control = new GooseComplexControl();
		control.setIdComponentA("a");
		control.setIdComponentB("b");
		control.setType(GooseComplexControlEnum.EQUAL.getValue());
		control.setErrorMessage("Il campo a deve essere uguale al campo b ");
		tmp.setDetail(control);
		listaControlli.add(tmp);

		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/not-equal")
	public ResponseEntity<Object> getComplexNotEqual(HttpServletRequest request) {

		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> listaComponenti = new ArrayList<>();
		listaComponenti.add(DemoUtil.generaGooseTextField("a"));
		listaComponenti.add(DemoUtil.generaGooseTextField("b"));
		form.setComponents(listaComponenti);

		List<GooseControl> listaControlli = new ArrayList<>();

		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.COMPLEX.getValue());
		GooseComplexControl control = new GooseComplexControl();
		control.setIdComponentA("a");
		control.setIdComponentB("b");
		control.setType(GooseComplexControlEnum.NOT_EQUAL.getValue());
		control.setErrorMessage("Il campo a non deve essere uguale al campo b ");
		tmp.setDetail(control);
		listaControlli.add(tmp);

		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/min")
	public ResponseEntity<Object> getComplexMin(HttpServletRequest request) {

		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> listaComponenti = new ArrayList<>();
		listaComponenti.add(DemoUtil.generaGooseNumberField("a"));
		listaComponenti.add(DemoUtil.generaGooseNumberField("b"));
		form.setComponents(listaComponenti);

		List<GooseControl> listaControlli = new ArrayList<>();

		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.COMPLEX.getValue());
		GooseComplexControl control = new GooseComplexControl();
		control.setIdComponentA("a");
		control.setIdComponentB("b");
		control.setType(GooseComplexControlEnum.MIN.getValue());
		control.setErrorMessage("Il campo a deve essere maggiore del campo b ");
		tmp.setDetail(control);
		listaControlli.add(tmp);

		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}

	@GetMapping("/complex/max")
	public ResponseEntity<Object> getComplexMax(HttpServletRequest request) {

		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> listaComponenti = new ArrayList<>();
		listaComponenti.add(DemoUtil.generaGooseNumberField("a"));
		listaComponenti.add(DemoUtil.generaGooseNumberField("b"));
		form.setComponents(listaComponenti);

		List<GooseControl> listaControlli = new ArrayList<>();

		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.COMPLEX.getValue());
		GooseComplexControl control = new GooseComplexControl();
		control.setIdComponentA("a");
		control.setIdComponentB("b");
		control.setType(GooseComplexControlEnum.MAX.getValue());
		control.setErrorMessage("Il campo a deve essere minore del campo b ");
		tmp.setDetail(control);
		listaControlli.add(tmp);

		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form, HttpStatus.OK);
	}


}
