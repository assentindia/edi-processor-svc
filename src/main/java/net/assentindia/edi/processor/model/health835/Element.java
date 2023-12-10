package net.assentindia.edi.processor.model.health835;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Element{
    @JsonProperty("Composite") 
    public String composite;
    public List<SubElement> subelement;
    @JsonProperty("Id") 
    public String id;
    public Object content;
}
