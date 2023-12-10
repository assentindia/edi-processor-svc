package net.assentindia.edi.processor.model.health837;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Address{
    @JsonProperty("Qual") 
    public String qual;
    @JsonProperty("Id") 
    public String id;
}
