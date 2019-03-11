public class test_priorQ{
  public static void main(String[] args) {
    PriorQueue test = new PriorQueue();
    test.add(9);
    test.add(10);
     test.add(1);
      test.add(14);
      test.add(6);
      test.add(8);
      test.print_remove(); //получим максимальное значение и удалим его с очереди.
      test.print_remove();
      test.printQ(); //(проверка очереди №1) можно проверить структуру, убедиться,что она действительно построена с учетом св-в "пирамиды"
      test.print_remove();
      test.print_remove();
      test.printQ(); //(проверка очереди №2)  
      int size = test.sizeQ();
      System.out.println("Элементов в очереди:" + size);
  }
}
    
    
  