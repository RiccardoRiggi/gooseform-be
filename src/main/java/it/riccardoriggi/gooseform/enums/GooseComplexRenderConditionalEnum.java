package it.riccardoriggi.gooseform.enums;

public enum GooseComplexRenderConditionalEnum {

	HIDE_C_IF_A_EQUAL_B("HIDE_C_IF_A_EQUAL_B"), DISABLE_C_IF_A_EQUAL_B("DISABLE_C_IF_A_EQUAL_B"),
	HIDE_C_IF_A__NOT_EQUAL_B("HIDE_C_IF_A__NOT_EQUAL_B"), DISABLE_C_IF_A_NOT_EQUAL_B("DISABLE_C_IF_A_NOT_EQUAL_B"),
	HIDE_C_IF_A_MIN_B("HIDE_C_IF_A_MIN_B"), DISABLE_C_IF_A_MIN_B("DISABLE_C_IF_A_MIN_B"),
	HIDE_C_IF_A_MAX_B("HIDE_C_IF_A_MAX_B"), DISABLE_C_IF_A_MAX_B("DISABLE_C_IF_A_MAX_B"),;

	private final String text;

	GooseComplexRenderConditionalEnum(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

}
