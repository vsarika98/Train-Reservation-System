package com.capgemini.ttrms.exception;

public class TicketNotFoundException extends RuntimeException{
	public  TicketNotFoundException(String msg) {
		super(msg);
	}
}
