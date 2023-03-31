package com.greendata.controllers;

import com.greendata.controllers.modelassemblers.InstallationModelAssembler;
import com.greendata.domain.installation.Installation;
import com.greendata.domain.installation.InstallationStatus;
import com.greendata.exceptions.InstallationNotFoundException;
import com.greendata.services.InstallationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/installations")
public class InstallationController {

    private final InstallationService installationService;
    private final InstallationModelAssembler installationModelAssembler;

    public InstallationController(InstallationService installationService, InstallationModelAssembler installationModelAssembler) {
        this.installationService = installationService;
        this.installationModelAssembler = installationModelAssembler;
    }

    @GetMapping({"", "/"})
    public CollectionModel<EntityModel<Installation>> allInstallations(){
        return installationModelAssembler.toCollectionModel(installationService.getAllInstallations());
    }

    @GetMapping("/{id}")
    public EntityModel<Installation> installation(@PathVariable Long id){
        return installationModelAssembler.toModel(installationService.getInstallationById(id)
                .orElseThrow(() -> new InstallationNotFoundException(id)));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<EntityModel<Installation>> newInstallation(@RequestBody Installation installation){
        installation.setInstallationStatus(InstallationStatus.PENDING);
        EntityModel<Installation> installationEntityModel = installationModelAssembler
                .toModel(installationService.saveInstallation(installation));

        return ResponseEntity
                .created(installationEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(installationEntityModel);
    }

}
