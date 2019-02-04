package com.example.android.chongzhe_cardiobook;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "measurement_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int priority;
    private String date;
    private String time;
    private int systolic_Pressure;
    private int diastolic_Pressure;
    private int heart_Rate;
    private String comment;

    public Note(int priority, String date, String time, int systolic_Pressure, int diastolic_Pressure, int heart_Rate, String comment) {
        this.priority = priority;
        this.date = date;
        this.time = time;
        this.systolic_Pressure = systolic_Pressure;
        this.diastolic_Pressure = diastolic_Pressure;
        this.heart_Rate = heart_Rate;
        this.comment = comment;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getSystolic_Pressure() {
        return systolic_Pressure;
    }

    public int getDiastolic_Pressure() {
        return diastolic_Pressure;
    }

    public int getHeart_Rate() {
        return heart_Rate;
    }

    public String getComment() {
        return comment;
    }
}
