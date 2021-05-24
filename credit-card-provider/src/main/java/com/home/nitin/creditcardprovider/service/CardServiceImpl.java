package com.home.nitin.creditcardprovider.service;

import com.home.nitin.creditcardprovider.entity.CreditCard;
import com.home.nitin.creditcardprovider.exception.CardExistsException;
import com.home.nitin.creditcardprovider.repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService<CreditCard> {

    @Autowired
    CreditCardRepo creditCardRepo;

    @Override
    public void addCard(CreditCard creditCard) throws CardExistsException {
        CreditCard existingCard = creditCardRepo.findByCardNumber( creditCard.getCardNumber() );
        if (existingCard == null) {
            creditCardRepo.save( creditCard);
        } else {
            throw new CardExistsException();
        }
    }

    @Override
    public List<CreditCard> getCardDetails() {
        return creditCardRepo.findAll();
    }
}
