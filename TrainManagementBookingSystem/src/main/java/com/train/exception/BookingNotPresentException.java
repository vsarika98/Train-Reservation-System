package com.train.exception;


public class BookingNotPresentException extends RuntimeException{
	public  BookingNotPresentException(String msg) {
		super(msg);
	}
}
