package com.example.soft_cons.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "events")
public class Event {
    @Id
    private long id;
    private String name;
    private String day;
    private String time;
    private Date createdAt;
    private Date updatedAt;
    @Column(name = "timetable_id", nullable=false)
    private long timetable_id;
    // @Getter public String timetable_id;


    @ManyToOne
    @JoinColumn(name="timetable_id", referencedColumnName = "id", insertable=false, updatable=false)
    // @JsonProperty("timetable_data")
    private TimeTable timetable_data;

    public long getTimetableId(){
        return timetable_id;
    }

    // public Event() {

    // }

    // public Event(String name, String day, String time) {
    //     this.name = name;
    //     this.day = day;
    //     this.time = time;
    // }

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // public long getId() {
    //     return id;
    // }
    // public void setId(long id) {
    //     this.id = id;
    // }

    // @Column(name = "name", nullable = false)
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }

    // @Column(name = "day", nullable = false)
    // public String getDay() {
    //     return day;
    // }
    // public void setDay(String day) {
    //     this.day = day;
    // }

    // @Column(name = "time", nullable = false)
    // public String getTime() {
    //     return time;
    // }
    // public void setTime(String time) {
    //     this.time = time;
    // }

    // @Override
    // public String toString() {
    //     return "Employee [id=" + id + ", name=" + name + ", day=" + day + ", time=" + time
    //             + "]";
    // }

}