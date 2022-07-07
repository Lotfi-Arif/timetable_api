package com.example.soft_cons.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.soft_cons.controller.dto.OrderRequest;
import com.example.soft_cons.exception.ResourceNotFoundException;
import com.example.soft_cons.model.TimeTable;
import com.example.soft_cons.model.Event;
import com.example.soft_cons.repository.EventRepository;
import com.example.soft_cons.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class TimeTableController {
    @Autowired
    private TimeTableRepository timetableRepository;
    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/placeTimeTable")
    public TimeTable placeTimetable(@RequestBody OrderRequest request){
        return timetableRepository.save(request.getTimetables());
    }
    @GetMapping("/findAllTimeTable")
    public List<TimeTable> findAllTimeTable() {
        return timetableRepository.findAll();
    }
    @GetMapping("/findAllTimeTableFull")
    public List<Event> findAllTimeTableFull() {
        return eventRepository.findAll();
    }

    @GetMapping("/findAllTimeTableFull/{id}")
    public List<Event> getTimeTableById(@PathVariable(value = "id") Long timetableId)
             {
                List<Event> allevent= eventRepository.findAll();
                List<Event> temp = new ArrayList<>();
                for (Event event : allevent) {
                    if(event.timetable_id.equals(timetableId.toString()) ){
                        temp.add(event);
                    }
                }
                return temp;
    }

    

//     @GetMapping("/timetables_full/{id}")
//     public ResponseEntity<Event> getTimeTableByIdd(@PathVariable(value = "id") Long timetableId)
//             throws ResourceNotFoundException {
//         Event timetable = eventRepository.findById(timetableId)
//                 .orElseThrow(() -> new ResourceNotFoundException("TimeTable not found for this id :: " + timetableId));
//         return ResponseEntity.ok().body(timetable);
//     }

    @PostMapping("/timetables")
    public TimeTable createTimeTable(@Valid @RequestBody TimeTable timetable) {
        return timetableRepository.save(timetable);
    }

//     @PutMapping("/timetables/{id}")
//     public ResponseEntity<TimeTable> updateTimeTable(@PathVariable(value = "id") Long timetableId,
//                                              @Valid @RequestBody TimeTable timetableDetails) throws ResourceNotFoundException {
//         TimeTable timetable = timetableRepository.findById(timetableId)
//                 .orElseThrow(() -> new ResourceNotFoundException("TimeTable not found for this id :: " + timetableId));

//         timetable.setSemester(timetableDetails.getSemester());
//         timetable.setTitle(timetableDetails.getTitle());
//         final TimeTable updatedTimeTable = timetableRepository.save(timetable);
//         return ResponseEntity.ok(updatedTimeTable);
//     }

//     @DeleteMapping("/timetables/{id}")
//     public Map<String, Boolean> deleteTimeTable(@PathVariable(value = "id") Long timetableId)
//             throws ResourceNotFoundException {
//         TimeTable timetable = timetableRepository.findById(timetableId)
//                 .orElseThrow(() -> new ResourceNotFoundException("TimeTable not found for this id :: " + timetableId));

//         timetableRepository.delete(timetable);
//         Map<String, Boolean> response = new HashMap<>();
//         response.put("deleted", Boolean.TRUE);
//         return response;
//     }
 }