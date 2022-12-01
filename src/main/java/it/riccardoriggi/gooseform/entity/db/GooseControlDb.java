package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GooseControlDb {

	private int pk;
	private String formId;
	private String type;
	private String typeSpecific;
	private String idComponentA;
	private String idComponentB;
    private String referenceValue;
    private String errorMessage;

}
