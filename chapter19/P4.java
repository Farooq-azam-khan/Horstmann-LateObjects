/**
P19.4
Playfair cipher. Another way of thwarting a simple letter frequency analysis of an
encrypted text is to encrypt pairs of letters together. A simple scheme to do this is
the Playfair cipher. You pick a keyword and remove duplicate letters from it. Then
you fill the keyword, and the remaining letters of the alphabet, into a 5 × 5 square.
(Because there are only 25 squares, I and J are considered the same letter.) Here is
such an arrangement with the keyword PLAYFAIR:
P L A Y F
I R B C D
E G H K M
N O Q S T
U V W X Z
To encrypt a letter pair, say AT, look at the rectangle with corners A and T:
P L A Y F
I R B C D
E G H K M
N O Q S T
U V W X Z
The encoding of this pair is formed by looking at the other two corners of the rectangle—
in this case, FQ. If both letters happen to be in the same row or column, such
as GO, simply swap the two letters. Decryption
is done in the same way.
Write a program that encrypts or decrypts an input text using this cipher. Use
command line arguments
as in Exercise P19.1.
*/
public class P4
{
  public static void main(String[] args)
  {

  }
}
