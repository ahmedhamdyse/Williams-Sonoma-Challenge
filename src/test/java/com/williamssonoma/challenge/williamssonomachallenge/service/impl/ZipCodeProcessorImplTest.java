package com.williamssonoma.challenge.williamssonomachallenge.service.impl;

import com.williamssonoma.challenge.williamssonomachallenge.domain.ZipCode;
import com.williamssonoma.challenge.williamssonomachallenge.service.ZipCodeProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ZipCodeProcessorImplTest {

    private ZipCodeProcessor zipCodeProcessor;

    @Before
    public void setUp() {
        zipCodeProcessor = new ZipCodeProcessorImpl();
    }

    @Test
    public void processZipCodes() {
        List<ZipCode> validZipCodes1 = zipCodeProcessor.processZipCodes(Stream.of(ZipCode.of(94133, 94133), ZipCode.of(94200, 94299), ZipCode.of(94226, 94399)).collect(Collectors.toList()));
        List<ZipCode> expectedZipCodes1 = Stream.of(ZipCode.of(94133, 94133), ZipCode.of(94200, 94399)).collect(Collectors.toList());
        List<ZipCode> validZipCodes2 = zipCodeProcessor.processZipCodes(Stream.of(ZipCode.of(94133, 94133), ZipCode.of(94200, 94299), ZipCode.of(94600, 94699)).collect(Collectors.toList()));
        List<ZipCode> expectedZipCodes2 = Stream.of(ZipCode.of(94133, 94133), ZipCode.of(94200, 94299), ZipCode.of(94600, 94699)).collect(Collectors.toList());
        assertEquals(validZipCodes1, expectedZipCodes1);
        assertEquals(validZipCodes2, expectedZipCodes2);
    }


}