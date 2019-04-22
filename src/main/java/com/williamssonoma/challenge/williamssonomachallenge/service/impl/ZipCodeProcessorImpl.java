package com.williamssonoma.challenge.williamssonomachallenge.service.impl;

import com.williamssonoma.challenge.williamssonomachallenge.domain.ZipCode;
import com.williamssonoma.challenge.williamssonomachallenge.service.ZipCodeProcessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class is the implementation of ZipCodeValidator interface {@link ZipCodeProcessor}
 */
@Service
public class ZipCodeProcessorImpl implements ZipCodeProcessor {

    @Override
    public List<ZipCode> processZipCodes(List<ZipCode> zipCodeList) {

        List<ZipCode> processedZipCodeList = new ArrayList<>();
        zipCodeList.stream().reduce((zipCode1, zipCode2) -> {
            if (zipCode2.getLowerBound() <= zipCode1.getUpperBound() + 1) {
                zipCode1.setUpperBound(Math.max(zipCode1.getUpperBound(), zipCode2.getUpperBound()));
                return zipCode1;
            } else {
                processedZipCodeList.add(zipCode1);
                return zipCode2;
            }

        }).ifPresent(zipCode -> processedZipCodeList.add(zipCode));
        return processedZipCodeList;
    }
}
