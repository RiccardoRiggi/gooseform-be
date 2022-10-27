package it.riccardoriggi.gooseform.utils;

import it.riccardoriggi.gooseform.entity.GooseForm;
import it.riccardoriggi.gooseform.entity.db.GooseFormDb;

public class GooseConversionUtil {

	public static GooseFormDb toGooseFormDb(GooseForm form) {
		GooseFormDb db = new GooseFormDb();
		db.setDescription(form.getDescription());
		db.setFormId(form.getFormId());
		db.setIcon(form.getIcon());
		db.setTitle(form.getTitle());
		return db;
	}

	public static GooseForm toGooseForm(GooseFormDb form) {
		GooseForm db = new GooseForm();
		db.setDescription(form.getDescription());
		db.setFormId(form.getFormId());
		db.setIcon(form.getIcon());
		db.setTitle(form.getTitle());
		return db;
	}

}
