package com.home.nitin.creditcardprovider.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid card details")
public class InvalidCardNumberException extends RuntimeException {
}
