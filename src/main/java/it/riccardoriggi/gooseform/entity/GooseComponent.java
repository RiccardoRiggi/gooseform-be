package it.riccardoriggi.gooseform.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class GooseComponent {

	private String formId;
    private String id;
    private String type;
    private String label;
    private String widthXl;
    private String widthLg;
    private String widthMd;
    private String widthSm;
    private String width;
    private Object setting; //DIPENDE DAL type
    private GooseTooltip tooltip;
    private GoosePopup popup;
    private boolean requiredMark;

}
