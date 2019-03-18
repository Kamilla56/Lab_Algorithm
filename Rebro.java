public class Rebro implements Comparable <Rebro>{
  int x;
  int y;
  int w;

public Rebro(int x, int y, int w){
  this.x = x;
  this.y = y;
  this.w = w;
}
public int compareTo(Rebro p){
  if(this.w < p.getW()) return -1;
  if(this.w == p.getW()) return 0;
  else return 1;
  
}
public int getW(){
  return w;
}
}
