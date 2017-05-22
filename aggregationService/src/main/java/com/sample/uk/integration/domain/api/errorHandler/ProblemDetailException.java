package com.sample.uk.integration.domain.api.errorHandler;

public class ProblemDetailException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProblemDetailException() {

	}

	public ProblemDetailException(String string) {

		super(string);
	}

}
