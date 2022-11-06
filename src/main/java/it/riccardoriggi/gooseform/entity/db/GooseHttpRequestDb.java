package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseHttpRequestDb {

	private int pk;
	private String formId;
	private String componentId;
	private String url;
	private String method;
	private String body;
	private String typeSpecific;



}
