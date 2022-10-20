package it.riccardoriggi.gooseform.utils;

import it.riccardoriggi.gooseform.entity.GooseRender;
import it.riccardoriggi.gooseform.entity.GooseSimpleRenderConditional;
import it.riccardoriggi.gooseform.enums.GooseRenderEnum;
import it.riccardoriggi.gooseform.enums.GooseSimpleRenderConditionalEnum;

public class DemoRenderUtil {

	public static GooseRender getHIDE_B_IF_A_EQUAL_X(String idA, String idB, String value) {
		GooseRender tmp = new GooseRender();
		GooseSimpleRenderConditional render = new GooseSimpleRenderConditional();
		render.setIdComponentA(idA);
		render.setIdComponentB(idB);
		render.setType(GooseSimpleRenderConditionalEnum.HIDE_B_IF_A_EQUAL_X.getValue());
		render.setValue(value);
		tmp.setDetail(render);
		tmp.setType(GooseRenderEnum.SIMPLE_RENDER.getValue());
		return tmp;
	}

	public static GooseRender getDISABLE_B_IF_A_EQUAL_X(String idA, String idB, String value) {
		GooseRender tmp = new GooseRender();
		GooseSimpleRenderConditional render = new GooseSimpleRenderConditional();
		render.setIdComponentA(idA);
		render.setIdComponentB(idB);
		render.setType(GooseSimpleRenderConditionalEnum.DISABLE_B_IF_A_EQUAL_X.getValue());
		render.setValue(value);
		tmp.setDetail(render);
		tmp.setType(GooseRenderEnum.SIMPLE_RENDER.getValue());
		return tmp;
	}

	public static GooseRender getHIDE_B_IF_A_NOT_EQUAL_X(String idA, String idB, String value) {
		GooseRender tmp = new GooseRender();
		GooseSimpleRenderConditional render = new GooseSimpleRenderConditional();
		render.setIdComponentA(idA);
		render.setIdComponentB(idB);
		render.setType(GooseSimpleRenderConditionalEnum.HIDE_B_IF_A_NOT_EQUAL_X.getValue());
		render.setValue(value);
		tmp.setDetail(render);
		tmp.setType(GooseRenderEnum.SIMPLE_RENDER.getValue());
		return tmp;
	}

	public static GooseRender getDISABLE_B_IF_A_NOT_EQUAL_X(String idA, String idB, String value) {
		GooseRender tmp = new GooseRender();
		GooseSimpleRenderConditional render = new GooseSimpleRenderConditional();
		render.setIdComponentA(idA);
		render.setIdComponentB(idB);
		render.setType(GooseSimpleRenderConditionalEnum.DISABLE_B_IF_A_NOT_EQUAL_X.getValue());
		render.setValue(value);
		tmp.setDetail(render);
		tmp.setType(GooseRenderEnum.SIMPLE_RENDER.getValue());
		return tmp;
	}

	public static GooseRender getHIDE_B_IF_A_MIN_X(String idA, String idB, String value) {
		GooseRender tmp = new GooseRender();
		GooseSimpleRenderConditional render = new GooseSimpleRenderConditional();
		render.setIdComponentA(idA);
		render.setIdComponentB(idB);
		render.setType(GooseSimpleRenderConditionalEnum.HIDE_B_IF_A_MIN_X.getValue());
		render.setValue(value);
		tmp.setDetail(render);
		tmp.setType(GooseRenderEnum.SIMPLE_RENDER.getValue());
		return tmp;
	}

	public static GooseRender getDISABLE_B_IF_A_MIN_X(String idA, String idB, String value) {
		GooseRender tmp = new GooseRender();
		GooseSimpleRenderConditional render = new GooseSimpleRenderConditional();
		render.setIdComponentA(idA);
		render.setIdComponentB(idB);
		render.setType(GooseSimpleRenderConditionalEnum.DISABLE_B_IF_A_MIN_X.getValue());
		render.setValue(value);
		tmp.setDetail(render);
		tmp.setType(GooseRenderEnum.SIMPLE_RENDER.getValue());
		return tmp;
	}

	public static GooseRender getHIDE_B_IF_A_MAX_X(String idA, String idB, String value) {
		GooseRender tmp = new GooseRender();
		GooseSimpleRenderConditional render = new GooseSimpleRenderConditional();
		render.setIdComponentA(idA);
		render.setIdComponentB(idB);
		render.setType(GooseSimpleRenderConditionalEnum.HIDE_B_IF_A_MAX_X.getValue());
		render.setValue(value);
		tmp.setDetail(render);
		tmp.setType(GooseRenderEnum.SIMPLE_RENDER.getValue());
		return tmp;
	}

	public static GooseRender getDISABLE_B_IF_A_MAX_X(String idA, String idB, String value) {
		GooseRender tmp = new GooseRender();
		GooseSimpleRenderConditional render = new GooseSimpleRenderConditional();
		render.setIdComponentA(idA);
		render.setIdComponentB(idB);
		render.setType(GooseSimpleRenderConditionalEnum.DISABLE_B_IF_A_MAX_X.getValue());
		render.setValue(value);
		tmp.setDetail(render);
		tmp.setType(GooseRenderEnum.SIMPLE_RENDER.getValue());
		return tmp;
	}

}
