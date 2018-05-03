/*
15.12
Repeat Exercise P15.11, but use a Map<Integer, Double> for the coefficients.
*/

import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class P12
{
  // TODO: implement polynomial multliply and add but with a map 
  public static void main(String[] args)
  {
    Term t1 = new Term(10.0, 10);
    Polynomial p = new Polynomial(t1);
    System.out.println(p);
  }

}


class Polynomial
{
  private Map<Integer, Double> terms = new TreeMap<Integer, Double>();
  Polynomial(Term term)
  {
    terms.put(term.getPow(), term.getCoeff());
  }

  public void add(Term t)
  {

  }

  public Polynomial multiply(Polynomial p)
  {
    Map<Integer, Double> ts = p.getTerms();
    Set<Integer> ts_set = ts.keySet();
    Set<Integer> terms_set = terms.keySet();


  }

  public Map<Integer, Double> getTerms()
  {
    return this.terms;
  }

  public String toString()
  {
    String ret = "";
    Set<Integer> pow_set = terms.keySet();
    for (Integer p : pow_set)
    {
      ret +=  "("+terms.get(p)+ ")x^("+p+") ";
    }
    return ret;
  }

}

class Term implements Comparable<Term>
{
  private Double coeff;
  private Integer pow;
  Term(Double coeff, Integer pow)
  {
    this.coeff = coeff;
    this.pow = pow;
  }

  public Integer getPow()
  {
    return this.pow;
  }
  public Double getCoeff()
  {
    return this.coeff;
  }
  public int compareTo(Term other)
  {
    if (this.pow > other.getPow()){return 1;}
    else if (this.pow < other.getPow()){ return -1;}
    else {return 0;}
  }
}
