package cl.enexo.test2kevin.models;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Kevin on 13-11-2016.
 */

public class Match extends SugarRecord {
    private String name;
    private Date datematch;
    private String place;
    private String time;

    public Match() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDatematch() {
        return datematch;
    }
    public void setDatematch(Date fecha) {
        this.datematch = fecha;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
