package com.greendata.controllers;

import com.greendata.controllers.modelassemblers.InstallationModelAssembler;
import com.greendata.domain.installation.Installation;
import com.greendata.domain.installation.InstallationStatus;
import com.greendata.exceptions.InstallationNotFoundException;
import com.greendata.responses.ResponseMessage;
import com.greendata.responses.base.Response;
import com.greendata.services.InstallationService;
import com.greendata.services.QuotationService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/installations")
public class InstallationController {

    private final InstallationService installationService;
    private final InstallationModelAssembler installationModelAssembler;
    private final QuotationService quotationService;

    public InstallationController(InstallationService installationService,
                                  InstallationModelAssembler installationModelAssembler,
                                  QuotationService quotationService) {
        this.installationService = installationService;
        this.installationModelAssembler = installationModelAssembler;
        this.quotationService = quotationService;
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

    @PostMapping("/{id}/quotations/upload")
    public ResponseEntity<EntityModel<? extends Response>> uploadQuotation(
            @RequestParam("file") MultipartFile quotation,
            @PathVariable Long id
    ){
        Installation installation =  installationService
                .getInstallationById(id)
                .orElseThrow(() -> new InstallationNotFoundException(id));
        try {
            installation.getQuotations().add(quotationService.create(quotation, installation));
        } catch (IOException e) {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(EntityModel.of(new ResponseMessage(
                            "Could not create quotation for installation of ID: " + id
                    )));
        }

        EntityModel<Installation> installationEntityModel = installationModelAssembler
                .toModel(installationService.saveInstallation( installation));

        return ResponseEntity
                .ok()
                .body(installationEntityModel);
    }

}
