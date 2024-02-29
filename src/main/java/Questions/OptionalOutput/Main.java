package Questions.OptionalOutput;

import java.util.Optional;

class Room {
    Integer number;
    Optional<Integer> getNumber() {
        return Optional.of(number);
    }
}

class Course {
    public Course() {
    }

    Room room;

    Optional<Room> getRoom() {
        return Optional.of(room);
    }
}

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Course c = new Course();
        Integer number = c.getRoom().flatMap(Room::getNumber).orElse(42);
        System.out.println(number);
    }
}
