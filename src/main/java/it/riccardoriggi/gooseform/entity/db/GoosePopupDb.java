package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GoosePopupDb {

	private int pk;
	private String formId;
	private String componentId;
	private String icon;
	private String textTooltip;
	private String title;
	private String description;

}
