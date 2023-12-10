package net.assentindia.edi.processor.model.health835;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction{
    @JsonProperty("Control") 
    public String control;
    public List<Loop> loop;
    public List<Segment> segment;
    @JsonProperty("DocType") 
    public int docType;
    @JsonProperty("Name") 
    public String name;
}
