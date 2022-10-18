package it.riccardoriggi.gooseform.enums;

public enum GooseComplexControlEnum {

		EQUAL("EQUAL"),
	    NOT_EQUAL("NOT_EQUAL"),
	    MIN("MIN"),
	    MAX("MAX");

	private final String text;

	GooseComplexControlEnum(final String text) {
		this.text = text;
	}


	public String getValue() {
		return text;
	}

}
