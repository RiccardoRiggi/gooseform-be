package it.riccardoriggi.gooseform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.utils.DemoUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/componenti")
public class ComponentiController {


	@GetMapping("/goose-text-area")
	public ResponseEntity<Object> getGooseTextArea(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextArea("gooseTextArea"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-select-static")
	public ResponseEntity<Object> getGooseSelectStatic(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectStatica("gooseSelectStatica"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-select-dynamic")
	public ResponseEntity<Object> getGooseSelectDynamic(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectDinamica("gooseSelectDinamica"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-select-dynamic-due")
	public ResponseEntity<Object> getGooseSelectDynamicDue(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseSelectDinamicaDue("gooseSelectDinamicaDue"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}


	@GetMapping("/goose-linked-select")
	public ResponseEntity<Object> getGooseLinkedSelectDynamic(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseLinkedSelectPadre("gooseLinkedSelectPadre","gooseLinkedSelectFiglia"));
		componenti.add(DemoUtil.generaGooseLinkedSelectFiglia("gooseLinkedSelectFiglia","gooseLinkedSelectPadre"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-data-list-static")
	public ResponseEntity<Object> getGooseDataListStatic(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDataListStatica("gooseDataListStatica"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-data-list-dynamic")
	public ResponseEntity<Object> getGooseDataListDynamic(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDataListDinamica("gooseDataListDinamica"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-text-field")
	public ResponseEntity<Object> getGooseTextField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTextField("gooseTextField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-password-field")
	public ResponseEntity<Object> getGoosePasswordField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGoosePasswordField("goosePasswordField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-number-field")
	public ResponseEntity<Object> getGooseNumberField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseNumberField("gooseNumberField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-radio-static")
	public ResponseEntity<Object> getGooseRadioStatic(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseRadioStatica("gooseRadioStatica"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-radio-dynamic")
	public ResponseEntity<Object> getGooseRadioDynamic(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseRadioDinamica("gooseRadioDinamica"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-checkbox")
	public ResponseEntity<Object> getGooseCheckbox(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseCheckbox());
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-email-field")
	public ResponseEntity<Object> getGooseEmailField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseEmailField("gooseEmailField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-date-field")
	public ResponseEntity<Object> getGooseDateField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateField("gooseDateField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-date-time-field")
	public ResponseEntity<Object> getGooseDateTimeField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseDateTimeField("gooseDateTimeField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-mounth-field")
	public ResponseEntity<Object> getGooseMounthField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseMounthField("gooseMounthField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-week-field")
	public ResponseEntity<Object> getGooseWeekField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseWeekField("gooseWeekField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-time-field")
	public ResponseEntity<Object> getGooseTimeField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTimeField("gooseTimeField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-url-field")
	public ResponseEntity<Object> getGooseUrlField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseUrlField("gooseUrlField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-tel-field")
	public ResponseEntity<Object> getGooseTelField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseTelField("gooseTelField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-color-field")
	public ResponseEntity<Object> getGooseColorField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseColorField("gooseColorField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}

	@GetMapping("/goose-range-field")
	public ResponseEntity<Object> getGooseRangeField(HttpServletRequest request){
		GooseForm form = DemoUtil.generaGooseForm();
		List<GooseComponent> componenti = form.getComponents();
		componenti.add(DemoUtil.generaGooseRangeField("gooseRangeField"));
		form.setComponents(componenti);
		return new ResponseEntity<Object>(form,HttpStatus.OK);
	}


}
