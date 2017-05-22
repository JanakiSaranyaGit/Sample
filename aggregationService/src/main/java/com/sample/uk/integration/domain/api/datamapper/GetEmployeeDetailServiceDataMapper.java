package com.sample.uk.integration.domain.api.datamapper;

import org.apache.camel.Exchange;
import org.springframework.beans.BeanUtils;

import com.sample.uk.integration.domain.api.dataModel.EmployeeDetail;

import getemployeedetail.GetEmployeeDetailRequest;
import getemployeedetail.GetEmployeeDetailResponse;

public class GetEmployeeDetailServiceDataMapper {

	public void frameInput(Exchange exchange) {
		GetEmployeeDetailRequest request = new GetEmployeeDetailRequest();
		String empId = exchange.getIn().getHeader("empId", String.class);
		EmployeeDetail detail = new EmployeeDetail();
		detail.setEmpId(empId);
		BeanUtils.copyProperties(detail, request);
		exchange.getIn().setBody(request, GetEmployeeDetailRequest.class);
	}

	public void frameOutput(Exchange exchange) {
		EmployeeDetail detail = new EmployeeDetail();
		/*detail.setEmpId("342826");
		detail.setDepartment("integration");*/
		GetEmployeeDetailResponse response = exchange.getIn().getBody(GetEmployeeDetailResponse.class);
		BeanUtils.copyProperties(response, detail);
		exchange.getIn().setBody(detail, EmployeeDetail.class);
	}

}
