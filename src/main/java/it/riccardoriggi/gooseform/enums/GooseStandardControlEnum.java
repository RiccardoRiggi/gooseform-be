package it.riccardoriggi.gooseform.enums;

public enum GooseStandardControlEnum {

	/*
	 *  REQUIRED
	 *  EQUAL
	 *  NOT_EQUAL
	 *  PATTERN
	 *
	 * */

	REQUIRED("REQUIRED"), EQUAL("EQUAL"), NOT_EQUAL("NOT_EQUAL"), PATTERN("PATTERN"), IN("IN"), NOT_IN("NOT_IN"),
	IS_MAIL("IS_MAIL"), MIN_TEXT("MIN_TEXT"), MAX_TEXT("MAX_TEXT"), MIN_NUM("MIN_NUM"), MAX_NUM("MAX_NUM"),
	EQUAL_NUM("EQUAL_NUM");

	private final String text;

	GooseStandardControlEnum(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

}
