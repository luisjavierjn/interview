import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

enum MyEnum {
    PRIMERO,
    SEGUNDO
}

class DelayObject implements Delayed {

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}

class Persona implements Comparable<Persona> {
    private int id;
    private String nombre;

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Persona otraPersona) {
        return Integer.compare(this.id, otraPersona.id);
    }

    @Override
    public String toString() {
        return "Persona{id=" + id + ", nombre='" + nombre + "'}";
    }
}

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello world!");

        /* List */
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        Stack<String> stack = new Stack<>();
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        /* Set */
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHasSet = new LinkedHashSet<>();
        SortedSet<String> treeSet = new TreeSet<>();
        Set<MyEnum> enumSet = EnumSet.allOf(MyEnum.class);
        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        /* Queue */
        Queue<String> linkedListQueue = new LinkedList<>();
        Queue<String> priorityQueue = new PriorityQueue<>();
        BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(10);
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        Deque<String> deque = new ArrayDeque<>();
        BlockingDeque<String> arrayBlockingDeque = new LinkedBlockingDeque<>(10);
        BlockingQueue<DelayObject> delayQueue = new DelayQueue<>();
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        /* Map */
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        Map<MyEnum, String> enumMap = new EnumMap<>(MyEnum.class);
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        WeakHashMap<String, Integer> weakHashMap = new WeakHashMap<>();
        IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<>();



        /* Unmodifiable List */
        /* https://www.techiedelight.com/unmodifiable-map-java/ */
        String[] lang = new String[] { "C", "C++", "Java" };
        List<String> fixedLengthList = Arrays.asList(lang);
        //
        List<String> mutableList = new ArrayList<>(Arrays.asList("C", "C++", "Java"));
        List<String> unmodifiableList = Collections.unmodifiableList(mutableList);
        //
        List<String> mutableListColl = new ArrayList<>(Arrays.asList("C", "C++", "Java"));
        Collection<String> unmodifiableColl = Collections.unmodifiableCollection(mutableListColl);

        /* Unmodifiable List */
        Set<String> mutableSet = new HashSet<>(Arrays.asList("C", "C++", "Java"));
        Set<String> unmodifiableSet = Collections.unmodifiableSet(mutableSet);
        //
        Set<String> mutableSetColl = new HashSet<>(Arrays.asList("C", "C++", "Java"));
        Collection<String> unmodifiableSetColl = Collections.unmodifiableCollection(mutableSetColl);

        /* Unmodifiable Map */
        Map<String, String> mutableMap = new HashMap<>();
        mutableMap.put("United States", "Washington D.C.");
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(mutableMap);


        /* Synchronized Java Collections */
        /* https://www.baeldung.com/java-synchronized-collections */
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        List<Integer> syncArrayList = Collections.synchronizedList(new ArrayList<>());
        List<Integer> syncLinkedList = Collections.synchronizedList(new LinkedList<>());
        Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        Map<Integer, String> syncSortedMap = Collections.synchronizedSortedMap(new TreeMap<>());
        Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
        SortedSet<Integer> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());

        // init collections in one line // https://www.baeldung.com/java-init-list-one-line
        // métodos de stream
        // métodos de collection
        // future and complateableFuture
        // threads and runnable
        // Map.of / list.of ...
        // order complexity

        // synchronized keyword
        // ---
        // ReentrantLock
        // ReentrantReadWriteLock
        // StampedLock
        // Condition
        // CountDownLatch
        // Phaser
        // CyclicBarrier
        // ---
        // ThreadLocal (thread confinement, thread-local storage)
        // immutable objects
        // ConcurrentHashMap, ConcurrentLinkedQueue...
        // AtomicInteger..., volatile keyword

/*
        // Crear un PriorityQueue de Personas
        PriorityQueue<Persona> colaPrioridad = new PriorityQueue<>();

        // Agregar personas a la cola de prioridad
        colaPrioridad.add(new Persona(103, "María"));
        colaPrioridad.add(new Persona(101, "Juan"));
        colaPrioridad.add(new Persona(102, "Pedro"));

        // Mostrar las personas en orden de prioridad (por su ID)
        System.out.println("Personas en orden de prioridad:");
        while (!colaPrioridad.isEmpty()) {
            System.out.println(colaPrioridad.poll());
        }
 */

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
    private String name;
    private int delay;

    public Request(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
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