package com.example.soft_cons.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "timetables")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeTable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @JsonProperty("id")
    private long id;
    private String title;
    private String semester;
    private Date updatedAt;
    private Date createdAt;

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    // @JsonProperty("userData")
    private User user;

    // @OneToMany(mappedBy = "timetable_data")
    // // @JoinColumn(name="event_id",referencedColumnName = "id")
    // // @JsonProperty("userData")
    // private List<Event> events;

    // @OneToOne(mappedBy="timetable_data")
    // private Event event_s;

    // @OneToMany(targetEntity = Event.class,cascade = CascadeType.ALL )
    // @JoinColumn(name = "timetable_id",referencedColumnName = "id")
    // private List<Event> events;
    

    // public TimeTable(String title, String semester) {
    //     this.title = title;
    //     this.semester = semester;
    
    // }

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // public long getId() {
    //     return id;
    // }
    // public void setId(long id) {
    //     this.id = id;
    // }

    // @Column(name = "title", nullable = false)
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }


    // @Column(name = "semester", nullable = false)
    // public String getSemester() {
    //     return semester;
    // }
    // public void setSemester(String semester) {
    //     this.semester = semester;
    // }

    // @Override
    // public String toString() {
    //     return "Employee [id=" + id + ", title=" + title + ", semester=" + semester + "]";
    // }

}