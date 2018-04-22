import java.util.ArrayList;

public class RandomMonoalphabetCipher
{
  // arraylist maps encryption
  private ArrayList<String> encrypted_letters = new ArrayList<String>();
  String key;
  private static final int BASE = 'a';
  private static final int LETTERS = 26;

  public RandomMonoalphabetCipher(String key)
  {
    this.key = removeDuplicateLetters(key);
    // System.out.println("key: " + this.key);
    this.generateEncryptionArray();
  }
  public String decrypt(String message)
  {
    String decrypted_message = "";
    for (int i=0; i<message.length(); i++)
    {
      String encrypted_letter = String.valueOf(message.charAt(i));
      decrypted_message += String.valueOf((char)(encrypted_letters.indexOf(encrypted_letter) + BASE));
    }
    return decrypted_message;
  }
  public String encrypt(String message)
  {
    String encrypted_message = "";
    for(int i=0; i<message.length(); i++)
    {
      char letter_message = message.charAt(i);
      encrypted_message += encrypted_letters.get((int)(letter_message-BASE));
    }
    return encrypted_message;
  }

  private String removeDuplicateLetters(String key)
  {
    String ret = "";
    for(int i=0; i<key.length(); i++)
    {
      String let = String.valueOf(key.charAt(i));
      if (ret.contains(let))
      {
        continue;
      }
      else
      {
        ret += String.valueOf(key.charAt(i));
      }
    }
    return ret;
  }

  private void generateEncryptionArray()
  {
    // add key to arraylist
    for (int i=0; i<key.length(); i++)
    {
      encrypted_letters.add(String.valueOf(key.charAt(i)));
    }

    // add letters backwards
    for(int i=LETTERS-1; i>=0; i--)
    {
      String letter = String.valueOf((char)(i+BASE));
      if (key.contains(letter))
      {
        continue;
      }
      else
      {
        encrypted_letters.add(letter);
      }
    }
  }
}
