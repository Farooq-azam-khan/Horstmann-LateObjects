/*
P8.16
Reimplement the CashRegister class so that it keeps track of the price
of each added item in an ArrayList<Double>.
Remove the itemCount and totalPrice instance variables.
Reimplement the clear, addItem, getTotal, and getCount methods. Add a method
displayAll that displays the prices of all items in the current sale.

P8.17 Reimplement the CashRegister class so that
it keeps track of the total price as an integer:
the total cents of the price.
For example, instead of storing 17.29, store the
integer 1729.
 Such an implementation is commonly used because it avoids the accumulation
of roundoff errors. Do not change the public interface of the class.

P8.18 After closing time, the store manager would like to know how much business was
transacted during the day. Modify the CashRegister class to enable this functionality.
Supply methods getSalesTotal and getSalesCount to get the total amount of all sales
and the number of sales. Supply a method resetSales that resets any counters and
totals so that the next day’s sales start from zero.


*/

import java.util.ArrayList;
public class P16P17P18
{
  public static void main(String[] args)
  {
    CashRegister c1 = new CashRegister();
    c1.addItem(20.2);
    c1.addItem(2.14);
    c1.addItem(1.1);
    CashRegister c2 = new CashRegister();
    c2.addItem(2.1);
    c2.addItem(3.1);
    c2.addItem(1100.99);
    System.out.println("total: " + c1.getTotal() + " items:" + c1.getCount());
    System.out.println("total (integer): " +  c1.getIntPrice());
    c1.clear();
    System.out.println("cleared: total: "
    + c1.getTotal() + " items:" + c1.getCount());
    System.out.println("end of day: ($)"
    + CashRegister.getSaleTotal()
    + " count: " + CashRegister.getSaleCount());

    CashRegister.resetSale();
    System.out.println("next day: ($)"
    + CashRegister.getSaleTotal() + " count: " + CashRegister.getSaleCount());

  }
}

class CashRegister
{
  private static Double saleTotal = 0.0;
  private static int saleCount = 0;
  private ArrayList<Double> prices;

  // constructor
  CashRegister()
  {
    prices = new ArrayList<Double>();
  }
  public void clear()
  {
    prices.clear();
  }
  public void addItem(Double price)
  {
    saleTotal += price;
    saleCount++;
    prices.add(price);
  }

  public Double getTotal()
  {
    Double total = 0.0;
    for(Double price : prices){total+= price;}
    return total;
  }
  public int getCount()
  {
    return prices.size();
  }

  public int getIntPrice()
  {
    int total = 0;
    for (Double price:prices)
    {
      total+= (int)(price * 100);
    }
    return total;
  }

  // static methods
  public static Double getSaleTotal()
  {
    return saleTotal;
  }
  public static int getSaleCount()
  {
    return saleCount;
  }
  public static void resetSale()
  {
    saleTotal = 0.0;
    saleCount = 0;
  }
}
