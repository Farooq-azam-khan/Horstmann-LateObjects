public class Country
{
  long population;
  String name;
  int area;

  public Country(String name, long population, int area)
  {
    this.name = name;
    this.population = population;
    this.area = area;
  }
  public int getArea(){return this.area;}
  public long getPopulation()
  {
    return this.population;
  }

  public String toString()
  {
    return String.format("%s [name: %s, pop: %d area: %d]", getClass().getName(), name, population, area);
  }
}
