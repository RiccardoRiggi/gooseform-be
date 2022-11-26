package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseTooltipDb {

	private int pk;
	private String formId;
	private String componentId;
	private String icon;
	private String tooltip;

}
