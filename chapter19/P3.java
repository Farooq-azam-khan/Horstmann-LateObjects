/**
P19.3 Vigenère cipher. The trouble with a monoalphabetic cipher
is that it can be easily broken by frequency analysis.
The so-called Vigenère cipher overcomes this problem by encoding a
letter into one of several cipher letters, depending on its position in the
input document. Choose a keyword, for example TIGER. Then encode the first
letter of the input text.
That is, the encoded alphabet is just the regular alphabet shifted to start at T,
the first letter of the keyword TIGER.
The second letter is encrypted according to this map.
The third, fourth, and fifth letters in the input text are encrypted using the alphabet
sequences beginning with characters G, E, and R.
Because the key is only five letters long,
the sixth letter of the input text is encrypted in the same way as the first.
Write a program that encrypts or decrypts an input text using this cipher.
Use command line arguments as in Exercise P19.1.
*/
public class P3
{
  public static void main(String[] args)
  {
    VigenereCipher cipher = new VigenereCipher("tiger");
    System.out.println(cipher.encrypt("hello world"));
    System.out.println(cipher.decrypt("amrpf pwxpu"));


  }
}

class VigenereCipher
{
  private String key;
  private static final int LETTERS = 26;
  public VigenereCipher(String key)
  {
    this.key = key;
  }

  public String encrypt(String msg)
  {
    String encrypted_msg = "";

    int key_counter = 0; // amount of times characters have to be encrypted
    for (int i=0; i< msg.length(); i++)
    {
      char ch = msg.charAt(i);
      char base;
      char key_ch = key.charAt(key_counter%key.length()); // get the character for encryption

      if (ch >= 'a' && ch <= 'z')
      {
        base = 'a';
        encrypted_msg += getEncryptedLetter(base, key_ch, ch);
        key_counter++; // (does not account for non-alphabetical chars)
      }
      else if (ch >= 'A' && ch <= 'Z')
      {
        base = 'A';
        // capitalize key_ch
        key_ch = String.valueOf(key_ch).toUpperCase().charAt(0);
        encrypted_msg += getEncryptedLetter(base, key_ch, ch);
        key_counter++;
      }
      else
      {
        encrypted_msg += String.valueOf(ch);
      }

    }

    return encrypted_msg;
  }

  public String decrypt(String msg)
  {
    String decrypted_msg = "";

    int key_counter = 0; // amount of times characters have to be encrypted
    for (int i=0; i< msg.length(); i++)
    {
      char ch = msg.charAt(i);
      char base;
      char key_ch = key.charAt(key_counter%key.length()); // get the character for encryption

      System.out.print("ch: " + ch + " key_ch: " + key_ch + " ");
      if (ch >= 'a' && ch <= 'z')
      {
        base = 'a';
        decrypted_msg += getDecryptedLetter(base, key_ch, ch);
        key_counter++; // (does not account for non-alphabetical chars)
      }
      else if (ch >= 'A' && ch <= 'Z')
      {
        base = 'A';
        // capitalize key_ch
        key_ch = String.valueOf(key_ch).toUpperCase().charAt(0);
        decrypted_msg += getDecryptedLetter(base, key_ch, ch);
        key_counter++;
      }
      else
      {
        decrypted_msg += String.valueOf(ch);

        System.out.println("");
      }

    }

    return decrypted_msg;
  }

  private String getEncryptedLetter(char base, char key_ch, char ch)
  {
    int char_index = ch - base;
    int key_index = key_ch - base;
    int encrypted_index = (char_index + key_index)%LETTERS;
    char encrypted_char = (char)((encrypted_index)+base);
    return String.valueOf(encrypted_char);

  }
  private String getDecryptedLetter(char base, char key_ch, char ch)
  {
    // TODO : FIX DECRYPTION 
    int char_index = ch - base;
    int key_index = key_ch - base;

    System.out.println("char_indx: " + char_index + " key_indx: " + key_index);
    int decrypted_index = (Math.abs(char_index - key_index))%LETTERS;
    char decrypted_char = (char)((decrypted_index)+base);
    return String.valueOf(decrypted_char);
  }
}
