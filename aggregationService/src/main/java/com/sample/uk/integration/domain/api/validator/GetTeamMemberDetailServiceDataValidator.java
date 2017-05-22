package com.sample.uk.integration.domain.api.validator;

import org.apache.camel.Exchange;
import org.apache.cxf.common.util.StringUtils;

import com.sample.uk.integration.domain.api.dataModel.TeamMemberDetail;
import com.sample.uk.integration.domain.api.errorHandler.ProblemDetailException;

public class GetTeamMemberDetailServiceDataValidator {
	public void validateData(Exchange exchange) throws ProblemDetailException {
		TeamMemberDetail data = exchange.getIn().getBody(TeamMemberDetail.class);
		validate(data);
	}

	private void validate(TeamMemberDetail data) throws ProblemDetailException {

		if (StringUtils.isEmpty(data.getEmpId())) {
			throw new ProblemDetailException("Invalid Input");
		}

	}
}
