package it.riccardoriggi.gooseform.enums;

public enum GooseControlEnum {


	STANDARD("STANDARD"),COMPLEX("COMPLEX");

	private final String text;

	GooseControlEnum(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

}
