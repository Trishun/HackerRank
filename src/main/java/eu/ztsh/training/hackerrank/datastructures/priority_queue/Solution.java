package eu.ztsh.training.hackerrank.datastructures.priority_queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Priorities {

    List<Student> getStudents(List<String> events) {
        var queue = new PriorityQueue<>(events.size(),
                Comparator.comparingDouble(Student::getCGPA)
                        .reversed() // CGPA is the only descending here
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getID));
        events.forEach(event -> {
            var line = event.split(" ");
            switch (line[0]) {
                case "ENTER" ->
                        queue.add(new Student(Integer.parseInt(line[3]), line[1], Double.parseDouble(line[2])));
                case "SERVED" -> queue.poll();
                default -> throw new IllegalArgumentException();
            }
        });
        return Stream.generate(queue::poll).takeWhile(Objects::nonNull).collect(Collectors.toList());
    }

}

class Student {

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCGPA() {
        return cgpa;
    }

    private final int id;
    private final String name;
    private final double cgpa;

}

// https://www.hackerrank.com/challenges/java-priority-queue/problem
public class Solution {

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
    private static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

}
