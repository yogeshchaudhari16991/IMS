package com.commercehub.IMS.main.Models;

/**
 * Created by yoges on 7/20/2016.
 */
public class Location {
    private String Zone;
    private String Section;

    public Location() {
        super();
    }

    public Location(String zone, String section) {
        this();
        Zone = zone;
        Section = section;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String zone) {
        Zone = zone;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }
}
