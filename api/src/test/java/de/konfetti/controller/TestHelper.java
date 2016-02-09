package de.konfetti.controller;

import de.konfetti.data.Party;
import de.konfetti.data.Request;

public class TestHelper {
	
    public TestHelper() {
    }

    public Party getTestParty1() {
        Party testParty =  new Party();
        testParty.setName("testParty1");
        testParty.setLat(new Float("0.0"));
        testParty.setLon(new Float("0.0"));
        return  testParty;
    }

    public Party getTestParty2() {
        Party testParty =  new Party();
        testParty.setName("testParty2");
        testParty.setLat(new Float("0.0"));
        testParty.setLon(new Float("0.0"));
        return  testParty;

    }

    public Request getTestRequest1(Party party){
        Request request = new Request();
        request.setTitle("testPartyTitle1");
        request.setKonfettiAdd(10);
        request.setKonfettiCount(20);
        return request;
    }

}