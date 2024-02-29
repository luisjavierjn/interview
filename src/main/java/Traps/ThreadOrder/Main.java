package Traps.ThreadOrder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// What's the output? is there an order?
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Request[] requests = {
                new Request("Luis A", 100),
                new Request("Jose B", 300),
                new Request("Manu C", 200)
        };

        for (Request req : requests) {
            String name = RequestProcessor.getInstance().check(req).get();
            System.out.println(name);
        }
        System.out.println("End of the process");
    }
}

class Request {
    private final String name;
    private final int delay;

    public Request(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public String getName() {
        return name;
    }

    public int getDelay() {
        return delay;
    }
}

class RequestProcessor {
    private RequestProcessor() {}
    private static RequestProcessor _instance;
    public static RequestProcessor getInstance() {
        if (_instance == null) {
            _instance = new RequestProcessor();
        }
        return _instance;
    }
    private ExecutorService executor = Executors.newFixedThreadPool(5);
    Future<String> check(Request req) {
        return executor.submit(() -> {
            try {
                Thread.sleep(req.getDelay());
                return "Processed request: " + req.getName();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Failed to process request: " + req.getName();
            }
        });
    }
}