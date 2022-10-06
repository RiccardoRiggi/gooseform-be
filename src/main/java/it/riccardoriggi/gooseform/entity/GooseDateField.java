package it.riccardoriggi.gooseform.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseDateField {

	private String name;
    private boolean disabled;
    private boolean readonly;

}
