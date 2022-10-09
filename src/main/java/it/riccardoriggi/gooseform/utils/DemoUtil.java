package it.riccardoriggi.gooseform.utils;

import java.util.ArrayList;
import java.util.List;

import it.riccardoriggi.gooseform.entity.GooseButton;
import it.riccardoriggi.gooseform.entity.GooseComponent;
import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.entity.GooseHttpRequest;
import it.riccardoriggi.gooseform.entity.GooseKeyValue;
import it.riccardoriggi.gooseform.entity.GoosePopup;
import it.riccardoriggi.gooseform.entity.GooseSelect;
import it.riccardoriggi.gooseform.entity.GooseTextArea;
import it.riccardoriggi.gooseform.entity.GooseTooltip;
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
		form.setResetButton(generaGooseButton());
		form.setSendButton(generaGooseButton());
		form.setTitle("Titolo del form");
		return form;
	}

	private static GooseButton generaGooseButton() {
		GooseButton button = new GooseButton();
		button.setIcon("fas fa-feather-alt");
		button.setTitle("Titolo pulsante");
		return button;
	}

	private static GooseHttpRequest generaUrlDestinazione() {
		GooseHttpRequest req = new GooseHttpRequest();
		List<GooseKeyValue> listaHeaders = new ArrayList<>();
		listaHeaders.add(new GooseKeyValue("chiave","valore"));
		req.setHeaders(listaHeaders);
		req.setMethod("POST");
		req.setUrl("URL_DESTINAZIONE");
		return req;
	}

	private static GooseHttpRequest generaUrlOrigine() {
		GooseHttpRequest req = new GooseHttpRequest();
		List<GooseKeyValue> listaHeaders = new ArrayList<>();
		listaHeaders.add(new GooseKeyValue("chiave","valore"));
		req.setHeaders(listaHeaders);
		req.setMethod("POST");
		req.setUrl("URL_DOVE_VENGONO_LETTI_I_DATI");
		return req;
	}

	public static GooseComponent generaGooseTextArea() {
		GooseComponent componente = new GooseComponent();
		componente.setId("gooseTextArea");
		componente.setLabel("Esempio Text Area");
		componente.setPopup(generaGoosePopup());
		componente.setFormId("idForm");
		GooseTextArea textArea = new GooseTextArea();
		textArea.setRows(3L);
		componente.setSetting(textArea);
		componente.setTooltip(generaGooseTooltip());
		componente.setType(GooseComponentEnum.GOOSE_TEXT_AREA.getValue());
		componente.setWidthXl("6");
		componente.setWidthLg("3");
		componente.setWidthMd("4");
		componente.setWidthSm("6");
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

	public static GooseComponent generaGooseSelectStatica() {
		GooseComponent componente = new GooseComponent();
		componente.setId("gooseSelectStatica");
		componente.setLabel("Esempio Select Statica");
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
		componente.setWidthXl("6");
		componente.setWidthLg("3");
		componente.setWidthMd("4");
		componente.setWidthSm("6");
		componente.setWidth("12");
		componente.setRequiredMark(true);
		return componente;
	}

	public static GooseComponent generaGooseSelectDinamica() {
		GooseComponent componente = new GooseComponent();
		componente.setId("gooseSelectDinamica");
		componente.setLabel("Esempio Select Dinamica");
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

	public static GooseComponent generaGooseSelectDinamicaDue() {
		GooseComponent componente = new GooseComponent();
		componente.setId("gooseSelectDinamica");
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

}
