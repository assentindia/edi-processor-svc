package net.assentindia.edi.processor.model.health835;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubElement{
    @JsonProperty("Sequence") 
    public int sequence;
    public String content;
}
