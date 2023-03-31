package com.greendata.repositories;

import com.greendata.domain.installation.Installation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallationRepository extends CrudRepository<Installation, Long> {
}
