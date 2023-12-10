package net.assentindia.edi.processor.model.health835;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Loop{
    public Object segment;
    @JsonProperty("Id") 
    public int id;
    public List<Loop> loop;
}
