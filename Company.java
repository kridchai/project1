import java.io.*;
import java.util.*;

public class Company {
  
  public static void main(String[] args) {
    ArrayList<Product> pA = new ArrayList<Product>();
   MyArrayList eA = new MyArrayList();
   Scanner scan1 = new Scanner(System.in);
   Scanner scan2 = new Scanner(System.in);
   Scanner scan3 = new Scanner(System.in);
        String pd, em, ov;
   //ArrayList<String> t = new ArrayList<String>();
      Scanner File1 = null;
      Scanner File2 = null;
       Scanner File3 = null;
      System.out.println("Enter product file = ");
      pd = scan1.next();
    try{
      boolean Success1 = false;
      while(Success1==false){
    try {
      //---------1-----------             
                   // t.add("P");
     File1 = new Scanner(new File(pd));
      Success1 = true;
      
      while (File1.hasNext()) {
        String line = File1.nextLine();
        String[] buff = line.split(",");
        String name = buff[0].trim();
        int price = Integer.parseInt(buff[1].trim());
        Product p = new Product(name, price);
        pA.add(p);
      }
      
      File1.close();
      }
      catch (Exception e) {
      
        System.out.println(e);
                System.out.println("Enter product file =");
                Scanner x = new Scanner(System.in);
                pd = x.next();
      }
    }
      
      
      boolean Success2 = false;
       System.out.println("Enter employee file = ");
        em = scan2.next();
      while(Success2==false){
      try{
      //---------2-----------
      //Scanner scan2 = new Scanner(System.in);
        
       
            
               //t.add("E");
          File2 = new Scanner(new File(em));
          Success2 = true;
        while (File2.hasNext()) {
    String line = File2.nextLine();
        String[] buff = line.split(",");
        String name = buff[0].trim();
        int[] sales = new int[buff.length - 1];
       // try{
      
        for (int i = 0; i < sales.length; i++) {
        sales[i] = Integer.parseInt(buff[i + 1].trim());

        /*if( (sales[i]<0) || 
        {
          System.out.println("Input error: "+line);
       sales[i]=0;
        }
        } 
        //System.out.println("Correction : %s,%d,%d,%d,%d,%d",name,sales[]);
        */
        
        Employee e = new Employee(name, sales);
        for (int j = 0; j < sales.length; j++) {
          e.addsaleBonus(sales[j] * pA.get(j).calBonus());
          e.addSaleBaht(sales[j] * pA.get(j).getPrice());
          pA.get(j).addProduct(sales[j]);
        }
        eA.add(e);
  /*}
  catch(Exception e){
 //   System.out.print("Input error: ");
    System.out.print(line);
   /* System.out.println("Correction  : %s, %d, %d, %d, %d");*/
  }
      }
      File2.close();
      }
           catch (Exception e) {
      
        System.out.println(e);
        System.out.println("Enter employee file =");
       Scanner y = new Scanner(System.in);
        em = y.next();
      
      }  
      }
      
      
       
      //---------3-----------
                   boolean Success3 = false;
       System.out.println("Enter overtime file = ");
        ov = scan3.next();
      while(Success3==false){
      try{
        File3 = new Scanner(new File(ov));
        Success3 = true;
        //t.add("O");
      while (File3.hasNext()) {
        int c;
        String line = File3.nextLine();
        String[] buff = line.split(",");
        ArrayList<String> set = new ArrayList<String>();
        
        for (int i = 0; i < buff.length; i++) {
          c = eA.indexOf(buff[i].trim());
          if ( (c != -1) && (set.contains(buff[i].trim())==false) )
           {
            set.add(buff[i].trim());
            eA.get(c).addOvertimeBonus();
            }
          } 
        set.clear();//addovertimeBous finish laew
      }
      File3.close();
    }
    catch (Exception e) {
        System.out.println(e);
                System.out.println("Enter overtime file =");
                Scanner z = new Scanner(System.in);
                ov = z.next();
      } 
      }
      
    //------------end---------------
    
    }
    catch (Exception e) {
      System.out.println(e);
    }
    // AddExtrabonus
    Collections.sort(eA);
    int count = 0;
    for(int i = eA.size()-1;i>=0;i--){
      count+=1;
      if(eA.get(i).GetTotalSale()!=eA.get(i-1).GetTotalSale())
        break;
    }
    int moneyAdded = (int)( (0.005 * eA.get(eA.size()-1).GetTotalSale())/count );
    for(int i = eA.size()-1;i>=0;i--){
      count--;
      eA.get(i).addextraBonus(moneyAdded);
      if(count==0)
        break;
    }

    // copy product name to array p
    String[] p = new String[pA.size()];
    System.out.println(pA.size());
    for (int i = pA.size() - 1; i >= 0; i--)
      p[i] = pA.get(i).getName();

    System.out.println("\n=== Bonus Calculation ===");
    for (int i = eA.size() - 1; i >= 0; i--)
      eA.get(i).print(p);

    System.out.println("\n=== Product summary ===");
    Collections.sort(pA);
    for (int i = pA.size() - 1; i >= 0; i--)
      pA.get(i).print();
    String FileName = "products.txt";
    
}
}
   /* try {

    } catch (Exception e) {
      System.out.println(e);
      System.out.printf("New file name : ");
      Scanner s = new Scanner(System.in);
      FileName = s.next();
    }
    */
  
  /*public void process(MyArrayList eA ,Scanner File2){
   String line = File2.nextLine();
        String[] buff = line.split(",");
        String name = buff[0].trim();
        int[] sales = new int[buff.length - 1];
        try{
      
        for (int i = 0; i < sales.length; i++) {
        sales[i] = Integer.parseInt(buff[i + 1].trim());
        if(sales[i]<0 || sales[i] instanceof Double){
          System.out.println("Input error: "+line);
       sales[i]=0;
        //throw new Exception("Correction: "+line);
        }
        }
        Employee e = new Employee(name, sales);
        for (int i = 0; i < sales.length; i++) {
          e.addsaleBonus(sales[i] * pA.get(i).calBonus());
          e.addSaleBaht(sales[i] * pA.get(i).getPrice());
          pA.get(i).addProduct(sales[i]);
        }
        eA.add(e);
  }
  catch(Exception e){
 //   System.out.print("Input error: ");
    System.out.print(line);
   /* System.out.println("Correction  : %s, %d, %d, %d, %d");*/
  
  

