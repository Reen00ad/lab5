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

    @GetMapping("/get/name")
    public ArrayList<String> getName(){
           ArrayList<String> name=new ArrayList<>();
           for(Student st:students){
               st.getName();
             name.add(st.getName());
         }
        return name;
    }
    @GetMapping("/get/age")
    public ArrayList<Integer> getAge(){
         ArrayList<Integer> age=new ArrayList<>();
         for(Student st : students){
             age.add(st.getAge());
         }
         return age;
    }

    @GetMapping("/get/degree")
    public ArrayList<String> getDegree(){
        ArrayList<String> degree=new ArrayList<>();
        for(Student st:students){
            degree.add(st.getDegree());
        }
        return degree;
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
