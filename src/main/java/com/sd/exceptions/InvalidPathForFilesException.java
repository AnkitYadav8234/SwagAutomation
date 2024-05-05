package com.sd.exceptions;

/**
 * Runtime Exception occurs when the path given for any of the files is incorrect.
 * @author Ankit Yadav
 * April 01, 2024
 * @version 1.0
 * @since 1.0
 * @see com.rtf.exceptions.InvalidPathForExcelException
 * @see com.rtf.exceptions.InvalidPathForPropertyFileException
 */
@SuppressWarnings("serial")
public class InvalidPathForFilesException extends FrameworkException{

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public InvalidPathForFilesException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public InvalidPathForFilesException(String message,Throwable cause) {
		super(message,cause);
	}

}
