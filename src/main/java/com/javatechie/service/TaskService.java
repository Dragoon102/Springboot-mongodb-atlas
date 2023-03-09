package com.javatechie.service;

import com.javatechie.dto.TaskDto;
import com.javatechie.model.TaskModel;
import com.javatechie.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.messaging.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // CRUD CREATE,READ,UPDATE,DELETE

    public TaskModel addTask(TaskDto taskDto){

        TaskModel taskModel=new TaskModel();
        taskModel.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        taskModel.setAssignee(taskDto.getAssignee());
        taskModel.setDescription(taskDto.getDescription());
        taskModel.setSeverity(taskDto.getSeverity());
        taskModel.setStoryPoint(taskDto.getStoryPoint());

        return taskRepository.save(taskModel);
    }

    public List<TaskModel> findAllTasks(){
        return taskRepository.findAll();
    }

    public TaskModel getTaskByTaskId (String taskId){
        return taskRepository.findById(taskId).get();
    }

    public List<TaskModel> getTaskBySeverity (int severity){
        return taskRepository.findBySeverity(severity);
    }

    public List<TaskModel> getTaskByAssignee (String assignee){
        return taskRepository.getTaskByAssignee(assignee);
    }

    public List<TaskModel> getTasksByStoryPointAndDescription(int storyPoint,String description){
        return taskRepository.getTasksByStoryPointAndDescription(storyPoint,description);
    }

    public TaskModel updateTask (TaskDto taskDto){
        TaskModel existingTaskModel=taskRepository.findById(taskDto.getTaskId()).get();

        existingTaskModel.setAssignee(taskDto.getAssignee());
        existingTaskModel.setDescription(taskDto.getDescription());
        existingTaskModel.setSeverity(taskDto.getSeverity());
        existingTaskModel.setStoryPoint(taskDto.getStoryPoint());

        return taskRepository.save(existingTaskModel);
    }

    public String deleteTask(String taskId){
        taskRepository.deleteById(taskId);
        return taskId+" deleted the task";
    }
}
