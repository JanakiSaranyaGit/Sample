package com.sample.uk.integration.domain.api.interceptors;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class MySoapActionOutInterceptor extends AbstractPhaseInterceptor<Message> {

	public MySoapActionOutInterceptor(String phase) {
		super(phase);
		// TODO Auto-generated constructor stub
	}

	  public MySoapActionOutInterceptor() {
	        super(Phase.SEND);
	      
	    }

	@Override
	public void handleMessage(Message message) throws Fault {/*
		// TODO Auto-generated method stub
		 Map<String, List> headers = (Map<String, List>) message.get(Message.PROTOCOL_HEADERS);
	        try {
	        	List list=headers.get("Accept");
	        	list.clear();
	        	list.add("text/xml; charset=utf-8");
	        	
	            headers.put("Accept", list);
	           
	        } catch (Exception ce) {
	            throw new Fault(ce);
	        }
	*/}
}
