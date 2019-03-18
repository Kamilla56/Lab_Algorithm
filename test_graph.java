import java.util.Scanner;
public class Graph{
  public static void main(String[] args){
 System.out.println("Сколько вершин будет в графе?");
 Scanner sc = new Scanner(System.in);
 int k = sc.nextInt();
 int[][] ar = new int[k][k];
 int[][] array = new int[k][k];
 int INF = Integer.MAX_VALUE / 2;
 System.out.println("Заполните матрицу расстояний до вершин"); // перед тем как вводить ,если INF , то вводим 50000(это число = бесконечность)
 for(int p=0;p<k;p++){
   for( int q=0;q<k;q++){
     System.out.println("(" + p + "," + q + ")" + ":");
     array[p][q] = sc.nextInt();
      }
 }
 for (int i = 0; i < k; i++) {
  for (int j = 0; j < k; j++) {
    if (array[i][j] == 50000) {
      array[i][j] = INF; 
    }
  }
}

 GraphNEW G = new GraphNEW(k,array,ar);
int o = G.mstPrim();
System.out.println(o);
G.dfs(0);
G.BFS(0);
G.dijkstra(0);  
G.floydWarshall(); 

}
}
