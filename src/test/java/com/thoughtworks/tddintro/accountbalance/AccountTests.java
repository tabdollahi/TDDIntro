package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountTests {
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        assertThat(new Account(100).deposit(50), is(150));
    }
//
//    @Test
//    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
//
//    }
//
//    @Test
//    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
//
//    }
}
