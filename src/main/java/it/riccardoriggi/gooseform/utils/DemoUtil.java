package it.riccardoriggi.gooseform.utils;

import java.util.ArrayList;
import java.util.List;

import it.riccardoriggi.gooseform.entity.GooseButton;
import it.riccardoriggi.gooseform.entity.GooseCheckbox;
import it.riccardoriggi.gooseform.entity.GooseColorField;
import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseDataList;
import it.riccardoriggi.gooseform.entity.GooseDateField;
import it.riccardoriggi.gooseform.entity.GooseDateTimeField;
import it.riccardoriggi.gooseform.entity.GooseEmailField;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.entity.GooseHttpRequest;
import it.riccardoriggi.gooseform.entity.GooseKeyValue;
import it.riccardoriggi.gooseform.entity.GooseLinkedSelect;
import it.riccardoriggi.gooseform.entity.GooseMounthField;
import it.riccardoriggi.gooseform.entity.GooseNumberField;
import it.riccardoriggi.gooseform.entity.GoosePasswordField;
import it.riccardoriggi.gooseform.entity.GoosePopup;
import it.riccardoriggi.gooseform.entity.GooseRadio;
import it.riccardoriggi.gooseform.entity.GooseRangeField;
import it.riccardoriggi.gooseform.entity.GooseSelect;
import it.riccardoriggi.gooseform.entity.GooseTelField;
import it.riccardoriggi.gooseform.entity.GooseTextArea;
import it.riccardoriggi.gooseform.entity.GooseTextField;
import it.riccardoriggi.gooseform.entity.GooseTimeField;
import it.riccardoriggi.gooseform.entity.GooseTooltip;
import it.riccardoriggi.gooseform.entity.GooseUrlField;
import it.riccardoriggi.gooseform.entity.GooseWeekField;
import it.riccardoriggi.gooseform.enums.GooseComponentEnum;

public class DemoUtil {

	public static GooseForm generaGooseForm() {
		GooseForm form = new GooseForm();
		form.setDescription("Descrizione del form");
		form.setDestinationUrl(generaUrlDestinazione());
		form.setFormId("formId");
		form.setIcon("fas fa-feather-alt");
		form.setOriginUrl(generaUrlOrigine());
		form.setPopup(generaGoosePopup());
		form.setResetButton(generaResetButton());
		form.setSendButton(generaSendButton());
		form.setTitle("Titolo del form");
		return form;
	}

	private static GooseButton generaSendButton() {
		GooseButton button = new GooseButton();
		button.setIcon("fas fa-feather-alt");
		button.setTitle("Invia");
		return button;
	}

	private static GooseButton generaResetButton() {
		GooseButton button = new GooseButton();
		button.setIcon("fas fa-feather-alt");
		button.setTitle("Reset");
		return button;
	}

	private static GooseHttpRequest generaUrlDestinazione() {
		GooseHttpRequest req = new GooseHttpRequest();
		List<GooseKeyValue> listaHeaders = new ArrayList<>();
		listaHeaders.add(new GooseKeyValue("chiave", "valore"));
		req.setHeaders(listaHeaders);
		req.setMethod("POST");
		req.setUrl("URL_DESTINAZIONE");
		return req;
	}

	private static GooseHttpRequest generaUrlOrigine() {
		GooseHttpRequest req = new GooseHttpRequest();
		List<GooseKeyValue> listaHeaders = new ArrayList<>();
		listaHeaders.add(new GooseKeyValue("chiave", "valore"));
		req.setHeaders(listaHeaders);
		req.setMethod("POST");
		req.setUrl("URL_DOVE_VENGONO_LETTI_I_DATI");
		return req;
	}

	public static GooseComponent generaGooseTextArea(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Text Area - " + id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseTextArea textArea = new GooseTextArea();
		textArea.setRows(3L);
		componente.setSetting(textArea);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_TEXT_AREA.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	private static GooseTooltip generaGooseTooltip() {
		GooseTooltip popup = new GooseTooltip();
		popup.setDescription("Esempio di descrizione");
		popup.setIcon("fas fa-feather-alt");
		return popup;
	}

	private static GoosePopup generaGoosePopup() {
		GoosePopup popup = new GoosePopup();
		popup.setDescription("Esempio di descrizione");
		popup.setIcon("fas fa-feather-alt");
		popup.setTextTooltip("Esempio di testo tooltip");
		popup.setTitle("Titolo popup");
		return popup;
	}

	public static GooseComponent generaGooseSelectStatica(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Select Statica - " + id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseSelect select = new GooseSelect();
		select.setSize(1L);
		List<GooseKeyValue> valori = new ArrayList<>();
		valori.add(new GooseKeyValue("unoStatico", "Uno Statico"));
		valori.add(new GooseKeyValue("dueStatico", "Due Statico"));
		valori.add(new GooseKeyValue("treStatico", "Tre Statico"));
		valori.add(new GooseKeyValue("quattroStatico", "Quattro Statico"));
		valori.add(new GooseKeyValue("cinqueStatico", "Cinque Statico"));
		select.setValues(valori);
		componente.setSetting(select);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_SELECT.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseSelectDinamica(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Select Dinamica - " + id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseSelect select = new GooseSelect();
		select.setSize(1L);

		GooseHttpRequest http = new GooseHttpRequest();
		http.setUrl("http://localhost:8080/gooseform/opzioni");
		List<GooseKeyValue> listaHeader = new ArrayList<>();
		listaHeader.add(new GooseKeyValue("HEADER_1", "VALORE CUSTOM HEADER"));
		http.setHeaders(listaHeader);
		http.setMethod("POST");
		http.setBody("CORPO DELLA CHIAMATA");
		select.setDynamicValues(http);
		select.setKeyName("key");
		select.setValueName("value");

		componente.setSetting(select);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_SELECT.getValue());
		componente.setWidthXl("6");
		componente.setWidthLg("3");
		componente.setWidthMd("4");
		componente.setWidthSm("6");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseSelectDinamicaDue(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Select Dinamica");
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseSelect select = new GooseSelect();
		select.setSize(1L);

		GooseHttpRequest http = new GooseHttpRequest();
		http.setUrl("http://localhost:8080/gooseform/opzioniDue");
		List<GooseKeyValue> listaHeader = new ArrayList<>();
		listaHeader.add(new GooseKeyValue("HEADER_2", "VALORE NUOVO HEADER"));
		http.setHeaders(listaHeader);
		http.setMethod("POST");
		http.setBody("CORPO DELLA CHIAMATA DUE");
		select.setDynamicValues(http);
		select.setKeyName("chiave");
		select.setValueName("valore");

		componente.setSetting(select);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_SELECT.getValue());
		componente.setWidthXl("6");
		componente.setWidthLg("3");
		componente.setWidthMd("4");
		componente.setWidthSm("6");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseLinkedSelectPadre(String idPadre, String idFiglio) {
		GooseComponent componente = new GooseComponent();
		componente.setId(idPadre);
		componente.setLabel("Linked Select Padre - " + idPadre);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseLinkedSelect select = new GooseLinkedSelect();
		select.setSize(1L);
		select.setIdLinkedSelectPadre(null);
		select.setIdLinkedSelectFiglia(idFiglio);
		GooseHttpRequest http = new GooseHttpRequest();
		http.setUrl("http://localhost:8080/gooseform/opzioni");
		List<GooseKeyValue> listaHeader = new ArrayList<>();
		listaHeader.add(new GooseKeyValue("HEADER_1", "VALORE CUSTOM HEADER"));
		http.setHeaders(listaHeader);
		http.setMethod("POST");
		http.setBody("CORPO DELLA CHIAMATA");
		select.setDynamicValues(http);
		select.setKeyName("key");
		select.setValueName("value");

		componente.setSetting(select);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_LINKED_SELECT.getValue());
		componente.setWidthXl("6");
		componente.setWidthLg("6");
		componente.setWidthMd("6");
		componente.setWidthSm("6");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseLinkedSelectFiglia(String idFiglio, String idPadre) {
		GooseComponent componente = new GooseComponent();
		componente.setId(idFiglio);
		componente.setLabel("Linked Select Figlia - " + idFiglio);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseLinkedSelect select = new GooseLinkedSelect();
		select.setSize(1L);
		select.setIdLinkedSelectPadre(idPadre);
		select.setIdLinkedSelectFiglia(null);
		GooseHttpRequest http = new GooseHttpRequest();
		http.setUrl("http://localhost:8080/gooseform/linked");
		List<GooseKeyValue> listaHeader = new ArrayList<>();
		listaHeader.add(new GooseKeyValue("HEADER_1", "VALORE CUSTOM HEADER"));
		http.setHeaders(listaHeader);
		http.setMethod("POST");
		http.setBody("CORPO DELLA CHIAMATA");
		select.setDynamicValues(http);
		select.setKeyName("chiave");
		select.setValueName("valore");

		componente.setSetting(select);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_LINKED_SELECT.getValue());
		componente.setWidthXl("6");
		componente.setWidthLg("6");
		componente.setWidthMd("6");
		componente.setWidthSm("6");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseDataListStatica(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Data List Statica - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseDataList dataList = new GooseDataList();
		dataList.setAutofocus(true);
		dataList.setDisabled(false);
		dataList.setPlaceholder("Scegli valore");
		dataList.setName(id);
		dataList.setReadonly(false);
		List<GooseKeyValue> valori = new ArrayList<>();
		valori.add(new GooseKeyValue("unoStatico", "Uno Statico"));
		valori.add(new GooseKeyValue("dueStatico", "Due Statico"));
		valori.add(new GooseKeyValue("treStatico", "Tre Statico"));
		valori.add(new GooseKeyValue("quattroStatico", "Quattro Statico"));
		valori.add(new GooseKeyValue("cinqueStatico", "Cinque Statico"));
		dataList.setValues(valori);
		componente.setSetting(dataList);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_DATA_LIST.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseDataListDinamica(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Data List Dinamica");
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseDataList dataList = new GooseDataList();
		dataList.setAutofocus(true);
		dataList.setDisabled(false);
		dataList.setPlaceholder("Scegli valore");
		dataList.setName(id);
		dataList.setReadonly(false);

		GooseHttpRequest http = new GooseHttpRequest();
		http.setUrl("http://localhost:8080/gooseform/opzioniDue");
		List<GooseKeyValue> listaHeader = new ArrayList<>();
		listaHeader.add(new GooseKeyValue("HEADER_2", "VALORE NUOVO HEADER"));
		http.setHeaders(listaHeader);
		http.setMethod("POST");
		http.setBody("CORPO DELLA CHIAMATA DUE");
		dataList.setDynamicValues(http);
		dataList.setKeyName("chiave");
		dataList.setValueName("valore");

		componente.setSetting(dataList);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_DATA_LIST.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseTextField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Text Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseTextField text = new GooseTextField();
		text.setAutofocus(false);
		text.setDisabled(false);
		text.setName(id);
		text.setPlaceholder("Inserisci un testo...");
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_TEXT_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGoosePasswordField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Password Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GoosePasswordField text = new GoosePasswordField();
		text.setAutofocus(false);
		text.setDisabled(false);
		text.setName(id);
		text.setPlaceholder("Inserisci una password...");
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_PASSWORD_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseNumberField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Number Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseNumberField numb = new GooseNumberField();
		numb.setAutofocus(false);
		numb.setDisabled(false);
		numb.setName(id);
		numb.setPlaceholder("Inserisci un numero...");
		numb.setReadonly(false);
		numb.setSteps(2L);
		componente.setSetting(numb);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_NUMBER_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseRadioStatica(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Radio Statici");
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseRadio radio = new GooseRadio();
		radio.setDisabled(false);
		radio.setReadonly(false);
		List<GooseKeyValue> valori = new ArrayList<>();
		valori.add(new GooseKeyValue("unoStatico", "Uno Statico"));
		valori.add(new GooseKeyValue("dueStatico", "Due Statico"));
		valori.add(new GooseKeyValue("treStatico", "Tre Statico"));
		valori.add(new GooseKeyValue("quattroStatico", "Quattro Statico"));
		valori.add(new GooseKeyValue("cinqueStatico", "Cinque Statico"));
		radio.setValues(valori);
		componente.setSetting(radio);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_RADIO.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseRadioDinamica(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Radio Dinamici");
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseRadio radio = new GooseRadio();
		radio.setDisabled(false);
		radio.setReadonly(false);
		GooseHttpRequest http = new GooseHttpRequest();
		http.setUrl("http://localhost:8080/gooseform/opzioni");
		List<GooseKeyValue> listaHeader = new ArrayList<>();
		listaHeader.add(new GooseKeyValue("HEADER_1", "VALORE CUSTOM HEADER"));
		http.setHeaders(listaHeader);
		http.setMethod("POST");
		http.setBody("CORPO DELLA CHIAMATA");
		radio.setDynamicValues(http);
		radio.setKeyName("key");
		radio.setValueName("value");

		componente.setSetting(radio);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_RADIO.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseCheckbox() {
		GooseComponent componente = new GooseComponent();
		componente.setId("gooseCheckbox");
		componente.setLabel("Esempio Checkbox");
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseCheckbox check = new GooseCheckbox();
		check.setDisabled(false);
		check.setReadonly(false);
		check.setName("gooseCheckbox");
		componente.setSetting(check);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_CHECKBOX.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseEmailField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Mail Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseEmailField text = new GooseEmailField();
		text.setAutofocus(false);
		text.setDisabled(false);
		text.setName(id);
		text.setPlaceholder("Inserisci un indirizzo email...");
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_EMAIL_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseDateField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Date Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseDateField text = new GooseDateField();
		text.setDisabled(false);
		text.setName(id);
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_DATE_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseDateTimeField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Date Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseDateTimeField text = new GooseDateTimeField();
		text.setDisabled(false);
		text.setName(id);
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_DATE_TIME_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseMounthField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Mounth Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseMounthField text = new GooseMounthField();
		text.setDisabled(false);
		text.setName(id);
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_MOUNTH_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseWeekField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Week Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseWeekField text = new GooseWeekField();
		text.setDisabled(false);
		text.setName(id);
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_WEEK_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseTimeField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Time Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseTimeField text = new GooseTimeField();
		text.setDisabled(false);
		text.setName(id);
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_TIME_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseTelField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Tel Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseTelField text = new GooseTelField();
		text.setAutofocus(false);
		text.setDisabled(false);
		text.setName(id);
		text.setPlaceholder("Inserisci un numero di telefono...");
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_TEL_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseUrlField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Url Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseUrlField text = new GooseUrlField();
		text.setAutofocus(false);
		text.setDisabled(false);
		text.setName(id);
		text.setPlaceholder("Inserisci un indirizzo url...");
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_URL_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseColorField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Color Field");
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseColorField text = new GooseColorField();
		text.setDisabled(false);
		text.setName(id);
		text.setReadonly(false);
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_COLOR_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseRangeField(String id) {
		GooseComponent componente = new GooseComponent();
		componente.setId(id);
		componente.setLabel("Esempio Range Field - "+id);
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseRangeField text = new GooseRangeField();
		text.setDisabled(false);
		text.setName(id);
		text.setReadonly(false);
		text.setMin("-20");
		text.setMax("20");
		text.setStep("2");
		componente.setSetting(text);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_RANGE_FIELD.getValue());
		componente.setWidthXl("12");
		componente.setWidthLg("12");
		componente.setWidthMd("12");
		componente.setWidthSm("12");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

}
