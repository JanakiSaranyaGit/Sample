package com.sample.uk.integration.domain.api.datamapper;

import org.apache.camel.Exchange;
import org.springframework.beans.BeanUtils;

import com.sample.uk.integration.domain.api.dataModel.PersonDetail;

import getpersondetail.GetPersonDetailRequest;
import getpersondetail.GetPersonDetailResponse;

public class GetPersonDetailServiceDataMapper {
	public void frameInput(Exchange exchange) {
		GetPersonDetailRequest request = new GetPersonDetailRequest();
		String empId = exchange.getIn().getHeader("empId", String.class);
		PersonDetail detail = new PersonDetail();
		detail.setEmpId(empId);
		BeanUtils.copyProperties(detail, request);
		exchange.getIn().setBody(request, GetPersonDetailRequest.class);
	}

	public void frameOutput(Exchange exchange) {
		PersonDetail detail = new PersonDetail();
		
		/*detail.setNino("1234");*/
		GetPersonDetailResponse response = exchange.getIn().getBody(GetPersonDetailResponse.class);
		BeanUtils.copyProperties(response, detail);
		detail.setEmpId("342826");
		exchange.getIn().setBody(detail, PersonDetail.class);
	}

}
