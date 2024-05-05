package com.sd.exceptions;


/**
 * Runtime Exception occurs when the key or value fetched from the property file is null
 * @author Ankit Yadav
 * April 01, 2024
 * @version 1.0
 * @since 1.0
 * @see com.rtf.constants.FrameworkConstants
 * @see com.rtf.utils.PropertyUtils
 */
@SuppressWarnings("serial")
public class PropertyFileUsageException extends FrameworkException{
	
	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public PropertyFileUsageException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public PropertyFileUsageException(String message,Throwable cause) {
		super(message,cause);
	}

}
