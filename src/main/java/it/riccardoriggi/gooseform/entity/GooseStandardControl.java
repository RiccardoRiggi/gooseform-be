package it.riccardoriggi.gooseform.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseStandardControl {

	private String idComponentA;
    private String type;
    private String referenceValue;
    private List<String> referenceValues;
    private String errorMessage;

}
