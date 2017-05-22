package com.sample.uk.integration.domain.api.interceptors;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.StaxInInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class MySoapActionInInterceptor extends  AbstractPhaseInterceptor<Message>{
	
	@Override
	public void handleMessage(Message message) throws Fault {
		 
		 System.out.println(message.toString());
	        

}


	
	  public MySoapActionInInterceptor() {
	        super(Phase.PRE_STREAM);
	        addBefore(StaxInInterceptor.class.getName());
	    }
	    public MySoapActionInInterceptor(String phase) {
	        super(phase);
	    }
}
