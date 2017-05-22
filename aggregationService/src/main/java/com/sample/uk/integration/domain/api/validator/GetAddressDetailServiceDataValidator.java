package com.sample.uk.integration.domain.api.validator;

import org.apache.camel.Exchange;
import org.springframework.util.StringUtils;

import com.sample.uk.integration.domain.api.dataModel.AddressDetail;
import com.sample.uk.integration.domain.api.errorHandler.ProblemDetailException;

public class GetAddressDetailServiceDataValidator {

	public void validateData(Exchange exchange) throws ProblemDetailException {
		AddressDetail data = exchange.getIn().getBody(AddressDetail.class);
		validate(data);
	}

	public void validate(AddressDetail data) throws ProblemDetailException {

		if (StringUtils.isEmpty(data.getEmpId())) {
			throw new ProblemDetailException("Invalid Input");
		}

	}

}
