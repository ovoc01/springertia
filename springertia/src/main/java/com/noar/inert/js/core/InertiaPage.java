package com.noar.inert.js.core;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class InertiaPage {
    String component;
    Object props;
    String url;
}
