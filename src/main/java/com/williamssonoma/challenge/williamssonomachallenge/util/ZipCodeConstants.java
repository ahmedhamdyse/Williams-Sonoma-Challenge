package com.williamssonoma.challenge.williamssonomachallenge.util;

import java.util.regex.Pattern;

/**
 * This class for zip code constants, for avoiding multiple changes in the future if required
 */
public final class ZipCodeConstants {

    /**
     * This private constructor for avoiding creating an instance of the class, because it's a utility class
     */
    private ZipCodeConstants() {
    }

    public static final Pattern ZIP_CODE_PATTERN = Pattern.compile("\\[\\d{5},\\d{5}]");
    public static final int LOWER_BOUND_START_INDEX = 1;
    public static final int LOWER_BOUND_END_INDEX = 6;
    public static final int UPPER_BOUND_START_INDEX = 7;
    public static final int UPPER_BOUND_END_INDEX = 12;
}
