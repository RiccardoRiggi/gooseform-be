package it.riccardoriggi.gooseform.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GooseProblem {

	private int status;
	private String dettaglio;
}
