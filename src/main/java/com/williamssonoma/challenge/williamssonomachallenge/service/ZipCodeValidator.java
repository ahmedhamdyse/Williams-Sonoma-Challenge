package com.williamssonoma.challenge.williamssonomachallenge.service;

import com.williamssonoma.challenge.williamssonomachallenge.domain.ZipCode;

import java.util.List;

/**
 * This service for filter out the invalid zip codes on pattern and range
 */

public interface ZipCodeValidator {
    /**
     * <p>
     * This method method for parsing zip code as string to {@link ZipCode}
     * filtering out the invalid ones on range and pattern
     * </p>
     *
     * @param zipCodes as array of strings
     * @return sorted valid list of {@link ZipCode}
     */
    List<ZipCode> validSortedZipCodes(List<String> zipCodes);
}
