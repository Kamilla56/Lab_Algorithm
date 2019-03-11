import java.util.ArrayList;
class PriorQueue <E extends Comparable<E>> {
        E data;
        ArrayList<E> a = new ArrayList<>();
        int size;
     
      void up() { //поднимаем вверх
        int y = a.size()-1;
      int res = a.get(y).compareTo((E)a.get((y-1)/2));
        while (res > 0) {
            E u = (E)a.get(y);
            a.set(y,a.get((y-1)/2));
            a.set((y-1)/2,u);
            y = (y - 1) / 2;
            res = a.get(y).compareTo((E)a.get((y-1)/2));
        }
    }

    void down() { //просеиваем вниз
      int i = 0;
        while (i < a.size() / 2) {
            int maxI = 2 * i + 1;
            if (2 * i + 2 < a.size()){
              int result = a.get(2 * i + 2).compareTo(a.get(2 * i + 1));
              if(result > 0){
                maxI = 2 * i + 2;
              }
            }
            int nb = a.get(i).compareTo(a.get(maxI));
            if (nb > 0 || nb == 0)
                return;
            else{
              E w = (E)a.get(i);
            a.set(i,a.get(maxI));
            a.set(maxI,w);
            i = maxI;
        }
    }
   }

    void add(E data) {
        a.add(data);
        up();
    }

    void print_remove() {
        assert(a.size() > 0);
        System.out.println(a.get(0));
        a.set(0,a.get(a.size()-1));
        a.remove(a.size()-1);
        down();
     }

    int sizeQ() { //количество элементов в очереди
        return a.size();
    }
    void printQ(){
      for(int i = 0; i < a.size();i++){
        System.out.print(a.get(i) + " ");
      }
      System.out.println();
    }

}