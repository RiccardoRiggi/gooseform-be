package it.riccardoriggi.gooseform.utils;

import java.util.ArrayList;
import java.util.List;

import it.riccardoriggi.gooseform.entity.GooseButton;
import it.riccardoriggi.gooseform.entity.GooseCheckbox;
import it.riccardoriggi.gooseform.entity.GooseColorField;
import it.riccardoriggi.gooseform.entity.GooseComplexControl;
import it.riccardoriggi.gooseform.entity.GooseComplexRenderConditional;
import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseControl;
import it.riccardoriggi.gooseform.entity.GooseDataList;
import it.riccardoriggi.gooseform.entity.GooseDateField;
import it.riccardoriggi.gooseform.entity.GooseDateTimeField;
import it.riccardoriggi.gooseform.entity.GooseEmailField;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.entity.GooseHttpRequest;
import it.riccardoriggi.gooseform.entity.GooseKeyValue;
import it.riccardoriggi.gooseform.entity.GooseLinkedSelect;
import it.riccardoriggi.gooseform.entity.GooseMonthField;
import it.riccardoriggi.gooseform.entity.GooseNumberField;
import it.riccardoriggi.gooseform.entity.GoosePasswordField;
import it.riccardoriggi.gooseform.entity.GoosePopup;
import it.riccardoriggi.gooseform.entity.GooseRadio;
import it.riccardoriggi.gooseform.entity.GooseRangeField;
import it.riccardoriggi.gooseform.entity.GooseRender;
import it.riccardoriggi.gooseform.entity.GooseSelect;
import it.riccardoriggi.gooseform.entity.GooseSimpleRenderConditional;
import it.riccardoriggi.gooseform.entity.GooseStandardControl;
import it.riccardoriggi.gooseform.entity.GooseTelField;
import it.riccardoriggi.gooseform.entity.GooseTextArea;
import it.riccardoriggi.gooseform.entity.GooseTextField;
import it.riccardoriggi.gooseform.entity.GooseTimeField;
import it.riccardoriggi.gooseform.entity.GooseTooltip;
import it.riccardoriggi.gooseform.entity.GooseUrlField;
import it.riccardoriggi.gooseform.entity.GooseWeekField;
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
import it.riccardoriggi.gooseform.enums.GooseComponentEnum;
import it.riccardoriggi.gooseform.enums.GooseControlEnum;
import it.riccardoriggi.gooseform.enums.GooseRenderEnum;

public class GooseConversionUtil {

	public static GooseForm toGooseForm(GooseFormDb form) {
		if(form==null) {
			return null;
		}
		GooseForm db = new GooseForm();
		db.setDescription(form.getDescription());
		db.setFormId(form.getFormId());
		db.setIcon(form.getIcon());
		db.setTitle(form.getTitle());
		return db;
	}

	public static GooseButton toGooseButton(GooseButtonDb db) {
		if(db==null) {
			return null;
		}
		GooseButton button = new GooseButton();
		button.setIcon(db.getIcon());
		button.setTitle(db.getTitle());
		return button;
	}

	public static GoosePopup toGoosePopup(GoosePopupDb db) {
		if(db==null) {
			return null;
		}
		GoosePopup button = new GoosePopup();
		button.setIcon(db.getIcon());
		button.setTitle(db.getTitle());
		button.setDescription(db.getDescription());
		button.setTextTooltip(db.getTextTooltip());
		return button;
	}

	public static GooseHttpRequest toHttpRequest(GooseHttpRequestDb db, List<GooseKvHttpRequestDb> listaDb) {
		if(db==null) {
			return null;
		}
		GooseHttpRequest chiamata = new GooseHttpRequest();
		chiamata.setBody(db.getBody());
		chiamata.setMethod(db.getMethod());
		chiamata.setUrl(db.getUrl());

		List<GooseKeyValue> lista = new ArrayList<>();
		for (GooseKvHttpRequestDb tmp : listaDb) {
			lista.add(new GooseKeyValue(tmp.getK(), tmp.getV()));
		}
		chiamata.setHeaders(lista);
		return chiamata;
	}

	public static List<GooseRender> toGooseRender(List<GooseRenderDb> listaDb) {
		List<GooseRender> listaFinale = new ArrayList<>();

		for (GooseRenderDb tmpDb : listaDb) {
			GooseRender tmp = new GooseRender();
			tmp.setType(tmpDb.getType());
			if(GooseRenderEnum.SIMPLE_RENDER.getValue().equals(tmpDb.getType())) {
				GooseSimpleRenderConditional simple = new GooseSimpleRenderConditional();
				simple.setIdComponentA(tmpDb.getIdComponentA());
				simple.setIdComponentB(tmpDb.getIdComponentB());
				simple.setType(tmpDb.getTypeSpecific());
				simple.setValue(tmpDb.getValue());
				tmp.setDetail(simple);
			}else if(GooseRenderEnum.COMPLEX_RENDER.getValue().equals(tmpDb.getType())) {
				GooseComplexRenderConditional complex = new GooseComplexRenderConditional();
				complex.setIdComponentA(tmpDb.getIdComponentA());
				complex.setIdComponentB(tmpDb.getIdComponentB());
				complex.setIdComponentC(tmpDb.getIdComponentC());
				complex.setType(tmpDb.getTypeSpecific());
				tmp.setDetail(complex);
			}
			listaFinale.add(tmp);
		}

		return listaFinale;
	}

	public static GooseControl toGooseControl(GooseControlDb dbTmp, List<GooseKControlDb> listaValue) {
		GooseControl control = new GooseControl();
		control.setType(dbTmp.getType());
		if(GooseControlEnum.STANDARD.getValue().equals(dbTmp.getType())) {
			GooseStandardControl c = new GooseStandardControl();
			c.setErrorMessage(dbTmp.getErrorMessage());
			c.setIdComponentA(dbTmp.getIdComponentA());
			c.setReferenceValue(dbTmp.getReferenceValue());
			c.setType(dbTmp.getTypeSpecific());
			List<String> listaString = new ArrayList<String>();
			for (GooseKControlDb v : listaValue) {
				listaString.add(v.getK());
			}
			c.setReferenceValues(listaString);
			control.setDetail(c);
		}else if(GooseControlEnum.COMPLEX.getValue().equals(dbTmp.getType())){
			GooseComplexControl c = new GooseComplexControl();
			c.setErrorMessage(dbTmp.getErrorMessage());
			c.setIdComponentA(dbTmp.getIdComponentA());
			c.setIdComponentB(dbTmp.getIdComponentB());
			c.setType(dbTmp.getTypeSpecific());
			control.setDetail(c);
		}
		return control;
	}

	public static GooseComponent toGooseComponent(GooseComponentDb componenteDb,
			List<GooseComponentSpecificDb> listaComponentiSpecificiDb, List<GooseKvComponentDb> listaChiaveValoreDb,
			GooseHttpRequestDb chiamataHttp, GoosePopup popup, GooseTooltip tooltip, List<GooseKvHttpRequestDb> kvHttp) {
		GooseComponent componente = new GooseComponent();
		componente.setFormId(componenteDb.getFormId());
		componente.setId(componenteDb.getId());
		componente.setLabel(componenteDb.getLabel());
		componente.setPopup(popup);
		componente.setRequiredMark(componenteDb.isRequiredMark());
		componente.setTooltip(tooltip);
		componente.setType(componenteDb.getType());
		componente.setWidth(componenteDb.getWidth());
		componente.setWidthLg(componenteDb.getWidthLg());
		componente.setWidthMd(componenteDb.getWidthMd());
		componente.setWidthSm(componenteDb.getWidthSm());
		componente.setWidthXl(componenteDb.getWidthXl());
		componente.setSetting(getSetting(componenteDb.getType(),listaComponentiSpecificiDb,listaChiaveValoreDb,chiamataHttp,kvHttp));
		return componente;
	}

	private static Object getSetting(String type, List<GooseComponentSpecificDb> listaComponentiSpecificiDb,
			List<GooseKvComponentDb> listaChiaveValoreDb, GooseHttpRequestDb chiamataHttp, List<GooseKvHttpRequestDb> kvHttp) {

		List<GooseKeyValue> listaKV = new ArrayList<>();
		for (GooseKvComponentDb tmp : listaChiaveValoreDb) {
			listaKV.add(new GooseKeyValue(tmp.getK(), tmp.getV()));
		}

		if(GooseComponentEnum.GOOSE_TEXT_AREA.getValue().equals(type)) {
			return toGooseTextArea(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_SELECT.getValue().equals(type)) {
			return toGooseSelect(listaComponentiSpecificiDb,listaChiaveValoreDb,chiamataHttp,kvHttp);
		}else if(GooseComponentEnum.GOOSE_LINKED_SELECT.getValue().equals(type)) {
			return toGooseLinkedSelect(listaComponentiSpecificiDb,listaChiaveValoreDb,chiamataHttp,kvHttp);
		}else if(GooseComponentEnum.GOOSE_DATA_LIST.getValue().equals(type)) {
			return toGooseDataList(listaComponentiSpecificiDb,listaChiaveValoreDb,chiamataHttp,kvHttp);
		}else if(GooseComponentEnum.GOOSE_TEXT_FIELD.getValue().equals(type)) {
			return toGooseTextField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_PASSWORD_FIELD.getValue().equals(type)) {
			return toGoosePasswordField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_NUMBER_FIELD.getValue().equals(type)) {
			return toGooseNumberField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_RADIO.getValue().equals(type)) {
			return toGooseRadio(listaComponentiSpecificiDb,listaChiaveValoreDb,chiamataHttp,kvHttp);
		}else if(GooseComponentEnum.GOOSE_CHECKBOX.getValue().equals(type)) {
			return toGooseCheckBox(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_EMAIL_FIELD.getValue().equals(type)) {
			return toGooseEmailField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_DATE_FIELD.getValue().equals(type)) {
			return toGooseDateField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_DATE_TIME_FIELD.getValue().equals(type)) {
			return toGooseDateTimeField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_MONTH_FIELD.getValue().equals(type)) {
			return toGooseMonthField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_WEEK_FIELD.getValue().equals(type)) {
			return toGooseWeekField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_TIME_FIELD.getValue().equals(type)) {
			return toGooseTimeField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_TEL_FIELD.getValue().equals(type)) {
			return toGooseTelField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_URL_FIELD.getValue().equals(type)) {
			return toGooseUrlField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_COLOR_FIELD.getValue().equals(type)) {
			return toGooseColorField(listaComponentiSpecificiDb);
		}else if(GooseComponentEnum.GOOSE_RANGE_FIELD.getValue().equals(type)) {
			return toGooseRangeField(listaComponentiSpecificiDb);
		}
		return null;
	}

	private static GooseRangeField toGooseRangeField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseRangeField options = new GooseRangeField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("min".equals(tmp.getNomeAttributo())){
				options.setMin(tmp.getValoreAttributo());
			}else if("max".equals(tmp.getNomeAttributo())){
				options.setMax(tmp.getValoreAttributo());
			}else if("step".equals(tmp.getNomeAttributo())){
				options.setStep(tmp.getValoreAttributo());
			}
		}
		return options;
	}

	private static GooseColorField toGooseColorField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseColorField options = new GooseColorField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseUrlField toGooseUrlField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseUrlField options = new GooseUrlField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("placeholder".equals(tmp.getNomeAttributo())) {
				options.setPlaceholder(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("autofocus".equals(tmp.getNomeAttributo())) {
				options.setAutofocus("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseTelField toGooseTelField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseTelField options = new GooseTelField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("placeholder".equals(tmp.getNomeAttributo())) {
				options.setPlaceholder(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("autofocus".equals(tmp.getNomeAttributo())) {
				options.setAutofocus("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseTimeField toGooseTimeField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseTimeField options = new GooseTimeField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseWeekField toGooseWeekField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseWeekField options = new GooseWeekField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseMonthField toGooseMonthField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseMonthField options = new GooseMonthField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseDateTimeField toGooseDateTimeField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseDateTimeField options = new GooseDateTimeField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseDateField toGooseDateField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseDateField options = new GooseDateField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseEmailField toGooseEmailField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseEmailField options = new GooseEmailField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("placeholder".equals(tmp.getNomeAttributo())) {
				options.setPlaceholder(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("autofocus".equals(tmp.getNomeAttributo())) {
				options.setAutofocus("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseCheckbox toGooseCheckBox(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseCheckbox options = new GooseCheckbox();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseRadio toGooseRadio(List<GooseComponentSpecificDb> listaComponentiSpecificiDb,
			List<GooseKvComponentDb> listaChiaveValoreDb, GooseHttpRequestDb chiamataHttp, List<GooseKvHttpRequestDb> kvHttp) {
		GooseRadio options = new GooseRadio();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("keyName".equals(tmp.getNomeAttributo())){
				options.setKeyName(tmp.getValoreAttributo());
			}else if("valueName".equals(tmp.getNomeAttributo())) {
				options.setValueName(tmp.getValoreAttributo());
			}
		}

		options.setDynamicValues(toHttpRequest(chiamataHttp, kvHttp));
		options.setValues(toGooseKeyValue(listaChiaveValoreDb));
		return options;
	}

	private static GooseNumberField toGooseNumberField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseNumberField options = new GooseNumberField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("placeholder".equals(tmp.getNomeAttributo())) {
				options.setPlaceholder(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("autofocus".equals(tmp.getNomeAttributo())) {
				options.setAutofocus("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("steps".equals(tmp.getNomeAttributo())) {
				options.setSteps(Long.valueOf(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GoosePasswordField toGoosePasswordField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GoosePasswordField options = new GoosePasswordField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("placeholder".equals(tmp.getNomeAttributo())) {
				options.setPlaceholder(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("autofocus".equals(tmp.getNomeAttributo())) {
				options.setAutofocus("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}
	private static GooseTextField toGooseTextField(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseTextField options = new GooseTextField();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("placeholder".equals(tmp.getNomeAttributo())) {
				options.setPlaceholder(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("autofocus".equals(tmp.getNomeAttributo())) {
				options.setAutofocus("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	private static GooseDataList toGooseDataList(List<GooseComponentSpecificDb> listaComponentiSpecificiDb,
			List<GooseKvComponentDb> listaChiaveValoreDb, GooseHttpRequestDb chiamataHttp, List<GooseKvHttpRequestDb> kvHttp) {
		GooseDataList options = new GooseDataList();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("name".equals(tmp.getNomeAttributo())){
				options.setName(tmp.getValoreAttributo());
			}else if("placeholder".equals(tmp.getNomeAttributo())) {
				options.setPlaceholder(tmp.getValoreAttributo());
			}else if("disabled".equals(tmp.getNomeAttributo())) {
				options.setDisabled("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("readonly".equals(tmp.getNomeAttributo())) {
				options.setReadonly("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("autofocus".equals(tmp.getNomeAttributo())) {
				options.setAutofocus("TRUE".equalsIgnoreCase(tmp.getValoreAttributo()));
			}else if("keyName".equals(tmp.getNomeAttributo())){
				options.setKeyName(tmp.getValoreAttributo());
			}else if("valueName".equals(tmp.getNomeAttributo())) {
				options.setValueName(tmp.getValoreAttributo());
			}
		}

		options.setDynamicValues(toHttpRequest(chiamataHttp, kvHttp));
		options.setValues(toGooseKeyValue(listaChiaveValoreDb));
		return options;
	}

	private static GooseLinkedSelect toGooseLinkedSelect(List<GooseComponentSpecificDb> listaComponentiSpecificiDb,
			List<GooseKvComponentDb> listaChiaveValoreDb, GooseHttpRequestDb chiamataHttp, List<GooseKvHttpRequestDb> kvHttp) {
		GooseLinkedSelect options = new GooseLinkedSelect();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("keyName".equals(tmp.getNomeAttributo())){
				options.setKeyName(tmp.getValoreAttributo());
			}else if("valueName".equals(tmp.getNomeAttributo())) {
				options.setValueName(tmp.getValoreAttributo());
			}else if("size".equals(tmp.getNomeAttributo())) {
				options.setSize(Long.valueOf(tmp.getValoreAttributo()));
			}else if("idLinkedSelectPadre".equals(tmp.getNomeAttributo())) {
				options.setIdLinkedSelectPadre(tmp.getValoreAttributo());
			}else if("idLinkedSelectFiglia".equals(tmp.getNomeAttributo())) {
				options.setIdLinkedSelectFiglia(tmp.getValoreAttributo());
			}
		}

		options.setDynamicValues(toHttpRequest(chiamataHttp, kvHttp));
		options.setValues(toGooseKeyValue(listaChiaveValoreDb));
		return options;
	}

	private static GooseSelect toGooseSelect(List<GooseComponentSpecificDb> listaComponentiSpecificiDb,
			List<GooseKvComponentDb> listaChiaveValoreDb, GooseHttpRequestDb chiamataHttp, List<GooseKvHttpRequestDb> kvHttp) {
		GooseSelect options = new GooseSelect();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("keyName".equals(tmp.getNomeAttributo())){
				options.setKeyName(tmp.getValoreAttributo());
			}else if("valueName".equals(tmp.getNomeAttributo())) {
				options.setValueName(tmp.getValoreAttributo());
			}else if("size".equals(tmp.getNomeAttributo())) {
				options.setSize(Long.valueOf(tmp.getValoreAttributo()));
			}
		}

		options.setDynamicValues(toHttpRequest(chiamataHttp, kvHttp));
		options.setValues(toGooseKeyValue(listaChiaveValoreDb));
		return options;
	}

	private static List<GooseKeyValue> toGooseKeyValue(List<GooseKvComponentDb> listaChiaveValoreDb) {
		List<GooseKeyValue> lista = new ArrayList<>();
		for (GooseKvComponentDb tmp : listaChiaveValoreDb) {
			lista.add(new GooseKeyValue(tmp.getK(), tmp.getV()));
		}
		return lista;
	}

	private static GooseTextArea toGooseTextArea(List<GooseComponentSpecificDb> listaComponentiSpecificiDb) {
		GooseTextArea options = new GooseTextArea();
		for (GooseComponentSpecificDb tmp : listaComponentiSpecificiDb) {
			if("rows".equals(tmp.getNomeAttributo())){
				options.setRows(Long.valueOf(tmp.getValoreAttributo()));
			}
		}
		return options;
	}

	public static GooseTooltip toGooseTooltip(GooseTooltipDb t) {
		if(t==null) {
			return null;
		}
		GooseTooltip tooltip = new GooseTooltip();
		tooltip.setDescription(t.getTooltip());
		tooltip.setIcon(t.getIcon());
		return tooltip;
	}

}
