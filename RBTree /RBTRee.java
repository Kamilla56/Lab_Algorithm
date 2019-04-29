public class RBTree
{
 Uzel root;
 public void put(Uzel d) / / вставка
  {                    
 Uzel x = d;
 Uzel current = root;
 Uzel par = null;
 while(current!= null)
    {
 if( current.data > > x.data)
      {
 par = current;
 current = current.left;
      }
 else
      {
 par = current;
 current = current.right;
      }
    }
 current = x;
 x.parent = par;
 if(par!=null)
    {
 if(par.data > > x.data)
      {
 par.left = x;
      }
 else
      {
 par.right = x;
      }
    }
 else
    {
 root = x;
    }
 put_balance(x);
      
  } 
 public void delete( Uzel y)
  {   
 Uzel t;
 Uzel q;
 if(y.left = = null | / y.right = = null)
    {
 t = y;
    }
 else
    {
 t = y.right;
 while(t.left!= null) t = t.left;
    }
 if(t.left!=null)
    {
 q = t.left;
    }
 else
    {
 q = t.right;
    }
 q.parent = t.parent;
 if(t.parent!=null)
    {
 if(t == t.parent.left)
      {
 t.parent.left = q;
      }
 else
      {
 t.parent.right = q;
      }
    }
 else
    {
 root = q;
    }
 if(t!=y)
    {
 y.data = t.data;
    }
 if(t.color = = " BLACK")
    {
 delete_balance(q);
    }
  }
 private void delete_balance( Uzel x)
  {
 while(x!= root & & x.color = = " BLACK")
    {
 if(x = = x.parent.left)
      {
 Uzel k = x.parent.right;
 if(k.color = = "RED")
        { 
 k.color = " BLACK";
 k.parent.color = "RED";
 rotateL(x.parent);
 k = x.parent.right;
         }
 if(k.left.color = = "BLACK" & & k.right.color = = "BLACK" ) / / случай 3
        { 
 k.color = "RED";
 x = x.parent;
        }
 else
         {
 if(k.right.color == "BLACK")//внешний красный ,внутренний черный (случай 6)
           { 
 k.left.color = " BLACK";
 k.color = "RED";
 rotateR(k);
 k = x.parent.right;
           }
 k.color = x.parent.color;
 x.parent.color =  " BLACK";
 k.right.color =  " BLACK";
 rotateL(x.parent);
 x =  root;
        }
      }
        else
        {
           Uzel k = x.parent.left; //те же самые случаи , только , если "x" ребенок правый , а дядя "s" левый
           if(k.color = =  "RED")
           {
 k.color =  " BLACK";
 k.parent.color =  "RED";
 rotateR(x.parent);
 k = x.parent.left;
           }
           if(k.right.color = =  "BLACK"  & &  k.left.color = =  " BLACK")
           {
 k.color =  "RED";
 x = x.parent;
           }
           else
           {
              if(k.left.color = =  " BLACK")
              {
 k.right.color =  " BLACK";
 k.color =  "RED";
 rotateL(k);
 k = x.parent.left;
              }
 k.color = x.parent.color;
 x.parent.color = " BLACK";
 k.left.color = " BLACK";
 rotateR(x.parent);
 x = root;
            }
        }
    }
  }
    
           
        
          
      
 private void put_balance(Uzel t) // баланс после добавления
  { 
 while (t!= root & & t.parent.color == "RED") //если отец красный и узел не корень
    { 
 if(t.parent == t.parent.parent.left)//если отец в левом поддереве деда
      { 
 Uzel= t.parent.parent.right; //дядя правый
      
 if(uncle.color == "RED") //если дядя красный: красим отца с дядей в черный ,а деда в красный
          { 
 t.parent.color = " BLACK";
 t.parent.parent.right.color = " BLACK";
 t.parent.parent.color = "RED";
 t = t.parent.parent;
          }
 else
          {
 if(t == t.parent.right) //если узел относительно отца ПРАВЫЙ , то делаем двойное вращение с перекраской
            {
 t = t.parent;
 rotateL(t);
            }
 t.parent.color = " BLACK";
 t.parent.parent.color = "RED";
 rotateR(t.parent.parent);
          }
      }
      else // если сын с отцом в правой ветки деда
      { 
        if(t.parent == t.parent.parent.right) // тогда дядя в левой ветке деда
        { 
 uncle =  t.parent.parent.left;
        
          if(uncle.color = =  "RED")
          {
 t.parent.color =  " BLACK";
 uncle.color =  " BLACK";
 t.parent.parent.color =  "RED";
 t = t.parent.parent;
          }
          else
          { 
 if(t == t.parent.left)
              {
 t = t.parent; // для поворота
 rotateR(t);// поворот в поддереве Р (добавл. элемент + его родитель)
              }
 t.parent.color = " BLACK";
 t.parent.parent.color = "RED";
 rotateL(t.parent.parent); // поворот от X дедушки (в поддереве уже дедушка+отец+сын)
          }
        }
      }
    }
     
 root.color = " BLACK";
  }
      
   
 private void rotateR(Uzel f) //правое вращение
    { 
 Uzel h = f.left;
 f.left = h.right;
 if(h.right!=null)
      {
 h.right.parent = f;
      }
 if(h!=null)
      {
 h.parent = f.parent;
      }
 if(f.parent = = null)
      {
 if(f == f.parent.right)
 f.parent.right = h;
 else
 f.parent.left = h;
      } 
 else
      {
 root = h;
      }
 h.right = f;
 if(f!=null)
        {
 f.parent = h;
        }
    }
 private void rotateL(Uzel f) / / левое вращение
    { 
 Uzel h = f.right;
 f.right = h.left;
 if(h.left!=null)
        {
 h.left.parent = f;
        }
 if(h!=null)
        {
 h.parent = f.parent;
        }
 if(f.parent = = null)
        {
 if(f == f.parent.left)
 f.parent.left = h;
 else
 f.parent.right = h;
        } 
 else
        {
 root = h;
        }
 h.left = f;
 if(f!=null)
        {
 f.parent = h;
        }
    }
 public void printRB() //запускаем от корня
    { 
 Uzel help = root;
 help_meth(help);
    }
      
 private void help_meth(Uzel u) //рекурсивно выводим все дерево
      { 
 while(u.left!=null || u.right!=null )
        {
 System.out.println("Значение элемента" + u.data);
 if(u.left!=null)
            {
 System.out.println("Его левый потомок" + u.left.data);
 help_meth(u.left);
            }
 if(u.right!=null)
            {
 System.out.println("Его правый потомок" + u.right.data);
 help_meth(u.right);
            }
        }
      }
      
}
