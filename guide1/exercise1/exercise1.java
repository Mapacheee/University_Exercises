public class Main {

    static class Flight {
        private int flightNumber;
        private int flightCapacity;
        private String origin;
        private String destiny;
        private String date;

        public Flight(int flightNumber, int flightCapacity,
                     String origin, String destiny, String date) {

            this.flightNumber = flightNumber;
            this.flightCapacity = flightCapacity;
            this.origin = origin;
            this.destiny = destiny;
            this.date = date;

        }

        public int getFlightNumber() {
            return flightNumber;
        }

        public String getOrigin() {
            return origin;
        }

        public boolean isAvailable() {
            return flightCapacity > 0;
        }
    }

    static class Passenger {
        private String name;
        private String rut;
        private String email;

        public Passenger(String name, String rut, String email) {
            this.name = name;
            this.rut = rut;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getRut() {
            return rut;
        }

        public String getEmail() {
            return email;
        }
    }

    public static void main(String[] args) {

    }
}
