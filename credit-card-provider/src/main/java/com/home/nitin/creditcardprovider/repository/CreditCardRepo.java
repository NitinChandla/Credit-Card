package com.home.nitin.creditcardprovider.repository;

import com.home.nitin.creditcardprovider.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCard, String> {
    CreditCard findByCardNumber(String cardNumber);
}
