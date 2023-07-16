package org.example.service;

import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id);
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            // Perform any additional updates or business logic
            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }

    public boolean deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id);
        if (existingTask != null) {
            taskRepository.delete(existingTask);
            return true;
        } else {
            return false;
        }
    }


}
