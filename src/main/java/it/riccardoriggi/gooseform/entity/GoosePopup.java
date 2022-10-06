package it.riccardoriggi.gooseform.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GoosePopup {

	private String icon;
    private String textTooltip;
    private String title;
    private String description;

}
