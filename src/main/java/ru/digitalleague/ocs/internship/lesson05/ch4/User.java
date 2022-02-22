package ru.digitalleague.ocs.internship.lesson05.ch4;

public class User {

    private static int aaa = 1;

    String name;
    Status status;
    Position position;
    double track;

    public User(String name, Status status, double x, double y) {
        this.name = name;
        this.status = status;
        this.position = new Position(x, y);
        track = 0;
    }

    public User.Position getPosition() {
        return position;
    }

    public void moveTo(double x, double y) {
        class DistanceCalculator {
            public double calculateDistance(Position p1, Position p2) {
                return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
            }
        }
        DistanceCalculator calculator = new DistanceCalculator();
        Position newPosition = new Position(x, y);
        track += calculator.calculateDistance(position, newPosition);
        position = newPosition;
    }

    static class Status {

        public static final Status ACTIVE = new Status("active");
        public static final Status BLOCKED = new Status("blocked");

        String name;

        private Status(String name) {
            System.out.println(aaa);
            this.name = name;
        }

        static void print(String s) {
            System.out.println(s);
        }
    }

    class Position {
        double x;
        double y;

        public Position(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position for user " + User.this.name + ": (" + x + ", " + y + ")";
        }
    }
}
