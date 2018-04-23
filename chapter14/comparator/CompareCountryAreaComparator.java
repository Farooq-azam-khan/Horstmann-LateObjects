import java.util.Comparator;

public class CompareCountryAreaComparator implements Comparator<Country>
{
  public int compare(Country a, Country b)
  {
    if (a.getArea() < b.getArea()){return 1;}
    else if (a.getArea()>b.getArea()){return -1;}
    else {return 0;}
  }
}
