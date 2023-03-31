package com.greendata.controllers.modelassemblers;

import com.greendata.controllers.InvestorController;
import com.greendata.domain.client.Investor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Component
public class InvestorModelAssembler implements RepresentationModelAssembler<Investor, EntityModel<Investor>> {

    @Override
    public EntityModel<Investor> toModel(Investor entity) {
        return EntityModel.of(entity,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(InvestorController.class)
                        .investor(entity.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(InvestorController.class)
                        .allInvestors()).withRel("investors"));
    }

    @Override
    public CollectionModel<EntityModel<Investor>> toCollectionModel(Iterable<? extends Investor> entities) {
        return CollectionModel.of(StreamSupport.stream(entities.spliterator(), false)
                .map(this::toModel)
                .collect(Collectors.toSet()),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(InvestorController.class)
                        .allInvestors()).withSelfRel());
    }
}
