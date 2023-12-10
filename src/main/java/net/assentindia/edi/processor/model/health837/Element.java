package net.assentindia.edi.processor.model.health837;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Element{
    @JsonProperty("Id") 
    public String id;
    public Object content;
}
