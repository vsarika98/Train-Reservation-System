package com.capgemini.ttrms.exception;

public class BookingNotPresentException extends RuntimeException{
	public  BookingNotPresentException(String msg) {
		super(msg);
	}
}
