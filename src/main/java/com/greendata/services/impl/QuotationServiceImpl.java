package com.greendata.services.impl;

import com.greendata.domain.installation.Installation;
import com.greendata.domain.installation.Quotation;
import com.greendata.services.QuotationService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class QuotationServiceImpl implements QuotationService {

    @Override
    public Quotation create(MultipartFile quotation, Installation installation)
            throws IOException {
        Quotation newQuotation = new Quotation();
        newQuotation.setQuotation(quotation.getBytes());
        newQuotation.setInstallation(installation);
        newQuotation.setInvestor(installation.getInvestor());
        return newQuotation;
    }
}
