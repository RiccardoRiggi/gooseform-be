package it.riccardoriggi.gooseform.controller.manager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.riccardoriggi.gooseform.constants.GooseErrors;
import it.riccardoriggi.gooseform.entity.GooseButton;
import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseControl;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.entity.GooseHttpRequest;
import it.riccardoriggi.gooseform.entity.GoosePopup;
import it.riccardoriggi.gooseform.entity.GooseRender;
import it.riccardoriggi.gooseform.entity.GooseTooltip;
import it.riccardoriggi.gooseform.entity.db.GooseButtonDb;
import it.riccardoriggi.gooseform.entity.db.GooseComponentDb;
import it.riccardoriggi.gooseform.entity.db.GooseComponentSpecificDb;
import it.riccardoriggi.gooseform.entity.db.GooseControlDb;
import it.riccardoriggi.gooseform.entity.db.GooseFormDb;
import it.riccardoriggi.gooseform.entity.db.GooseHttpRequestDb;
import it.riccardoriggi.gooseform.entity.db.GooseKControlDb;
import it.riccardoriggi.gooseform.entity.db.GooseKvComponentDb;
import it.riccardoriggi.gooseform.entity.db.GooseKvHttpRequestDb;
import it.riccardoriggi.gooseform.entity.db.GoosePopupDb;
import it.riccardoriggi.gooseform.entity.db.GooseRenderDb;
import it.riccardoriggi.gooseform.entity.db.GooseTooltipDb;
import it.riccardoriggi.gooseform.exceptions.GooseFormException;
import it.riccardoriggi.gooseform.interfaces.GooseButtonInterface;
import it.riccardoriggi.gooseform.interfaces.GooseComponentSpecificiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseComponentiInterface;
import it.riccardoriggi.gooseform.interfaces.GooseControlInterface;
import it.riccardoriggi.gooseform.interfaces.GooseFormInterface;
import it.riccardoriggi.gooseform.interfaces.GooseHttpRequestInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKControlInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKvComponentInterface;
import it.riccardoriggi.gooseform.interfaces.GooseKvHttpRequestInterface;
import it.riccardoriggi.gooseform.interfaces.GoosePopupInterface;
import it.riccardoriggi.gooseform.interfaces.GooseRenderInterface;
import it.riccardoriggi.gooseform.interfaces.GooseTooltipInterface;
import it.riccardoriggi.gooseform.utils.GooseConversionUtil;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/manager/anteprima")
public class AnteprimaController {

	@Autowired
	GooseFormInterface formService;

	@Autowired
	GooseComponentiInterface componentiService;

	@Autowired
	GooseComponentSpecificiInterface componentSpecificService;

	@Autowired
	GooseKvComponentInterface componentKvService;

	@Autowired
	GooseRenderInterface renderService;

	@Autowired
	GooseControlInterface controlService;

	@Autowired
	GooseKControlInterface kControlService;

	@Autowired
	GooseButtonInterface buttonService;

	@Autowired
	GoosePopupInterface popupService;

	@Autowired
	GooseTooltipInterface tooltipService;

	@Autowired
	GooseHttpRequestInterface httpService;

	@Autowired
	GooseKvHttpRequestInterface kvHttpService;


	@GetMapping("/{formId}")
	public ResponseEntity<Object> getAnteprimaForm(HttpServletRequest request,@PathVariable("formId") String formId){

		try {
			verificaEsistenzaForm(formId);

			GooseForm form = getForm(formId);
			form.setResetButton(getResetButton(formId));
			form.setSendButton(getSendButton(formId));
			form.setPopup(getPopup(formId));
			form.setDestinationUrl(getHttpRequestDestination(formId));
			form.setOriginUrl(getHttpRequestOrigin(formId));


			form.setComponents(getComponents(formId));

			form.setControls(getControls(formId));
			form.setRenders(getRenders(formId));

			return new ResponseEntity<>(form,HttpStatus.OK);
		} catch (GooseFormException e) {
			return new ResponseEntity<>(e.getProblem(),HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}















	private void verificaEsistenzaForm(String formId) throws GooseFormException {
		if(!formService.isFormEsistente(formId)) {
			throw new GooseFormException(500, GooseErrors.FORM_NON_ESISTENTE);
		}
	}

	private GooseForm getForm(String formId) throws GooseFormException{
		GooseFormDb formDb = formService.getFormById(formId);
		return GooseConversionUtil.toGooseForm(formDb);
	}

	private GooseButton getResetButton(String formId) throws GooseFormException{
		GooseButtonDb formDb = buttonService.getButton( formId,"RESET");
		return GooseConversionUtil.toGooseButton(formDb);
	}

	private GooseButton getSendButton(String formId) throws GooseFormException{
		GooseButtonDb formDb = buttonService.getButton(formId,"SEND");
		return GooseConversionUtil.toGooseButton(formDb);
	}

	private GoosePopup getPopup(String formId) throws GooseFormException{
		GoosePopupDb formDb = popupService.getPopupByFormId(formId);
		return GooseConversionUtil.toGoosePopup(formDb);
	}

	private GoosePopup getPopup(String formId, String componentId) throws GooseFormException{
		GoosePopupDb formDb = popupService.getPopupById(formId, componentId);
		return GooseConversionUtil.toGoosePopup(formDb);
	}

	private GooseTooltip getTooltip(String formId, String componentId) throws GooseFormException{
		GooseTooltipDb formDb = tooltipService.getTooltipById(formId, componentId);
		return GooseConversionUtil.toGooseTooltip(formDb);
	}

	private GooseHttpRequest getHttpRequestDestination(String formId) throws GooseFormException {
		GooseHttpRequestDb chiamataDb = httpService.getChiamataByFormId(formId, "SUBMIT");
		List<GooseKvHttpRequestDb> lista = new ArrayList<GooseKvHttpRequestDb>();
		if(chiamataDb!=null) {
			lista = kvHttpService.getLista(chiamataDb.getPk());
		}
		return GooseConversionUtil.toHttpRequest(chiamataDb,lista);

	}

	private GooseHttpRequest getHttpRequestOrigin(String formId) throws GooseFormException {
		GooseHttpRequestDb chiamataDb = httpService.getChiamataByFormId(formId, "DATA");
		List<GooseKvHttpRequestDb> lista = new ArrayList<GooseKvHttpRequestDb>();
		if(chiamataDb!=null) {
			lista = kvHttpService.getLista(chiamataDb.getPk());
		}
		return GooseConversionUtil.toHttpRequest(chiamataDb,lista);

	}

	private List<GooseRender> getRenders(String formId) throws GooseFormException{
		List<GooseRenderDb> listaDb = renderService.getRenders(formId);
		return GooseConversionUtil.toGooseRender(listaDb);
	}

	private List<GooseControl> getControls(String formId) throws GooseFormException {
		List<GooseControl> listaControlli = new ArrayList<>();

		List<GooseControlDb> listaControlliDb = controlService.getControlli(formId);

		for (GooseControlDb dbTmp : listaControlliDb) {
			List<GooseKControlDb> listaValue = new ArrayList<>();
			if("IN".equals(dbTmp.getTypeSpecific()) || "NOT_IN".equals(dbTmp.getTypeSpecific())) {
				listaValue = kControlService.getLista(dbTmp.getPk());
			}
			listaControlli.add(GooseConversionUtil.toGooseControl(dbTmp,listaValue));
		}
		return listaControlli;
	}


	private List<GooseComponent> getComponents(String formId) throws GooseFormException {
		List<GooseComponent> listaComponenti = new ArrayList<>();

		List<GooseComponentDb> listaComponentiDb = componentiService.getComponenti(formId);
		for (GooseComponentDb componenteDb : listaComponentiDb) {
			String componentId = componenteDb.getId();
			List<GooseComponentSpecificDb> listaComponentiSpecificiDb = componentSpecificService.getRighe(formId, componentId);
			List<GooseKvComponentDb> listaChiaveValoreDb = componentKvService.getLista(formId, componentId);
			GooseHttpRequestDb chiamataHttp = httpService.getChiamataById(formId, componentId);
			GoosePopup popup = getPopup(formId, componentId);
			GooseTooltip tooltip = getTooltip(formId, componentId);
			List<GooseKvHttpRequestDb> kvHttp = new ArrayList<>();
			if(chiamataHttp!=null) {
				kvHttp = kvHttpService.getLista(chiamataHttp.getPk());
			}
			listaComponenti.add(GooseConversionUtil.toGooseComponent(componenteDb,listaComponentiSpecificiDb,listaChiaveValoreDb,chiamataHttp, popup, tooltip,kvHttp));
		}


		return listaComponenti;
	}
}
