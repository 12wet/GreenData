package com.greendata.services.impl;

import com.greendata.domain.client.Investor;
import com.greendata.repositories.InvestorRepository;
import com.greendata.services.InvestorService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InvestorServiceImpl implements InvestorService {

    private final InvestorRepository investorRepository;

    public InvestorServiceImpl(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @Override
    public Set<Investor> getAllInvestors() {
        return StreamSupport.stream(investorRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public Investor saveInvestor(Investor investor) {
        return investorRepository.save(investor);
    }

    @Override
    public Optional<Investor> getInvestorById(Long id) {
        return investorRepository.findById(id);
    }

    @Override
    public Optional<Investor> getInvestorByEmail(String email) {
        return investorRepository.findByEmail(email);
    }

    @Override
    public Optional<Investor> getInvestorByPhoneNumber(String phoneNumber) {
        return investorRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<Investor> getInvestorByLastName(String lastname) {
        return investorRepository.findByLastName(lastname);
    }

    @Override
    public void deleteInvestorById(Long id) {
        investorRepository.deleteById(id);
    }

    @Override
    public void deleteInvestor(Investor investor) {
        investorRepository.delete(investor);
    }

    @Override
    public long countInvestors() {
        return investorRepository.count();
    }
}
