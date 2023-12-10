package net.assentindia.edi.processor.model.health837;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Interchange{
    @JsonProperty("Authorization") 
    public String authorization;
    @JsonProperty("Control") 
    public int control;
    public Receiver receiver;
    @JsonProperty("AuthorizationQual") 
    public String authorizationQual;
    @JsonProperty("Version") 
    public String version;
    public Sender sender;
    @JsonProperty("SecurityQual") 
    public String securityQual;
    @JsonProperty("Standard") 
    public String standard;
    @JsonProperty("Time") 
    public int time;
    @JsonProperty("Security") 
    public String security;
    @JsonProperty("Date") 
    public int date;
    //@JsonProperty("TestIndicator")
    //public String testIndicator;
    @JsonProperty("AckRequest")
    public String ackRequest;
    public Group group;
}
