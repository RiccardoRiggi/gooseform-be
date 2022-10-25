package it.riccardoriggi.gooseform.enums;

public enum GooseStandardControlEnum {

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
