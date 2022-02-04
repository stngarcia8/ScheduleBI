package cl.schedulator.api.usecases;

import cl.schedulator.api.configuration.WebClientConfiguration;
import cl.schedulator.api.domain.entities.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
        log.info("Configure web client.");
        webClient = WebClientConfiguration.configureClient(baseUrl, uri)
                .createClient();
    }

    private void loadTasks()   {
        log.info("Loading task from microservice.");
        Flux<Task> taskFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Task.class);
        tasks = taskFlux.collectList().block();
        log.info("Tas was loaded.");
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
