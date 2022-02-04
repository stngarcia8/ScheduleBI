package cl.schedulator.api.usecases;

import cl.schedulator.api.configuration.WebClientConfiguration;
import cl.schedulator.api.domain.entities.Task;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Garcia
 * Description Load tasks from http://localhost:8080/generator/schedule/tasks
 */
public class TasksLoader {
    private WebClient webClient;
    private List<Task> tasks;
    private final String baseUrl;
    private final String uri;

    public TasksLoader(String baseUrl, String uri) {
        this.baseUrl = baseUrl;
        this.uri = uri;
        this.configureWebClient();
        this.loadTasks();
    }

    private void configureWebClient() {
        webClient = WebClientConfiguration.configureClient(baseUrl, uri)
                .createClient();
    }

    private void loadTasks() {
        Flux<Task> taskFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Task.class);
        tasks = taskFlux.collectList().block();
    }

    public List<Task> getTasks() {
        if (tasks == null) return new ArrayList<>();
        return this.tasks;
    }

    @Override
    public String toString() {
        return "Tasks found: " + tasks.size();
    }

}
