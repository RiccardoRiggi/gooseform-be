package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseRenderDb {

	private int pk;
	private String type;
	private String typeSpecific;
	private String idComponentA;
	private String idComponentB;
	private String idComponentC;
    private String value;

}
