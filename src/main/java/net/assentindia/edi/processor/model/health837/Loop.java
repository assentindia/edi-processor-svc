package net.assentindia.edi.processor.model.health837;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Loop{
    public Object segment;
    @JsonProperty("Id") 
    public String id;
    public ArrayList<Loop> loop;
}
