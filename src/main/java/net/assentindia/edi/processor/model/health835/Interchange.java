package net.assentindia.edi.processor.model.health835;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Interchange{
    @JsonProperty("Control") 
    public int control;
    public Receiver receiver;
    @JsonProperty("Version") 
    public String version;
    public Sender sender;
    @JsonProperty("Standard") 
    public String standard;
    @JsonProperty("Time") 
    public String time;
    @JsonProperty("Date") 
    public int date;
    @JsonProperty("TestIndicator")
    public String testIndicator;
    @JsonProperty("AckRequest")
    public String ackRequest;
    public Group group;
}
