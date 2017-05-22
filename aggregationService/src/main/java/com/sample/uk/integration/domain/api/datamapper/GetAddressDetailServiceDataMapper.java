package com.sample.uk.integration.domain.api.datamapper;
import org.apache.camel.Exchange;
import org.springframework.beans.BeanUtils;

import com.sample.uk.integration.domain.api.dataModel.AddressDetail;
import com.sample.uk.integration.domain.api.dataModel.EmployeeDetail;

import getaddressdetail.GetAddressDetailRequest;
import getaddressdetail.GetAddressDetailResponse;
public class GetAddressDetailServiceDataMapper {

	
	
	public void frameInput(Exchange exchange) {
		GetAddressDetailRequest request = new GetAddressDetailRequest();
		String empId = exchange.getIn().getHeader("empId", String.class);
		
		AddressDetail detail = new AddressDetail();
		detail.setEmpId(empId);
		BeanUtils.copyProperties(detail, request);
		exchange.getIn().setBody(request, GetAddressDetailRequest.class);
	}

	public void frameOutput(Exchange exchange) {
		AddressDetail detail = new AddressDetail();
		/*detail.setEmpId("342826");
		detail.setAddress("abcd");*/
		GetAddressDetailResponse response = exchange.getIn().getBody(GetAddressDetailResponse.class);
		BeanUtils.copyProperties(response, detail);
		exchange.getIn().setBody(detail, AddressDetail.class);
	}

	
}
