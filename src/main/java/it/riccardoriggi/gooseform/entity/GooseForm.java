package it.riccardoriggi.gooseform.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GooseForm {

	private String formId;
	private String title;
	private String icon;
	private GooseButton sendButton;
	private GooseButton resetButton;
	private String description;
	private GoosePopup popup;
	private boolean autocomplete = true;
	private GooseHttpRequest destinationUrl;
	private GooseHttpRequest originUrl;
	private List<GooseComponent> components= new ArrayList<>();
	private List<GooseControl> controls = new ArrayList<>();
	private List<GooseRender> renders = new ArrayList<>();

}
