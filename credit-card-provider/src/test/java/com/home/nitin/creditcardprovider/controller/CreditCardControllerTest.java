package com.home.nitin.creditcardprovider.controller;

import com.home.nitin.creditcardprovider.entity.CreditCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreditCardControllerTest {

    @Autowired
    CreditCardController creditCardController;

    @Test
    public void testIsCardNumberCompatibleValidNumber(){
        String cardNumber = "19";
        Boolean actualValue = creditCardController.isCardNumberCompatible( cardNumber );
        assert actualValue.equals( true );

    }
    @Test
    public void testIsCardNumberCompatibleInvalidValue(){
        String cardNumber = "1";
        Boolean actualValue = creditCardController.isCardNumberCompatible( cardNumber );
        assert actualValue.equals( false );
    }

    @Test
    public void testIsCardNumberCompatibleNullValue(){
        String cardNumber = "";
        Boolean actualValue = creditCardController.isCardNumberCompatible( cardNumber );
        assert actualValue.equals( false );
    }


    @Test
    public void testisCreditCardNumberValidValidNumber(){
        String cardNumber = "19";
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber( cardNumber );
        Boolean actualValue = creditCardController.isCreditCardNumberValid( creditCard );
        assert actualValue.equals( true );

    }
    @Test
    public void testisCreditCardNumberValidInvalidValue(){
        String cardNumber = "1";
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber( cardNumber );
        Boolean actualValue = creditCardController.isCreditCardNumberValid( creditCard );
        assert actualValue.equals( false );
    }

    @Test
    public void testisCreditCardNumberValidNullValue(){
        String cardNumber = "";
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber( cardNumber );
        Boolean actualValue = creditCardController.isCreditCardNumberValid( creditCard );
        assert actualValue.equals( false );
    }

    @Test
    public void testisCreditCardNumberValidBigValue(){
        String cardNumber = "12345678901234567890";
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber( cardNumber );
        Boolean actualValue = creditCardController.isCreditCardNumberValid( creditCard );
        assert actualValue.equals( false );
    }
}
