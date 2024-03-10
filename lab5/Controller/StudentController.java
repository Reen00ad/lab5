package com.example.lab5.Controller;

import com.example.lab5.ApiResponce.ApiResponce;
import com.example.lab5.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

 ArrayList<Student> students=new ArrayList<>();


     @PostMapping("/add")
     public ApiResponce addStudent(@RequestBody Student student){
       students.add(student);
       return new ApiResponce("student added");
     }

     @GetMapping("/get")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @GetMapping("/get/name/{index}")
    public String getName(@PathVariable int index){
        return students.get(index).getName();
    }
    @GetMapping("/get/age/{index}")
    public int getAge(@PathVariable int index){
         return students.get(index).getAge();
    }

    @GetMapping("/get/degree/{index}")
    public String getDegree(@PathVariable int index){
     return students.get(index).getDegree();
    }

    @GetMapping("/get/status/{index}")
    public ArrayList<Boolean> getStatus(@PathVariable int index){
          ArrayList<Boolean> status=new ArrayList<>();
        if(students.get(index).getStatus().equalsIgnoreCase("graduated")){
             status.add(true) ;}
            else
        status.add(false);
            return status;
    }

    @PutMapping("/update/{index}")
    public ApiResponce updateStudent(@PathVariable int index,@RequestBody Student student){
        students.set(index,student);
        return new ApiResponce ("student updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponce deleteStudent(@PathVariable int index){
        students.remove(index);
        return new ApiResponce ("student deleted");
    }
}
