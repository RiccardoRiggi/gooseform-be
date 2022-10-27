package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseButtonDb {

	private int pk;
	private String formId;
	private String type;
	private String title;
	private String icon;

}
