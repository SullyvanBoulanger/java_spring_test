package com.test.technique.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CharacterList (
    @JsonProperty("count")
    Integer count,
    @JsonProperty("next")
    String next,
    @JsonProperty("previous")
    String previous,
    @JsonProperty("results")
    List<Character> results
){}
