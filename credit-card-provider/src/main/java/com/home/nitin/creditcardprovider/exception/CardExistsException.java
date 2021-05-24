package com.home.nitin.creditcardprovider.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Failed to add card, card number already exists")
public class CardExistsException extends RuntimeException {
}
