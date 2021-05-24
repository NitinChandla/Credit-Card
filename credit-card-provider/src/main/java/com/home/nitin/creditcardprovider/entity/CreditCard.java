package com.home.nitin.creditcardprovider.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private Long cardId;

    @NonNull
    private String cardNumber;
    @NonNull
    private String cardHolderName;
    @Builder.Default
    private Long cardLimit= Long.valueOf( 0 );

    @Override
    public String toString() {
        return "CreditCard{" +
                "name='" + cardHolderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", limit=" + cardLimit +
                '}';
    }
}
