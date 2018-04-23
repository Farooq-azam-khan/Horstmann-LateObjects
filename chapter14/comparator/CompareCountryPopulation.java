import java.util.Comparator;

public class CompareCountryPopulation implements Comparator<Country>
{
  public int compare(Country a, Country b)
  {
    if (a.getPopulation() == b.getPopulation()){return 0;}
    else if(a.getPopulation()>b.getPopulation()){return -1;}
    else{return 1;}
    // return (int)(a.getPopulation() - b.getPopulation());
  }

}
