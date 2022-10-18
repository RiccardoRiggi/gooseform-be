package it.riccardoriggi.gooseform.enums;

public enum GooseStandardControlEnum {

	/*
	 *  REQUIRED
	 *  EQUAL
	 *  NOT_EQUAL
	 *  PATTERN
	 *  IN
	 *  NOT_IN
	 *  MIN_TEXT
	 *	MAX_TEXT
	 *	MIN
	 * 	MAX
	 * */

	REQUIRED("REQUIRED"), EQUAL("EQUAL"), NOT_EQUAL("NOT_EQUAL"), PATTERN("PATTERN"), IN("IN"), NOT_IN("NOT_IN"),
	MIN_TEXT("MIN_TEXT"), MAX_TEXT("MAX_TEXT"), MIN("MIN"), MAX("MAX");

	private final String text;

	GooseStandardControlEnum(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

}
