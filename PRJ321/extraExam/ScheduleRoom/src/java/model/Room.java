/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author hoangnm
 */
public class Room {
    private int id;
    private String name;
    private ArrayList<Schedule> schedule;
    private boolean isFree;

    public boolean isIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    
    

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }
    
    public boolean isSchedule(Date from, java.time.LocalDate check, Date to) {
        Date temp = Date.valueOf(check);
        return temp.compareTo(from) >= 0 && temp.compareTo(to) <= 0;
    }
}
