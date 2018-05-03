/*
P8.6
Implement a class Car with the following properties. A car has a certain
fuel efficiency (measured in miles/gallon) and a certain amount of fuel
in the gas tank. The efficiency is specified in the constructor, and the
initial fuel level is 0. Supply a method drive that simulates driving the
car for a certain distance, reducing the fuel level in the gas tank, and methods getGas-
Level, to return the current fuel level, and addGas, to tank up.

*/
public class P6
{
  public static void main(String[] args)
  {
    Car myHybrid = new Car(50.0); // 50 miles per gallon
    System.out.println(myHybrid.getGasLevel()); // Print fuel remaining
    myHybrid.addGas(20.0); // Tank 20 gallons
    System.out.println(myHybrid.getGasLevel()); // Print fuel remaining
    myHybrid.drive(100.0); // Drive 100 miles
    System.out.println(myHybrid.getGasLevel()); // Print fuel remaining
  } // end of main method

} // end of p8 class

class Car
{
  private double fuel_efficiency; // miles/gallon
  private double fuel; // gallon
  public Car(double fuel_efficiency)
  {
    this.fuel_efficiency = fuel_efficiency;
    this.fuel = 0;
  } // end of constructor method

  public void drive(double distance) // miles
  {
    this.fuel -= distance / this.fuel_efficiency; // gallons
  } // end of drive method

  public double getGasLevel()
  {
    return this.fuel;
  } // end of getGasLevel method

  public void addGas(double fuel)
  {
    this.fuel+=fuel;
  } // end of addGas method
} // end of Car class
