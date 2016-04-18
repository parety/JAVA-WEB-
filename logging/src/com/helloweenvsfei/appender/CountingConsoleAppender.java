package com.helloweenvsfei.appender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.spi.LoggingEvent;

public class CountingConsoleAppender extends AppenderSkeleton {

	int counter = 0;

	int limit = 16;

	public CountingConsoleAppender() {
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getLimit() {
		return limit;
	}

	public void append(LoggingEvent event) {
		if (this.layout == null) {
			// WRITING YOUR OWN APPENDER 111
			errorHandler.error("No layout set for the appender named [" + name
					+ "].", null, ErrorCode.MISSING_LAYOUT);
			return;
		}
		if (counter >= limit) {
			errorHandler.error("Counter limit[" + limit + "] reached in ["
					+ getName() + "] appender", null, ErrorCode.WRITE_FAILURE);
			return;
		}
		// output the events as formatted by our layout
		System.out.print(this.layout.format(event));
		// if our layout does not handle exceptions, we have to do it.
		if (layout.ignoresThrowable()) {
			String[] t = event.getThrowableStrRep();
			if (t != null) {
				int len = t.length;
				for (int i = 0; i < len; i++) {
					System.out.println(t[i]);
				}
			}
		}
		// prepare for next event
		counter++;
	}

	public void close() {
		if (this.closed) // closed is defined in AppenderSkeleton
			return;
		this.closed = true;
	}

	public boolean requiresLayout() {
		return true;
	}
}
