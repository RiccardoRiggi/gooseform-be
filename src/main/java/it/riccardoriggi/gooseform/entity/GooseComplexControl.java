package it.riccardoriggi.gooseform.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseComplexControl {

	private String idComponentA;
	private String idComponentB;
	private String type;
	private String errorMessage;

}
