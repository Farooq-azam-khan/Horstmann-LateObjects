/*
Write a class Polynomial that stores a polynomial such as
p(x) = 5x10 + 9x7 − x − 10
as a linked list of terms. A term contains the coefficient and the power of x. For
example, you would store p(x) as
(5,10),(9,7),(−1,1),(−10,0)
Supply methods to add, multiply, and print polynomials. Supply a constructor that
makes a polynomial from a single term. For example, the polynomial p can be
constructed as
Polynomial p = new Polynomial(new Term(-10, 0));
p.add(new Polynomial(new Term(-1, 1)));
p.add(new Polynomial(new Term(9, 7)));
p.add(new Polynomial(new Term(5, 10)));
Then compute p(x) × p(x) .
Polynomial q = p.multiply(p);
q.print();
*/

import java.util.LinkedList;
import java.util.Collections;
import java.util.Stack;

public class P11
{
  public static void main(String[] args)
  {
    Polynomial p = new Polynomial(new Term(1, 1));
    p.add(new Polynomial(new Term(1, 0)));
    Polynomial q = p.multiply(p);
    System.out.println(p);
    System.out.println(q);
  }
}

class Polynomial
{
  LinkedList<Term> terms = new LinkedList<Term>();
  Polynomial(Term t)
  {
    terms.addFirst(t);

  }
  Polynomial(LinkedList<Term> terms)
  {
    this.terms = terms;
  }

  public void add(Polynomial p)
  {
    LinkedList<Term> p_ll = p.getLL();
    for (Term term : p_ll)
    {
      terms.addFirst(term);
    }
  }

  public static LinkedList<Term> simplify(LinkedList<Term> terms)
  {
    // TODO : make it so that terms with same exponent combine
    Collections.sort(terms);
    Stack<Term> sim_terms = new Stack<Term>();
    LinkedList<Term> result = new LinkedList<Term>();
    for (Term term : terms)
    {
      sim_terms.push(term);
    }

    while(!sim_terms.isEmpty())
    {
      Term element1 = sim_terms.pop();
      Term element2 = sim_terms.pop();
      if(element1.getPower() == element1.getPower())
      {
        result.add(Term.addTerms(element1, element2));
      }
      else
      {
        result.add(element1);
        result.add(element2);

      }

    }

    System.out.println("result: " + result);
    return result;
  }

  public Polynomial multiply(Polynomial mult_p)
  {
    // System.out.println("------- Multiplying -------");
    LinkedList<Term> mult_p_ll = mult_p.getLL();
    LinkedList<Term> result_ll = new LinkedList<Term>();
    // System.out.println("["+ this + "] * [" + mult_p + "]");
    for (Term term1 : terms)
    {
      for (Term term2 : mult_p_ll)
      {
        Term result = Term.multiplyTerms(term1, term2);
        result_ll.addFirst(result);
      }
    }
    return new Polynomial(result_ll);
  }

  public LinkedList<Term> getLL(){
    return this.terms;
  }
  public String toString()
  {
    String ret = "";
    int counter = 0;
    for (Term term : terms)
    {
      counter++;
      if (counter == 0)
      {
        ret+= term + " +";
      }
      else if (counter == terms.size())
      {
        ret += "" + term;
      }
      else
      {
        ret += term + " + ";
      }

    }
    return ret;
  }


}

class Term implements Comparable<Term>
{

  private Integer coeff;
  private Integer power;
  Term(Integer coeff, Integer power)
  {
    this.coeff = coeff;
    this.power = power;
  }

  // required: check if powers are equal before calling method
  public static Term addTerms(Term t1, Term t2)
  {
    return new Term(t1.getCoeff()+t2.getCoeff(), t1.getPower());
  }
  public static Term multiplyTerms(Term t1, Term t2)
  {
    Integer nc = t1.getCoeff() * t2.getCoeff();
    Integer np = t1.getPower() + t2.getPower();
    return new Term(nc, np);
  }

  public void setCoeff(Integer coeff){
    this.coeff = coeff;
  }
  public void setPower(Integer power){
    this.power = power;
  }
  public Integer getCoeff(){
    return this.coeff;
  }
  public Integer getPower(){return this.power;}

  public int compareTo(Term other)
  {
    if (this.power < other.getPower()) { return 1; }
    else if (this.power > other.getPower()) { return -1; }
    else { return 0; }
  }
  public String toString()
  {
    if (this.coeff == 1 && this.power == 0)
    {
      return "1";
    }
    else if (this.coeff==1 && this.power == 1)
    {
      return "x";
    }
    if (this.coeff==1)
    {
      return String.format("x^(%d)", this.power);
    }
    else if (this.coeff==0){
      return "";
    }
    if (this.power==1){
      return String.format("(%d)x", this.coeff);}
    else if (this.power==0){
      return String.format("%d", this.coeff);
    }

    return String.format("(%d)x^(%d)", this.coeff, this.power);
  }
}
