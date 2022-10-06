package it.riccardoriggi.gooseform.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseSelect {

	private Long size;
    private List<GooseKeyValue> values;
    private GooseHttpRequest dynamicValues;
    private String keyName;
    private String valueName;

}
