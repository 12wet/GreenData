package com.greendata.controllers;

import com.greendata.controllers.modelassemblers.InvestorModelAssembler;
import com.greendata.domain.client.Investor;
import com.greendata.exceptions.InvestorNotFoundException;
import com.greendata.services.InvestorService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/investors")
public class InvestorController {

    private final InvestorService investorService;
    private final InvestorModelAssembler investorModelAssembler;

    public InvestorController(InvestorService investorService, InvestorModelAssembler investorModelAssembler) {
        this.investorService = investorService;
        this.investorModelAssembler = investorModelAssembler;
    }

    @GetMapping({"", "/"})
    public CollectionModel<EntityModel<Investor>> allInvestors(){
        return investorModelAssembler.toCollectionModel(investorService.getAllInvestors());
    }

    @GetMapping("/{id}")
    public EntityModel<Investor> investor(@PathVariable Long id){
        return investorModelAssembler.toModel(investorService.getInvestorById(id)
                .orElseThrow(() -> new InvestorNotFoundException(id)));
    }
}
