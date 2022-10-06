package it.riccardoriggi.gooseform.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseForm {

	private String formId;
	private String title;
	private String icon;
	private GooseButton sendButton = new GooseButton();
	private GooseButton resetButton = new GooseButton();
	private String description;
	private GoosePopup popup = new GoosePopup();
	private boolean autocomplete = true;
	private GooseHttpRequest destinationUrl;
	private GooseHttpRequest originUrl;
	private List<GooseComponent> components= new ArrayList<>();
	private List<GooseControl> controls = new ArrayList<>();

}
