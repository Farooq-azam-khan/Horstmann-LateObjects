import java.util.ArrayList;
import java.util.Arrays;

public class CountryTester
{
  public static void main(String[] args)
  {
    ArrayList<Country> countries = new ArrayList<Country>();
    countries.add(new Country("us", 1, 50));
    countries.add(new Country("Canada", 2, 49));
    countries.add(new Country("Pakistan", 3, 48));
    countries.add(new Country("Russia", 4, 47));
    countries.add(new Country("England", 5, 46));

    System.out.println(countries);

    System.out.println("sorted by population");
    countries.sort(new CompareCountryPopulation());
    for (Country country: countries)
    {
      System.out.println(country);
    }

    System.out.println("soretedby area: "); 
    countries.sort(new CompareCountryAreaComparator());
    for (Country country: countries)
    {
      System.out.println(country);
    }
  }
}
