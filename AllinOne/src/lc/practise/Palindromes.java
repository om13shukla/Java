package lc.practise;
/**
 * All Palindromes solutions
 * @author oshukla
 *
 */
public class Palindromes {
  
  public boolean isIntegerPalindrome(int x) {
    if(x < 0 || (x != 0 && x % 10 == 0))
      return false;
    int rev = 0;
    while(x > rev) {
      rev = rev * 10 + x % 10;
      x = x / 10;
    }
    return (x == rev || x == rev / 10);
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
}
