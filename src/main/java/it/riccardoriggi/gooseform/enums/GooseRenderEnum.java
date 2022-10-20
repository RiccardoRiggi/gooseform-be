package it.riccardoriggi.gooseform.enums;

public enum GooseRenderEnum {


	SIMPLE_RENDER("SIMPLE_RENDER"),COMPLEX_RENDER("COMPLEX_RENDER");

	private final String text;

	GooseRenderEnum(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

}
