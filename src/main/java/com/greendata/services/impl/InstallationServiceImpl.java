package com.greendata.services.impl;

import com.greendata.domain.installation.Installation;
import com.greendata.repositories.InstallationRepository;
import com.greendata.services.InstallationService;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class InstallationServiceImpl implements InstallationService {

    private final InstallationRepository installationRepository;

    public InstallationServiceImpl(InstallationRepository installationRepository) {
        this.installationRepository = installationRepository;
    }

    @Override
    public Set<Installation> getAllInstallations() {
        return StreamSupport.stream(installationRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public Installation saveInstallation(Installation installation) {
        return installationRepository.save(installation);
    }

    @Override
    public Optional<Installation> getInstallationById(Long id) {
        return installationRepository.findById(id);
    }

    @Override
    public void deleteInstallationById(Long id) {
        installationRepository.deleteById(id);
    }

    @Override
    public void deleteInstallation(Installation installation) {
        installationRepository.delete(installation);
    }

    @Override
    public long countInstallations() {
        return installationRepository.count();
    }
}
