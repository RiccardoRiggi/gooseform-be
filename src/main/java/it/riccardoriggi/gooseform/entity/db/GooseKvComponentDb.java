package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseKvComponentDb {

	private String formId;
	private String componentId;
	private String k;
	private String v;

}
