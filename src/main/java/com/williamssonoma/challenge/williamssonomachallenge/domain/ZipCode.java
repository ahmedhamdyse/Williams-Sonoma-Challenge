package com.williamssonoma.challenge.williamssonomachallenge.domain;

import lombok.Data;
import lombok.NonNull;

/**
 * This pojo class representing zip code domain class
 */

@Data(staticConstructor = "of")
public class ZipCode {
    @NonNull
    private Integer lowerBound;
    @NonNull
    private Integer upperBound;

    @Override
    public String toString() {
        return "[" + lowerBound + "," + upperBound + ']';
    }
}
