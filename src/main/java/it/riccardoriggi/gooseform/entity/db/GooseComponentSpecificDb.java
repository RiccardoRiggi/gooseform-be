package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GooseComponentSpecificDb {

	private String formId;
	private String id;
	private String nomeAttributo;
	private String valoreAttributo;

}
