package com.sample.uk.integration.domain.api.validator;


import org.apache.camel.Exchange;
import org.apache.cxf.common.util.StringUtils;

import com.sample.uk.integration.domain.api.dataModel.EmployeeDetail;
import com.sample.uk.integration.domain.api.errorHandler.ProblemDetailException;
public class GetEmployeeDetailServiceDataValidator {

	public void validateData(Exchange exchange) throws ProblemDetailException {
		EmployeeDetail data = exchange.getIn().getBody( EmployeeDetail.class);
		validate(data);
	}

	public void validate( EmployeeDetail data) throws ProblemDetailException {

		if (StringUtils.isEmpty(data.getEmpId())) {
			throw new ProblemDetailException("Invalid Input");
		}

	}
}
