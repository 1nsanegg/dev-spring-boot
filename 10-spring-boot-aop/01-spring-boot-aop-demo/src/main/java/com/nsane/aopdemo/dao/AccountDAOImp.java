package com.nsane.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO{
    @Override
    public void addAccount() {

        System.out.println(getClass() + ": Doing my db work: Adding an account");
    }
}
