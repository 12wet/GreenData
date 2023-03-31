package com.greendata.repositories;

import com.greendata.domain.client.Investor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InvestorRepository extends CrudRepository<Investor, Long> {

    Optional<Investor> findByEmail(String email);

    Optional<Investor> findByPhoneNumber(String phoneNumber);

    Optional<Investor> findByLastName(String lastName);
}
