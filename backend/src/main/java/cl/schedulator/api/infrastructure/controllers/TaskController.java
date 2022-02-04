package cl.schedulator.api.infrastructure.controllers;

import cl.schedulator.api.domain.entities.DailyTask;
import cl.schedulator.api.domain.entities.Task;
import cl.schedulator.api.domain.entities.TaskSummary;
import cl.schedulator.api.usecases.TaskOptimizer;
import cl.schedulator.api.usecases.TasksLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class TaskController {
    private final String baseUrl = "http://localhost:8080";
    private List<Task> tasks = new ArrayList<>();

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/tasks", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getTasks() {
        String uri = "/generator/schedule/tasks";
        TasksLoader loader = new TasksLoader(baseUrl, uri);
        tasks = loader.getTasks();
        TaskSummary summary =  TaskOptimizer.createOptimizer(tasks).optimizeTaskDistribution();
        return ResponseEntity.ok(summary);
    }

}
