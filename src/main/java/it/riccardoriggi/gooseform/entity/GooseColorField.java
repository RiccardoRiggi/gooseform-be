package it.riccardoriggi.gooseform.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseColorField {

	private String name;
    private boolean disabled;
    private boolean readonly;

}
