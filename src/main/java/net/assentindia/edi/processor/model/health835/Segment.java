package net.assentindia.edi.processor.model.health835;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Segment{
    @JsonProperty("Id") 
    public String id;
    public List<Element> element;
}
