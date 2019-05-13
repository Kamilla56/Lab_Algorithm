import java.util.ArrayList;
public class Podstroka{
  int d = 13; // размер алфавита
  int q = 7; //простое число
  KN [] alpha;
  public Podstroka(KN [] alpha) //будем использовать алфавит в методах, поэтому передадим его сразу с помощью конструктора
  {
    this.alpha = alpha;
  }
  private int simbol_in_alphabet(char p)
  { 
    int c = 0;
    for (int j = 0; j < alpha.length; j++)
    {
      if(alpha[j].simbol == p)
      {
        c = alpha[j].number;
      }
    }
    return c;
  }
  public void Rabin_Karp( char [] T,char [] P)
  {
    int n = T.length;
    int m = P.length;
    int g = 0;
     ArrayList <Integer> result = new ArrayList<>();
    int f_f = (int)(Math.pow(d,(m-1))) % q;
    int h1 = 0;
    int h2 = 0;
    for(int i=0; i < m-1; i++)
    {
      h1 = ((d * h1) + simbol_in_alphabet(P[i]))%q;
      h2 = ((d * h2) + simbol_in_alphabet(T[i]))%q;
    }
    for(int s = 0; s < n - m; s++)
    {
      if(h1 == h2)
      {
        for(int y = s; y < s + m; y++) 
        {
          if(P[g] == T[y])
          {
           g++;
           if(y == s + m - 1)
           {
           result.add(s);
           }
          }
          else
          {
            break;
          }
       }
      }
    
      if(s < n - m)
      {
        h2 = d * (h2 - f_f * (T[s+1])) + T[s + m - 1]%q;
      }
    }
      for(int u = 0; u < result.size(); u++)
    {
     System.out.print(result.get(u));
    }
    
  }
}
