package com.greendata.services;

import com.greendata.domain.client.Investor;

import java.util.Optional;
import java.util.Set;

public interface InvestorService {

    Set<Investor> getAllInvestors();

    Investor saveInvestor(Investor investor);

    Optional<Investor> getInvestorById(Long id);

    Optional<Investor> getInvestorByEmail(String email);

    Optional<Investor> getInvestorByPhoneNumber(String phoneNumber);

    Optional<Investor> getInvestorByLastName(String lastName);

    void deleteInvestorById(Long id);

    void deleteInvestor(Investor investor);

    long countInvestors();




}
