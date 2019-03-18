import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
public class Method{
  ArrayList<Rebro> n = new ArrayList<>();
  ArrayList<Rebro> RESULT = new ArrayList<>();
  ArrayList<Integer> Result = new ArrayList<>(); //вершины, последовательность
  boolean [] visit = new boolean [20];
  ArrayList<Integer> Stack = new ArrayList<>(); // последовательность вершин 
  ArrayList<Integer> result = new ArrayList<>();
  public void MethodAdd(Rebro u){
    n.add(u);
  }
  public void Alg_Kruskala(){    //Крускала 
    ArrayList<Integer> mV = new ArrayList<>();; //вершины
    int R=0; // rebra
    int resW = 0;//результат веса дерева
    Collections.sort(n);
    for (int r = 0; r < n.size(); r++){
      if(mV.indexOf(n.get(r).x) == -1){
        mV.add(n.get(r).x);
    }
      if(mV.indexOf(n.get(r).y) == -1){
        mV.add(n.get(r).y);
    }
      R++;
      if(R == mV.size()){
        R--;
        continue;
      }
      else{
        resW += n.get(r).w;
      }
    }
    
      System.out.println(resW);
}
  
  public void dfs_inv(int c){ //для G^T
    visit[c] = true;
    for(int e = 0;e < n.size(); e++){
      if(n.get(e).y == c && visit[n.get(e).x] == false){
        dfs_inv(n.get(e).x);
      }
    }
    Stack.add(c);
  }
  public void Kosarayu(){ //для G
   Tarjana();
   printStack();
    for(int i = 0; i < visit.length; i++){
      visit[i] = false;
    }
    while(Stack.size()!=0){
      for(int z = (Stack.size()-1);z >= 0;z--){
      int g = Stack.get(z);
      Stack.remove(z);
      if(visit[g] == false){
        dfs(g);
      }
    }
  }
  }
      
  public void printStack(){
    for(int d = 0; d < Stack.size();d ++){
      System.out.print(Stack.get(d) + " ");
    }
    System.out.println();
}

  public void dfs(int pos) { 
  visit[pos] = true;
  System.out.print(pos + " ");
    for (int next = 0; next < n.size() ; next ++){
        if (n.get(next).x == pos && visit[n.get(next).y] == false){
            dfs(n.get(next).y);
        }
    }
   }
  public void Tarjana(){
     for (int k = 0;k < n.size();k++){
      if(visit[n.get(k).y] == false){
      dfs_inv(n.get(k).y);
      }
    }
  }
}
