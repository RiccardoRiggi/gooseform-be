package it.riccardoriggi.gooseform.enums;

public enum GooseComplexRenderConditionalEnum {

	HIDE_C_IF_A_EQUAL_B("HIDE_B_IF_A_EQUAL_X"), DISABLED_C_IF_A_EQUAL_B("DISABLED_B_IF_A_EQUAL_X");

	private final String text;

	GooseComplexRenderConditionalEnum(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

}
