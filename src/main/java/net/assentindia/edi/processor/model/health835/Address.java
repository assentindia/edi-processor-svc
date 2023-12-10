package net.assentindia.edi.processor.model.health835;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address{
    @JsonProperty("Qual") 
    public String qual;
    @JsonProperty("Id") 
    public String id;
}
