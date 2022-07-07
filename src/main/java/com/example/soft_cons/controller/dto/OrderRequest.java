package com.example.soft_cons.controller.dto;

import com.example.soft_cons.model.TimeTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {
    private TimeTable timetables;
}
