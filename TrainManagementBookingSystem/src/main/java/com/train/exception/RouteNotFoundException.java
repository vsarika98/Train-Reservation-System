package com.train.exception;

public class RouteNotFoundException extends RuntimeException{
	public  RouteNotFoundException(String msg) {
		super(msg);
	}
}
