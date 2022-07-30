package com.greendata.repositories;

import com.greendata.domain.installation.Installation;
import org.springframework.data.repository.CrudRepository;

public interface InstallationRepository extends CrudRepository<Installation, Long> {
}
