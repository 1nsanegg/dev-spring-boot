package com.nsane.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImp implements MembershipDAO{
    @Override
    public void addAccount() {

        System.out.println(getClass() + ": Doing my db work: Adding an membership account");
    }
}
