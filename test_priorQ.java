public class test_priorQ{
  public static void main(String[] args) {
    PriorQueue test = new PriorQueue();
    test.add(9);
    test.add(10);
     test.add(1);
      test.add(14);
      test.add(6);
      test.add(8);
      test.print_remove(); //������� ������������ �������� � ������ ��� � �������.
      test.print_remove();
      test.printQ(); //(�������� ������� �1) ����� ��������� ���������, ���������,��� ��� ������������� ��������� � ������ ��-� "��������"
      test.print_remove();
      test.print_remove();
      test.printQ(); //(�������� ������� �2)  
      int size = test.sizeQ();
      System.out.println("��������� � �������:" + size);
  }
}
    
    
  