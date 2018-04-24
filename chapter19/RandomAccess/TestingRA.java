import java.io.RandomAccessFile;
import java.io.IOException;

public class TestingRA
{
  public static void main(String[] args) throws IOException
  {
    RandomAccessFile file = new RandomAccessFile("somedata.fak", "rw");
    long position = file.getFilePointer(); // get the current position in file
    System.out.println(position);
    file.seek(100); // go to the i'th position in file
    System.out.println(file.getFilePointer());

    // get the file size (number of bytes in file)
    System.out.println("R12: length: " + file.length());
    System.out.println("seeking: " + file.length()+1);
    file.seek(file.length()+1);
    System.out.println("length: " + file.length());
    System.out.println("(R12): conclusion, it doesnt let you"); 


    file.close();
  }
}
