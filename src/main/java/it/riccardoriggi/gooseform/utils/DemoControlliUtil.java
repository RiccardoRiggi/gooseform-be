package it.riccardoriggi.gooseform.utils;

import java.util.List;

import it.riccardoriggi.gooseform.entity.GooseComplexControl;
import it.riccardoriggi.gooseform.entity.GooseControl;
import it.riccardoriggi.gooseform.entity.GooseStandardControl;
import it.riccardoriggi.gooseform.enums.GooseComplexControlEnum;
import it.riccardoriggi.gooseform.enums.GooseControlEnum;
import it.riccardoriggi.gooseform.enums.GooseStandardControlEnum;

public class DemoControlliUtil {

	public static GooseControl getStandardRequired(String idA) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setType(GooseStandardControlEnum.REQUIRED.getValue());
		control.setErrorMessage("Il campo " + idA + " è richiesto");
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getStandardEqual(String idA, String value) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setReferenceValue(value);
		control.setType(GooseStandardControlEnum.EQUAL.getValue());
		control.setErrorMessage("Il campo " + idA + " deve essere uguale a "+value);
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getStandardNotEqual(String idA, String value) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setReferenceValue(value);
		control.setType(GooseStandardControlEnum.NOT_EQUAL.getValue());
		control.setErrorMessage("Il campo " + idA + " non deve essere uguale a "+value);
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getStandardPattern(String idA) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setReferenceValue("[abc]");
		control.setType(GooseStandardControlEnum.PATTERN.getValue());
		control.setErrorMessage("Il campo " + idA + " deve contenere almeno a, b o c");
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getStandardIn(String idA, List<String> lista) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setReferenceValues(lista);
		control.setType(GooseStandardControlEnum.IN.getValue());
		control.setErrorMessage("Il campo " + idA + " deve essere uguale ad " + lista.toString());
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getStandardNotIn(String idA, List<String> lista) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setReferenceValues(lista);
		control.setType(GooseStandardControlEnum.NOT_IN.getValue());
		control.setErrorMessage("Il campo " + idA + " non deve essere uguale ad " + lista.toString());
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getStandardMinText(String idA, String minText) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setReferenceValue(minText);
		control.setType(GooseStandardControlEnum.MIN_TEXT.getValue());
		control.setErrorMessage("Il campo " + idA + " deve essere lungo almeno "+minText+" caratteri");
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getStandardMaxText(String idA, String maxText) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setReferenceValue(maxText);
		control.setType(GooseStandardControlEnum.MAX_TEXT.getValue());
		control.setErrorMessage("Il campo " + idA + " deve essere lungo al massimo "+maxText+" caratteri");
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getStandardMin(String idA, String min) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setReferenceValue(min);
		control.setType(GooseStandardControlEnum.MIN.getValue());
		control.setErrorMessage("Il campo " + idA + " deve essere maggiore o uguale a " + control.getReferenceValue());
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getStandardMax(String idA, String max) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.STANDARD.getValue());
		GooseStandardControl control = new GooseStandardControl();
		control.setIdComponentA(idA);
		control.setReferenceValue(max);
		control.setType(GooseStandardControlEnum.MAX.getValue());
		control.setErrorMessage("Il campo " + idA + " deve essere minore o uguale a " + control.getReferenceValue());
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getComplexEqual(String idA, String idB) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.COMPLEX.getValue());
		GooseComplexControl control = new GooseComplexControl();
		control.setIdComponentA(idA);
		control.setIdComponentB(idB);
		control.setType(GooseComplexControlEnum.EQUAL.getValue());
		control.setErrorMessage("Il campo " + idA + " deve essere uguale al campo " + idB);
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getComplexNotEqual(String idA, String idB) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.COMPLEX.getValue());
		GooseComplexControl control = new GooseComplexControl();
		control.setIdComponentA(idA);
		control.setIdComponentB(idB);
		control.setType(GooseComplexControlEnum.NOT_EQUAL.getValue());
		control.setErrorMessage("Il campo " + idA + " non deve essere uguale al campo " + idB);
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getComplexMin(String idA, String idB) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.COMPLEX.getValue());
		GooseComplexControl control = new GooseComplexControl();
		control.setIdComponentA(idA);
		control.setIdComponentB(idB);
		control.setType(GooseComplexControlEnum.MIN.getValue());
		control.setErrorMessage("Il campo "+idA+" deve essere maggiore del campo "+idB);
		tmp.setDetail(control);
		return tmp;
	}

	public static GooseControl getComplexMax(String idA, String idB) {
		GooseControl tmp = new GooseControl();
		tmp.setType(GooseControlEnum.COMPLEX.getValue());
		GooseComplexControl control = new GooseComplexControl();
		control.setIdComponentA(idA);
		control.setIdComponentB(idB);
		control.setType(GooseComplexControlEnum.MIN.getValue());
		control.setErrorMessage("Il campo "+idA+" deve essere minore del campo "+idB);
		tmp.setDetail(control);
		return tmp;
	}

}
