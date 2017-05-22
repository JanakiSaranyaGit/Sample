package com.sample.uk.integration.domain.api.validator;

import org.apache.camel.Exchange;
import org.apache.cxf.common.util.StringUtils;

import com.sample.uk.integration.domain.api.dataModel.PersonDetail;
import com.sample.uk.integration.domain.api.errorHandler.ProblemDetailException;

public class GetPersonDetailServiceDataDataValidator {

	public void validateData(Exchange exchange) throws ProblemDetailException {
		PersonDetail data = exchange.getIn().getBody(PersonDetail.class);
		validate(data);
	}

	public void validate(PersonDetail data) throws ProblemDetailException {

		if (StringUtils.isEmpty(data.getEmpId())) {
			throw new ProblemDetailException("Invalid Input");
		}

	}

}
