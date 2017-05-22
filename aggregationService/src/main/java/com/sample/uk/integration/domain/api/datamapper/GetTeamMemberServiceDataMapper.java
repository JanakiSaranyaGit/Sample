package com.sample.uk.integration.domain.api.datamapper;

import java.util.Map;

import org.apache.camel.Exchange;
import org.springframework.beans.BeanUtils;

import com.sample.uk.integration.domain.api.dataModel.TeamMemberDetail;

import getteammemberdetail.GetTeamMemberDetailRequest;
import getteammemberdetail.GetTeamMemberDetailResponse;

public class GetTeamMemberServiceDataMapper {
	public void frameInput(Exchange exchange) {
		TeamMemberDetail detail = new TeamMemberDetail();
		GetTeamMemberDetailRequest request = exchange.getIn().getBody(GetTeamMemberDetailRequest.class);
		BeanUtils.copyProperties(request, detail);
		exchange.getIn().setBody(detail, TeamMemberDetail.class);
		
		exchange.getIn().setHeader("empId", detail.getEmpId());
		Map<String,Object> headers=exchange.getIn().getHeaders();
		exchange.getIn().getHeaders().clear();
		
	}

	public void frameOutput(Exchange exchange) {
		GetTeamMemberDetailResponse response = new GetTeamMemberDetailResponse();
		TeamMemberDetail detail = exchange.getIn().getBody(TeamMemberDetail.class);
		BeanUtils.copyProperties(detail, response);

		exchange.getIn().setBody(response, GetTeamMemberDetailResponse.class);
	}
}
