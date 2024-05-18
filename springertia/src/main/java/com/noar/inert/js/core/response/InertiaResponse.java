package com.noar.inert.js.core.response;

import lombok.Value;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Value
public class InertiaResponse {
    Object values;


    public static List<InertiaResponse> mapToInertiaResponse(Map<String, Object> values) {
        return Collections.singletonList(new InertiaResponse(values));
    }
}
