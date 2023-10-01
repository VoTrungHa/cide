package com.vtha.Exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException{
    /**
     * The generic class is to wrap exception for handling exception on SQM.
     */

    /**
     * Wrapper Exception.
     */
    private Throwable throwable;

    /**
     * The custom error code is wrapped by Spring status.
     */
    private ErrorCode errorCode;

    /**
     * Show friendly error message is response.
     */
    private String errorMessage;

    private final Boolean isMultipartException;

    /**
     * Constructor.
     *
     * @param errorCode : Error code instance.
     */
    public UserException(ErrorCode errorCode) {
        this(errorCode, errorCode.name(), null, false);
    }

    /**
     * Constructor.
     *
     * @param errorCode : Error code instance.
     * @param message   : Error message.
     */
    public UserException(ErrorCode errorCode, String message) {
        this(errorCode, message, null, false);
    }


    /**
     * Constructor.
     *
     * @param errorCode : Error code instance.
     * @param message   : Error message.
     * @param isMultipartException : indicate an Exception is thrown for a multipart request
     */
    public UserException(ErrorCode errorCode, String message,
                            Boolean isMultipartException) {
        this(errorCode, message, null, isMultipartException);
    }

    /**
     * Constructor.
     *
     * @param errorCode : Error code instance.
     * @param message   : Error message.
     * @param throwable : generic exception.
     */
    public UserException(ErrorCode errorCode, String message,
                            Throwable throwable) {
        this(errorCode, message, throwable, false);
    }

    /**
     * Constructor.
     *
     * @param errorCode : Error code instance.
     * @param message   : Error message.
     * @param throwable : generic exception.
     * @param isMultipartException : indicate an Exception is thrown for a multipart request
     */
    public UserException(ErrorCode errorCode, String message, Throwable throwable,
                            Boolean isMultipartException) {
        super(message, throwable);
        this.errorCode = errorCode;
        this.errorMessage = message;
        this.throwable = throwable;
        this.isMultipartException = isMultipartException;
    }

    /**
     * Error Code as wrapper Spring.HttpStatus.
     */
    public enum ErrorCode {
        NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND),
        USER_EXISTING(HttpStatus.BAD_REQUEST);

        private final HttpStatus status;

        /**
         * constructors defined error code on given status code.
         * @param status status response.
         */
        ErrorCode(HttpStatus status) {
            this.status = status;
        }

        public HttpStatus getStatus() {
            return status;
        }
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getMultipartException() {
        return isMultipartException;
    }
}
