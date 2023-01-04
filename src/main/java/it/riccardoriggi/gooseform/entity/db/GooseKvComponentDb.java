package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GooseKvComponentDb {

	private String formId;
	private String componentId;
	private String k;
	private String v;
	private int ordination;

}
