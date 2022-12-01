package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GooseTooltipDb {

	private int pk;
	private String formId;
	private String componentId;
	private String icon;
	private String tooltip;

}
