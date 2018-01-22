/**
 * 
 */
package com.brainstrongtech.hrmis.exception;

/**
 * 
 * 无效UI类型异常
 * @author joeyang ong
 *
 */
public class UnsupportedUITypeException extends RuntimeException {

	/**
	 * 
	 */
	public UnsupportedUITypeException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public UnsupportedUITypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public UnsupportedUITypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnsupportedUITypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UnsupportedUITypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
