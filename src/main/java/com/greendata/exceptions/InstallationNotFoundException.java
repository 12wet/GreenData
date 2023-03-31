package com.greendata.exceptions;

public class InstallationNotFoundException extends RuntimeException {

    public InstallationNotFoundException(Long id) {
        super("Could not find installation of id: " + id);
    }
}
