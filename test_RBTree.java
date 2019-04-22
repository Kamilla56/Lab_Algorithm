class test_RBTree{
   public static void main(String[] args) {
     RBTree test = new RBTree();
     Uzel p1 = new Uzel(5);
     Uzel p2 = new Uzel(0);
     Uzel p3 = new Uzel(8);
     Uzel p4 = new Uzel(3);
     test.put(p1);
     test.put(p2);
     test.put(p3);
     test.put(p4);
     test.delete(p4);
    /* test.printRB();*/
   }
}
   
