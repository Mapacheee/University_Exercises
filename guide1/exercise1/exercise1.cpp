#include <iostream>
#include <utility>

using namespace std;

class Flight {

  private:
    int flightNumber;
    int flightCapacity;
    string origin;
    string destiny;
    string date;

  public:
    Flight(const int flightNumber, const int flightCapacity, string  origin,
          string  destiny, string  date) : flightNumber(flightNumber), flightCapacity(flightCapacity),
          origin(move(origin)), destiny(move(destiny)), date(move(date)) {}

    int getFlightNumber() const { return flightNumber; }
    string getOrigin() const { return origin; }

    bool isAvailable() const {
      return (flightCapacity > 0) ? true : false;
    }

};

class Passenger {

  private:
    string name;
    string rut;
    string email;

  public:
    Passenger(string name, string rut, string email) : name(move(name)),
             rut(move(rut)), email(move(email)) {}

    string getName() const { return name; }
    string getRut() const { return rut; }
    string getEmail() const { return email; }
};

int main() {

  // ill finish this tomorrow
  return 0;
}