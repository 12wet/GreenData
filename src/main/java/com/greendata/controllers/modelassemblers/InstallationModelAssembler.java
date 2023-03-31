package com.greendata.controllers.modelassemblers;

import com.greendata.controllers.InstallationController;
import com.greendata.domain.installation.Installation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class InstallationModelAssembler
        implements RepresentationModelAssembler<Installation, EntityModel<Installation>> {

    @Override
    public EntityModel<Installation> toModel(Installation entity) {
        return EntityModel.of(entity,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(InstallationController.class)
                        .installation(entity.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(InstallationController.class)
                        .allInstallations()).withRel("installations"));
    }

    @Override
    public CollectionModel<EntityModel<Installation>> toCollectionModel(Iterable<? extends Installation> entities) {
        return CollectionModel.of(StreamSupport.stream(entities.spliterator(), false)
                        .map(this::toModel)
                        .collect(Collectors.toSet()),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(InstallationController.class)
                        .allInstallations()).withSelfRel());
    }
}
