public class CashRegisterTester
{
  public static void main(String[] args)
  {
    CashRegister customer1 = new CashRegister();
    customer1.addItem(20.0);
    customer1.addItem(5.5);
    System.out.println("cust1: ($) " + customer1.getPrice() + " amount: " + customer1.getItems());
    System.out.println("Get dollar method: ($)" + customer1.getDollar());
  }
}

class CashRegister
{
  private double price; // total price
  private int num_items; // num of items in register

  // constructor
  CashRegister()
  {
    // initialize
    price = 0;
    num_items = 0;
  }

  /**
    @param price of item
  */
  public void addItem(double item_price)
  {
    price+=item_price; // add price
    num_items++;       // increment counter
  }

  /**
  @return total price
  */
  public double getPrice()
  {
    return price;
  }

  /**
  @return num of items
  */
  public int getItems()
  {
    return num_items;
  }
  /**
  clear cashregister
  */
  public void clear()
  {
    num_items = 0;
    price = 0.0;
  }

  /**
  @return in of price var
  */
  public int getDollar()
  {
    return (int)price;
  }
}
