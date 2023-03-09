package com.javatechie.repository;
import java.util.List;
import com.javatechie.model.TaskModel;
import org.springframework.data.mongodb.core.messaging.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<TaskModel,String> {
    List<TaskModel> findBySeverity(int severity);
    @Query("{assignee: ?0 }")
    List<TaskModel> getTaskByAssignee(String assignee);
    @Query("{storyPoint: ?0 ,description: ?1}")
    List<TaskModel> getTasksByStoryPointAndDescription(int storyPoint, String description);
}
