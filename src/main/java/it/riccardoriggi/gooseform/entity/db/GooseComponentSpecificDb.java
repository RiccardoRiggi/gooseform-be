package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseComponentSpecificDb {

	private int pk;
	private String nomeAttributo;
	private String valoreAttributo;

}
