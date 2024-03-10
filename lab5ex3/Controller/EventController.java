package com.example.lab5ex3.Controller;

import com.example.lab5ex3.ApiResponce.ApiResponce;
import com.example.lab5ex3.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("api/v1/event")
public class EventController {

    ArrayList<Event> events=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PostMapping("/add")
    public ApiResponce addEvent(@RequestBody Event event){
        events.add(event);
        return new ApiResponce("event added");
    }

    @PutMapping("/update/{index}")
    public ApiResponce updateEvent(@PathVariable int index,@RequestBody Event event){
        events.set(index,event);
        return new ApiResponce("event updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponce deleteEvent(@PathVariable int index){
        events.remove(index);
        return new ApiResponce("event deleted");
    }

    @PutMapping("/change/{index}/{capacity}")
    public ApiResponce change(@PathVariable int index,@PathVariable int capacity){

        events.get(index).setCapacity(capacity);
        return new ApiResponce("capacity change");
    }

    @GetMapping("/search/{id}")
    public ArrayList<Event> search(@PathVariable String id){
        ArrayList<Event> searches = new ArrayList<>();
        for( Event e : events){
            if(e.getId().equals(id)){
                searches.add(e);}
        }
        return searches;
    }


}
