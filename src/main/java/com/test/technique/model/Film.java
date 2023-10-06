package com.test.technique.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Film(
    @JsonProperty("title")
    String title
) {}
