package com.sample.uk.integration.domain.api.aggregationStrategy;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.beans.BeanUtils;

import com.sample.uk.integration.domain.api.dataModel.AddressDetail;
import com.sample.uk.integration.domain.api.dataModel.EmployeeDetail;
import com.sample.uk.integration.domain.api.dataModel.PersonDetail;
import com.sample.uk.integration.domain.api.dataModel.TeamMemberDetail;

public class AggregationStrategyGenerator implements AggregationStrategy {

	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

		// append the new word to the existing
		return myAggregate(oldExchange, newExchange);

	}

	public synchronized Exchange myAggregate(Exchange oldExchange, Exchange newExchange) {
		TeamMemberDetail teamMemberDetail;
		if (oldExchange == null) {
			oldExchange = newExchange;

		}
		teamMemberDetail = oldExchange.getIn().getBody(TeamMemberDetail.class);
		if (teamMemberDetail == null) {
			teamMemberDetail = new TeamMemberDetail();
		}
		String uri = newExchange.getProperty(Exchange.RECIPIENT_LIST_ENDPOINT, String.class);

		if (uri.equalsIgnoreCase("direct-vm://employeeDetail?synchronous=true")) {
			EmployeeDetail detail = newExchange.getIn().getBody(EmployeeDetail.class);
			teamMemberDetail.setEmpName(detail.getEmpName());
			teamMemberDetail.setDepartment(detail.getDepartment());

		} else if (uri.equalsIgnoreCase("direct-vm://personDetail?synchronous=true")) {
			PersonDetail detail = newExchange.getIn().getBody(PersonDetail.class);
			teamMemberDetail.setNino(detail.getNino());
			teamMemberDetail.setSurname(detail.getSurname());
			teamMemberDetail.setDob(detail.getDob());

		} else if (uri.equalsIgnoreCase("direct-vm://addressDetail?synchronous=true")) {
			AddressDetail detail = newExchange.getIn().getBody(AddressDetail.class);
			teamMemberDetail.setAddress(detail.getAddress());
			teamMemberDetail.setContactNumber(detail.getContactNumber());
			teamMemberDetail.setEmailAddress(detail.getEmailAddress());

		}
		oldExchange.getIn().setBody(teamMemberDetail, TeamMemberDetail.class);
		return oldExchange;

	}
}
