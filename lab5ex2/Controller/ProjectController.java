package com.example.lab5ex2.Controller;

import com.example.lab5ex2.ApiResponce.ApiResponce;
import com.example.lab5ex2.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    ArrayList<Project>projects=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Project> getProjects(){
        return projects;
    }

    @PostMapping("/add")
    public ApiResponce addProject(@RequestBody Project project){
        projects.add(project);
        return new ApiResponce("project added");
    }

    @PutMapping("/update/{index}")
    public ApiResponce updateProject(@PathVariable int index,@RequestBody Project project){
         projects.set(index,project);
         return new ApiResponce("project updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponce deleteProject(@PathVariable int index){
        projects.remove(index);
        return new ApiResponce("project deleted");
    }

    @PutMapping("/change/{index}")
    public ApiResponce change(@PathVariable int index){
        if(projects.get(index).getStatus().equalsIgnoreCase("not done")){
            projects.get(index).setStatus("done");
            return new ApiResponce("project change");
        }
        return new ApiResponce("not change");
    }

    @GetMapping("/search/{title}")
    public ArrayList<Project> search(@PathVariable String title){
        ArrayList<Project> searches = new ArrayList<>();
        for( Project p : projects){
            if(p.getTitle().equalsIgnoreCase(title)){
                searches.add(p);}
        }
        return searches;
    }

    @GetMapping("/get/{comName}")
    public ArrayList<Project> company(@PathVariable String comName){
        ArrayList<Project> company=new ArrayList<>();
        for(Project p :projects){
          if(p.getCompanyName().equalsIgnoreCase(comName)){
              company.add(p);}
          }  return company;
        }
    }

