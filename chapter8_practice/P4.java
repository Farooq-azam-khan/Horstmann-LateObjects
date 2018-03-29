/*
P8.4 Implement a class Address. An address has a house number,
a street, an optional apartment number, a city, a state, and a postal code.
Supply two constructors: one with an apartment number and one without.
Supply a print method that prints the address with the street on one
line and the city, state, and zip code on the next line.
Supply a method public boolean comesBefore(Address other)
that tests whether this address comes before another when
the addresses are compared by postal code.
*/

public class P4
{
  public static void main(String[] args)
  {
    Address ad1 = new Address("sussex rd", "ottawa", "ON", "G543N0");
    Address ad2 = new Address(3154, "penselvania avnue", "washigton", "DC", "TRZ290");

    System.out.println(ad1.comesBefore(ad2));

  }
}

class Address
{
  private int houseNum;
  private String streeAddress;
  private int appNum;
  private String city;
  private String state;
  private String postalcode;

  public Address(int appNum, String streetAddress, String city,String state,String postalcode)
  {
    this.appNum = appNum;
    this.streeAddress = streeAddress;
    this.city = city;
    this.state = state;
    this.postalcode = postalcode;

  }
  public Address(String streetAddress,String city,String state,String postalcode)
  {
    this.streeAddress =streetAddress;
    this.city = city;
    this.state = state;
    this.postalcode = postalcode;

  }
  public boolean comesBefore(Address other)
  {
    return 1==this.postalcode.compareTo(other.postalcode);
  }
  public String getPostalCode()
  {
    return this.postalcode;
  }
  public String print()
  {
    return streeAddress+"\n"+city+""+postalcode+""+state;
  }
}
