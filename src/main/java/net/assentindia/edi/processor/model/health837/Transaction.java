package net.assentindia.edi.processor.model.health837;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Transaction{
    @JsonProperty("Control") 
    public String control;
    public ArrayList<Loop> loop;
    public Segment segment;
    @JsonProperty("DocType") 
    public int docType;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Version") 
    public String version;
}
