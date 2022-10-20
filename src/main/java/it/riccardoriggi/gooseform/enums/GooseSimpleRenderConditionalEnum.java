package it.riccardoriggi.gooseform.enums;

public enum GooseSimpleRenderConditionalEnum {

	HIDE_B_IF_A_EQUAL_X("HIDE_B_IF_A_EQUAL_X"), DISABLE_B_IF_A_EQUAL_X("DISABLE_B_IF_A_EQUAL_X"),
	HIDE_B_IF_A_MIN_X("HIDE_B_IF_A_MIN_X"), DISABLE_B_IF_A_MIN_X("DISABLE_B_IF_A_MIN_X"),
	HIDE_B_IF_A_MAX_X("HIDE_B_IF_A_MAX_X"), DISABLE_B_IF_A_MAX_X("DISABLE_B_IF_A_MAX_X"),
	HIDE_B_IF_A_NOT_EQUAL_X("HIDE_B_IF_A_NOT_EQUAL_X"), DISABLE_B_IF_A_NOT_EQUAL_X("DISABLE_B_IF_A_NOT_EQUAL_X");

	private final String text;

	GooseSimpleRenderConditionalEnum(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

}
