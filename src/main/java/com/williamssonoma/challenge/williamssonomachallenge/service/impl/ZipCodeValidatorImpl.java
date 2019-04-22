package com.williamssonoma.challenge.williamssonomachallenge.service.impl;

import com.williamssonoma.challenge.williamssonomachallenge.domain.ZipCode;
import com.williamssonoma.challenge.williamssonomachallenge.service.ZipCodeValidator;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import static com.williamssonoma.challenge.williamssonomachallenge.util.ZipCodeConstants.*;

/**
 * This Class is the implementation of ZipCodeValidator interface {@link ZipCodeValidator}
 */

@Service
public class ZipCodeValidatorImpl implements ZipCodeValidator {

    @Override
    public List<ZipCode> validSortedZipCodes(List<String> zipCodes) {

        return zipCodes.stream().map(this::validPattern).filter(Matcher::find).
                map(matcher -> ZipCode.of(Integer.parseInt(matcher.group().substring(LOWER_BOUND_START_INDEX, LOWER_BOUND_END_INDEX)),
                        Integer.parseInt(matcher.group().substring(UPPER_BOUND_START_INDEX, UPPER_BOUND_END_INDEX))))
                .filter(this::validRange).sorted(Comparator.comparing(ZipCode::getLowerBound)).collect(Collectors.toList());
    }

    private Matcher validPattern(String zipCode) {
        return ZIP_CODE_PATTERN.matcher(zipCode.replaceAll(" ", ""));
    }

    private boolean validRange(ZipCode zipCode) {
        return zipCode.getLowerBound() <= zipCode.getUpperBound();
    }
}
