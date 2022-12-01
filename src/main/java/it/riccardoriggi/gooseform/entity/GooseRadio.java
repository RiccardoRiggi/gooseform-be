package it.riccardoriggi.gooseform.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GooseRadio {

	private String name;
    private boolean disabled;
    private boolean readonly;
    private List<GooseKeyValue> values;
    private GooseHttpRequest dynamicValues;
    private String keyName;
    private String valueName;

}
