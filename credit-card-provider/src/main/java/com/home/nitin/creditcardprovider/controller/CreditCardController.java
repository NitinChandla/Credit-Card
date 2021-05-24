package com.home.nitin.creditcardprovider.controller;

import com.google.gson.Gson;
import com.home.nitin.creditcardprovider.entity.CreditCard;
import com.home.nitin.creditcardprovider.exception.InvalidCardNumberException;
import com.home.nitin.creditcardprovider.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class CreditCardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public void addCard(@RequestBody CreditCard creditCard) {
        if(isCreditCardNumberValid(creditCard)){
            cardService.addCard( creditCard);
        } else {
            throw new InvalidCardNumberException();
        }
    }

    Boolean isCreditCardNumberValid(CreditCard creditCard) {

        if(creditCard != null) {
            if(creditCard.getCardNumber() != null && creditCard.getCardNumber().trim().length() > 0) {
                //Removing spaces if any
                String cardNumber = creditCard.getCardNumber().trim().replaceAll( " " , "");
                if( cardNumber.length() <= 19 && cardNumber.matches( "[0-9]*" )){

                    return isCardNumberCompatible(creditCard.getCardNumber());
                }
            }
        }
        return false;
    }

     Boolean isCardNumberCompatible(String cardNumber) {
        List<Integer> integerList = new ArrayList<>();
        List<Integer> integerEvenList = new ArrayList<>();
        String newCardNumber = cardNumber.trim().replaceAll( " " , "");
        if(newCardNumber != null && newCardNumber.length() > 0) {
            String[] stringArray = newCardNumber.split( "" );
            int j = stringArray.length;

            for (int i = stringArray.length - 1; i >= 0; i--) {
                if (j % 2 == 0) {
                    Integer value = Integer.parseInt( stringArray[i] ) * 2;
                    if (value < 9) {
                        integerEvenList.add( value );
                    } else {
                        integerEvenList.add( value % 10 );
                        integerEvenList.add( 1 );
                    }
                } else {
                    integerList.add( Integer.parseInt( stringArray[i] ) );
                }
                j--;
            }

            Integer finalValue = Stream.concat( integerList.stream(), integerEvenList.stream() )
                    .collect( Collectors.summingInt( Integer::intValue ) );

            if (finalValue % 10 == 0) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/getAll")
    public String getAllCards(){
        return new Gson().toJson(  cardService.getCardDetails() );
    }
}
