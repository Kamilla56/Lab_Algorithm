import java.util.Scanner;
class test_podstroka 
{ 
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    char [] T;
    String str1;
    String str2;
    char [] P;
    char [] W = {'J','K','C','M','X','A','I','L','Q','B','F','H','S'}; //своеобразный алфавит, состоящий из 13 букв и кем - то используемый:)
    int [] Q = {7, 8, 9, 10, 3, 5, 33, 15, 17, 20, 47, 2, 1};
    KN [] alp = new KN [13];
    for( int r = 0;r < alp.length; r++)
    { 
     alp[r] = new KN(W[r],Q[r]);
    }
    Podstroka method = new Podstroka(alp); //создаем объект, передаем алфавит
    System.out.println("Внимание! Вводите символы строки с учетом их принадлежности к алфавиту, который используется в данной программе");
    System.out.print("Введите строку");    //вводим строку и подстроку, преобразовываем их в массив символов
    str1 = sc.nextLine();
    System.out.print("Введите подстроку");
    str2 = sc.nextLine();
    T = str1.toCharArray();
    P = str2.toCharArray();
    method.Rabin_Karp(T,P);
  }
}
