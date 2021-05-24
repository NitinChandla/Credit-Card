package com.home.nitin.creditcardprovider.service;

import com.home.nitin.creditcardprovider.exception.CardExistsException;

import java.util.List;

public interface CardService<E> {

    void addCard(E e) throws CardExistsException;
    List<E> getCardDetails();

}
