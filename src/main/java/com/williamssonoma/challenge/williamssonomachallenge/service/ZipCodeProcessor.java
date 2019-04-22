package com.williamssonoma.challenge.williamssonomachallenge.service;

import com.williamssonoma.challenge.williamssonomachallenge.domain.ZipCode;

import java.util.List;

/**
 * <p>
 * This service for processing and minimizing a given collection of 5-digit zip code ranges
 * representing the same restrictions
 * </p>
 */
public interface ZipCodeProcessor {
    /**
     * <p>
     * This method for processing a given collection of 5-digit zip code ranges
     * returning the Invalid zip codes for shipping
     * </p>
     *
     * @param zipCodeSet
     * @return Invalid zip codes for shipping
     */
    List<ZipCode> processZipCodes(List<ZipCode> zipCodeSet);
}
