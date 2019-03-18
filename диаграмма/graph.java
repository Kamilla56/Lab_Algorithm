import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.io.PrintWriter;
import java.util.Scanner;
public class GraphNEW{
  int INF = Integer.MAX_VALUE / 2; // "Бесконечность" 
  int Num; // количество вершин 
  int[][] graph; // матрица смежности 
  int[][] ar;
  int result[] = new int [Num]; // для поиска в глубину
  boolean [] visit =  new boolean [Num]; // посещение вершин для поиска в глубину
  public GraphNEW(int Num,int [][] graph,int [][] ar){
    this.Num = Num;
    this.graph = graph;
    this.ar = ar;
  }
  int [][] gr = new int [Num][Num];
  /* Алгоритм Прима */ 
    
  int mstPrim() { 
   boolean[] used = new boolean [Num]; // массив пометок 
   int[] dist = new int [Num]; // массив расстояния. dist[v] = вес_ребра(MST, v) от дерева до вершины
 
   Arrays.fill(dist, INF); // устанаавливаем расстояние до всех вершин INF 
   dist[0] = 0; // для начальной вершины = 0 
 
   for (int k = 0 ;k < Num; k++) { 
     int v = -1; 
     for (int nv = 0; nv < Num; nv++) // перебираем вершины 
       if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv])) // выбираем самую близкую непомеченную вершину 
       v = nv; 
     if (v == -1) break; // ближайшая вершина не найдена 
     used[v] = true; // помечаем ее 
     for (int nv = 0; nv < Num; nv++) 
       if (!used[nv] && graph[v][nv] < INF) // для всех непомеченных вершин и смежных 
       dist[nv] = Math.min(dist[nv], graph[v][nv]); // улучшаем оценку расстояния
   } 
   int ret = 0; // вес MST 
   for (int v = 0; v < Num; v++) 
     ret += dist[v]; 
   return ret; 
  }
  public void BFS(int x1){ //поиск в ширину
    Integer u;
    Queue<Integer> myQueue = new LinkedList<>();
    boolean [] visit1 =  new boolean [Num];
    myQueue.add(x1);
    visit1[x1]=true;
    while (myQueue.poll()!= null){
      u = myQueue.poll();
      System.out.print(u + " ");
      for(int y1 = 0;y1 < Num; y1++){
        if(visit1[y1]==false && (graph[u][y1] != 0 && graph[u][y1] != INF) ){
          myQueue.add(y1);
          visit1[y1]=true;
        }
      }
    }
  }
  
void floydWarshall() { 
 int[][] f_dist = new int [Num][Num]; // dist[i][j] = минимальное_расстояние(i, j) 
 for (int i = 0; i < Num; i++) System.arraycopy(graph[i], 0, f_dist[i], 0, Num); 
 for (int k = 0; k < Num; k++) 
  for (int i = 0; i < Num; i++) 
 for (int j = 0; j < Num; j++) 
 f_dist[i][j] = Math.min(f_dist[i][j], f_dist[i][k] + f_dist[k][j]); 
 
for(int u = 0;u < Num; u++)
  for(int p = 0;p < Num; p++){
  if(p == Num-1){
    System.out.println(f_dist[u][p]);
  }
  else{
  System.out.print(f_dist[u][p] + " ");
  }
}
}
  
    void dijkstra(int start) {
         boolean[] used_d = new boolean [Num]; // массив пометок
         int[] d_dist = new int [Num]; // массив расстояния. dist[v] = минимальное_расстояние(start, v)
         
         Arrays.fill(d_dist, INF); // устанаавливаем расстояние до всех вершин INF
        d_dist[start] = 0; // для начальной вершины положим 0
         
         for (int t=0;t < Num;t++) {
             int d = -1;
             for (int dv = 0; dv < Num; dv++) // перебираем вершины
                 if (!used_d[dv] && d_dist[dv] < INF && (d == -1 || d_dist[d] > d_dist[dv])) // выбираем самую близкую непомеченную вершину
                     d = dv;
             if (d == -1) break; // ближайшая вершина не найдена
             used_d[d] = true; // помечаем ее
             for (int dv = 0; dv < Num; dv++)
                 if (!used_d[dv] && graph[d][dv] < INF) // для всех непомеченных смежных
                     d_dist[dv] = Math.min(d_dist[dv], d_dist[d] + graph[d][dv]); // улучшаем оценку расстояния (релаксация)
         }
         System.out.println();
         for(int h = 0; h < Num; h++) {
           System.out.println(d_dist[h]);
           
     }
}

public void dfs(int pos) {
  visit[pos] = true;
    System.out.println(pos);
    for (int next1 = 0; next1 < Num; next1 ++){
      for (int next = 0; next < Num; next ++){
        if (!visit[next] && (graph[next1][next]!=0 && graph[next1][next]!=INF)){
            dfs(next);
        }
    }
}
    }
}
