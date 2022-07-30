package com.greendata.services;

import com.greendata.domain.installation.Installation;

import java.util.Optional;
import java.util.Set;

public interface InstallationService {

    Set<Installation> getAllInstallations();

    Installation saveInstallation(Installation installation);

    Optional<Installation> getInstallationById(Long id);

    void deleteInstallationById(Long id);

    void deleteInstallation(Installation installation);

    long countInstallations();
}
