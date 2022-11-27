package it.riccardoriggi.gooseform.exceptions;

import it.riccardoriggi.gooseform.entity.GooseProblem;

public class GooseFormException extends Exception{

	private static final long serialVersionUID = -75607011739532050L;

	private GooseProblem problem = new GooseProblem();

	public GooseFormException(int status, String dettaglio) {
		super(dettaglio);
		problem.setStatus(status);
		problem.setDettaglio(dettaglio);
	}

	public GooseProblem getProblem() {
		return problem;
	}
}
