package com.greendata.repositories;

import com.greendata.domain.client.Investor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InvestorRepository extends CrudRepository<Investor, Long> {

    Optional<Investor> findByEmail();

    Optional<Investor> findByPhoneNumber();

    Optional<Investor> findByLastName();
}
