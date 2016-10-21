package com.lakeel.altla.ridill;

/**
 * The exception that is thrown when a null reference is passed to a method that
 * does not accept it as a valid argument.
 */
public class ArgumentNullException extends IllegalArgumentException {

    /**
     * Initializes a new instance with the name of the parameter that causes this exception.
     *
     * @param paramName The name of the parameter.
     */
    public ArgumentNullException(String paramName) {
        super(paramName);
    }
}
