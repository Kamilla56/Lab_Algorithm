import java.util.Scanner;
class test_BM
{ 
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    char [] T;
    String str1;
    String str2;
    str1 = sc.nextLine();
    str2 = sc.nextLine();
    char [] Q;
    char [] S;
    Q = str1.toCharArray();
    S = str2.toCharArray();
    BM n = new BM(Q, S, Q.length);
    n.help();
    n.function(0);
  }
}
