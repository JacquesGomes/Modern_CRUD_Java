package org.example.repository;

import org.example.model.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Task> findAll(){
        TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM " +
                "Task t", Task.class);
        return query.getResultList();
    }

    public Task save(Task task){
        if(task.getId() == null){
            entityManager.persist(task);
            return task;
        }
        else{
            return entityManager.merge(task);
        }
    }

    public Task findById(Long id){
        return entityManager.find(Task.class, id);
    }

    public void delete(Task task){
        entityManager.remove(task);
    }






}
