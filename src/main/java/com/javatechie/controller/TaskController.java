package com.javatechie.controller;

import com.javatechie.dto.TaskDto;
import com.javatechie.model.TaskModel;
import com.javatechie.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/hey")
    public String hello(){
        return "hello";
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskModel addTask(@RequestBody TaskDto taskDto){
        return taskService.addTask(taskDto);
    }

    @GetMapping
    public List<TaskModel> findAllTasks(){
        return taskService.findAllTasks();
    }
    @GetMapping("/{taskId}")
    public TaskModel getTaskByTaskId (@PathVariable String taskId){
        return taskService.getTaskByTaskId(taskId);
    }
    @GetMapping ("/severity/{severity}")
    public List<TaskModel> getTaskBySeverity (@PathVariable int severity){
        return taskService.getTaskBySeverity(severity);
    }
    @GetMapping ("/assignee/{assignee}")
    public List<TaskModel> getTaskByAssignee (@PathVariable String assignee){
        return taskService.getTaskByAssignee(assignee);
    }
    @GetMapping ("/storyPoint-Description/{storyPoint}/{description}")
    public List<TaskModel> getTasksByStoryPointAndDescription(@PathVariable("storyPoint") int storyPoint,@PathVariable("description") String description){
        return taskService.getTasksByStoryPointAndDescription(storyPoint,description);
    }

    @PutMapping
    public TaskModel updateTask(@RequestBody TaskDto taskDto){
        return taskService.updateTask(taskDto);
    }
    @DeleteMapping ("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }
}
