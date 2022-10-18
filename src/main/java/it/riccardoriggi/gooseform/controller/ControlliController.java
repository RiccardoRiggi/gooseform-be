package it.riccardoriggi.gooseform.controller;

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
import it.riccardoriggi.gooseform.entity.GooseStandardControl;
import it.riccardoriggi.gooseform.enums.GooseControlEnum;
import it.riccardoriggi.gooseform.enums.GooseStandardControlEnum;
import it.riccardoriggi.gooseform.utils.DemoUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/controlli")
public class ControlliController {

	private List<String> getListaId(List<GooseComponent> listaComponenti){
		List<String> lista = new ArrayList<>();
		for (GooseComponent componente : listaComponenti) {
			lista.add(componente.getId());
		}
		return lista;
	}

	private GooseForm getCompleteForm() {
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea());
		componenti.add(DemoUtil.generaGooseSelectStatica());
		componenti.add(DemoUtil.generaGooseSelectDinamica());
		componenti.add(DemoUtil.generaGooseLinkedSelectPadre());
		componenti.add(DemoUtil.generaGooseLinkedSelectFiglia());
		componenti.add(DemoUtil.generaGooseDataListStatica());
		componenti.add(DemoUtil.generaGooseDataListDinamica());
		componenti.add(DemoUtil.generaGooseTextField());
		componenti.add(DemoUtil.generaGoosePasswordField());
		componenti.add(DemoUtil.generaGooseNumberField());
		componenti.add(DemoUtil.generaGooseRadioStatica());
		componenti.add(DemoUtil.generaGooseRadioDinamica());
		componenti.add(DemoUtil.generaGooseCheckbox());
		componenti.add(DemoUtil.generaGooseEmailField());
		componenti.add(DemoUtil.generaGooseDateField());
		componenti.add(DemoUtil.generaGooseDateTimeField());
		componenti.add(DemoUtil.generaGooseMounthField());
		componenti.add(DemoUtil.generaGooseWeekField());
		componenti.add(DemoUtil.generaGooseTimeField());
		componenti.add(DemoUtil.generaGooseColorField());
		componenti.add(DemoUtil.generaGooseRangeField());
		form.setComponents(componenti);
		return form;
	}


	@GetMapping("/standard/required")
	public ResponseEntity<Object> getStandardRequired(HttpServletRequest request){
		GooseForm form = getCompleteForm();

		List<GooseControl> listaControlli = new ArrayList<>();

		List<String> listaId = getListaId(form.getComponents());
		for (String id : listaId) {
			GooseControl tmp = new GooseControl();
			tmp.setType(GooseControlEnum.STANDARD.getValue());
			GooseStandardControl control = new GooseStandardControl();
			control.setIdComponentA(id);
			control.setType(GooseStandardControlEnum.REQUIRED.getValue());
			control.setErrorMessage("Il campo "+id+" è richiesto");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/equal")
	public ResponseEntity<Object> getStandardEqual(HttpServletRequest request){
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
			control.setErrorMessage("Il campo "+id+" deve essere uguale a <goose>");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/standard/not-equal")
	public ResponseEntity<Object> getStandardNotEqual(HttpServletRequest request){
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
			control.setErrorMessage("Il campo "+id+" non deve essere uguale a <goose>");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}


	@GetMapping("/standard/pattern")
	public ResponseEntity<Object> getStandardPattern(HttpServletRequest request){
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
			control.setErrorMessage("Il campo "+id+" deve contenere almeno a, b o c");
			tmp.setDetail(control);
			listaControlli.add(tmp);
		}
		form.setControls(listaControlli);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}




}
