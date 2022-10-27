package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseKvHttpRequestDb {

	private int pk;
	private String k;
	private String v;

}
