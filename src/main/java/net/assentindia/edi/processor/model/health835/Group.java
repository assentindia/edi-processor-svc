package net.assentindia.edi.processor.model.health835;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Group{
    @JsonProperty("Control") 
    public int control;
    @JsonProperty("GroupType") 
    public String groupType;
    @JsonProperty("ApplReceiver") 
    public String applReceiver;
    @JsonProperty("StandardVersion") 
    public String standardVersion;
    @JsonProperty("Time") 
    public String time;
    @JsonProperty("StandardCode") 
    public String standardCode;
    @JsonProperty("Date") 
    public int date;
    public Transaction transaction;
    @JsonProperty("ApplSender") 
    public String applSender;
}
