package com.williamssonoma.challenge.williamssonomachallenge.service.impl;

import com.williamssonoma.challenge.williamssonomachallenge.domain.ZipCode;
import com.williamssonoma.challenge.williamssonomachallenge.service.ZipCodeValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ZipCodeValidatorImplTest {

    private ZipCodeValidator zipCodeValidator;

    @Before
    public void setUp() {
        zipCodeValidator = new ZipCodeValidatorImpl();
    }

    @Test
    public void whenValidPatternAndRangeShouldInclude() {

        List<ZipCode> validZipCodes = zipCodeValidator.validSortedZipCodes(Stream.of("[94133,94133]", "[94200,94299]", "[94226,94399]").collect(Collectors.toList()));
        List<ZipCode> expectedZipCodes = Stream.of(ZipCode.of(94133, 94133), ZipCode.of(94200, 94299), ZipCode.of(94226, 94399)).collect(Collectors.toList());
        assertEquals(validZipCodes, expectedZipCodes);
    }

    @Test
    public void whenInvalidPatternShouldFilterOut() {

        List<ZipCode> validZipCodes = zipCodeValidator.validSortedZipCodes(Stream.of("[9413,9413]", "[94200,94299]", "[94226,94398]").collect(Collectors.toList()));
        List<ZipCode> expectedZipCodes = Stream.of(ZipCode.of(94200, 94299), ZipCode.of(94226, 94398)).collect(Collectors.toList());
        assertEquals(validZipCodes, expectedZipCodes);
    }

    @Test
    public void whenInvalidRangeShouldFilterOut() {

        List<ZipCode> validZipCodes = zipCodeValidator.validSortedZipCodes(Stream.of("[94133,94133]", "[95200,94299]", "[94226,94397]").collect(Collectors.toList()));
        List<ZipCode> expectedZipCodes = Stream.of(ZipCode.of(94133, 94133), ZipCode.of(94226, 94397)).collect(Collectors.toList());
        assertEquals(validZipCodes, expectedZipCodes);
    }

    @Test(expected = NullPointerException.class)
    public void whenPassingNullToValidSortedZipCodesShoudThrowNullPointer() {
        zipCodeValidator.validSortedZipCodes(null);
    }

}