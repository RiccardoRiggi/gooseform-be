package it.riccardoriggi.gooseform.entity.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GooseComponentDb {

	private String formId;
	private String id;
	private String type;
	private String label;
	private String widthXl;
    private String widthLg;
    private String widthMd;
    private String widthSm;
    private String width;
    private boolean requiredMark;

}
