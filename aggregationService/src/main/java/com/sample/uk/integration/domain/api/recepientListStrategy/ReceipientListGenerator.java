package com.sample.uk.integration.domain.api.recepientListStrategy;

import org.apache.camel.Exchange;

public class ReceipientListGenerator {

	public void generateReceipientList(Exchange exchange) {
		String[] receipentHeader = new String[] { "direct-vm:employeeDetail?synchronous=true", "direct-vm:personDetail?synchronous=true",
				"direct-vm:addressDetail?synchronous=true" };

		exchange.getIn().setHeader("recipients", receipentHeader);
	}
}
