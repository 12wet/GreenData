package com.greendata.services;

import com.greendata.domain.installation.Installation;
import com.greendata.domain.installation.Quotation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface QuotationService {

    Quotation create(MultipartFile quotation, Installation installation)
            throws IOException;
}
