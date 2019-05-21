import java.util.ArrayList;
public class BM
{ char [] S;
  char [] Q;
  int g = 0;
  public BM(char [] Q, char [] S, int g)
  {
    this.Q = Q;
    this.S = S;
    this.g = g;
  }
  KN [] mass = new KN [g];
  public void help(){
  for(int i = 0;i < Q.length;i++)
{
    
    if(i == Q.length-1)
    {
      mass[i] = new KN(Q[i],Q.length);
    }
    else
    {
      mass[i]= new KN(Q[i],Q.length - 1 - i);
    }
  }
  }

public void function(int l)
{
  int x = Q.length - 1;
  int y = S.length - 1 + l;
  int h = S.length - 1 + l;
  while(Q[x]!=S[y])
  {
    x--;
    y--;
  }
  if(x == Q.length - 1)
  {
  function2(S[y]);
  }
  else
  {
    function2(Q[Q.length - 1]);
  }
}
 public void function2(char e)
  {
   int u = 0;
    for(int k = 0; k < mass.length; k++)
    {
      if(mass[k].simbol == e)
      {
        u = mass[k].number;
        break;
      }
    }
    function(u);
    
 }
  }
