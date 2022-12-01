package it.riccardoriggi.gooseform.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GooseTextField {

	private String name;
    private String placeholder;
    private boolean disabled;
    private boolean readonly;
    private boolean autofocus;

}
