package it.riccardoriggi.gooseform.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseDataList {

	private String name;
	private String placeholder;
	private boolean disabled;
	private boolean readonly;
	private boolean autofocus;
	private List<GooseKeyValue> values;
	private GooseHttpRequest dynamicValues;
	private String keyName;
	private String valueName;

}
