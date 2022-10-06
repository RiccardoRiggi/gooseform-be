package it.riccardoriggi.gooseform.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseNumberField {

	private String name;
    private String placeholder;
    private boolean disabled;
    private boolean readonly;
    private boolean autofocus;
    private Long steps;

}
