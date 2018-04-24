import java.io.IOException;
import java.io.RandomAccessFile;

public class PersonsData
{
  public RandomAccessFile file;

  public static final int AGE_SIZE = 4;
  public static final int HEIGHT_SIZE = 8;
  public static final int WEIGHT_SIZE = 8;
  public static final int RECORD_SIZE = AGE_SIZE+HEIGHT_SIZE+WEIGHT_SIZE;

  PersonsData()
  {
    file = null;
  }
  // open the file
  public void open(String filename) throws IOException
  {
    if (file != null)
    {
      // means file is open
      // then close it
      file.close();
    }
    else
    {
      // open new file with intention to read and write
      file = new RandomAccessFile(filename, "rw");
    }
  }
  public void close() throws IOException
  {
    if (file != null){file.close(); }
    file = null;
  }

  // get the total number of accounts = (size of file) / (# bytes per file)
  public int size() throws IOException
  {
    return (int) (file.length())/(RECORD_SIZE);
  }

  // get the i'th person in file (n * RECORD_SIZE)
  public Person read(int n) throws IOException
  {
    file.seek(n * RECORD_SIZE);
    int age = file.readInt();
    double height = file.readDouble();
    double weight = file.readDouble();
    return new Person(age, height, weight);
  }

  // find a person based on Person object
  public int find(Person p) throws IOException
  {
    for (int i=0; i<this.size(); i++)
    {
      // get the i'th object (same person if age, height, weight are same)
      file.seek(i*RECORD_SIZE);
      int an_age = file.readInt();
      double a_height = file.readDouble();
      double a_weight = file.readDouble();
      if(an_age == p.getAge() && a_height == p.getHeight() && a_weight == p.getWeight())
      {
        // return index of its location
        return i;
      }
    }
    return -1;
  }

  public void write(int index, Person p) throws IOException
  {
    file.seek(index * RECORD_SIZE);
    file.writeInt(p.getAge());
    file.writeDouble(p.getHeight());
    file.writeDouble(p.getWeight());
  }
}
