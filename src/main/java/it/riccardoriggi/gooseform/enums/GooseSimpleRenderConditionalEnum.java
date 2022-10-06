package it.riccardoriggi.gooseform.enums;

public enum GooseSimpleRenderConditionalEnum {

	HIDE_B_IF_A_EQUAL_X("HIDE_B_IF_A_EQUAL_X"), DISABLED_B_IF_A_EQUAL_X("DISABLED_B_IF_A_EQUAL_X");

	private final String text;

	GooseSimpleRenderConditionalEnum(final String text) {
		this.text = text;
	}

	public String getValue() {
		return text;
	}

}
