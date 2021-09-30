import java.io.*;
import java.util.*;
import java.math.*;
public class Company {
  
  public static void main(String[] args) {
    ArrayList<Product> pA = new ArrayList<Product>();
   MyArrayList eA = new MyArrayList();
   Scanner scan1 = new Scanner(System.in);
   Scanner scan2 = new Scanner(System.in);
   Scanner scan3 = new Scanner(System.in);
        String pd, em, ov;
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
    System.out.printf("\n");
      
      
   
      //---------2-----------
      
         boolean Success2 = false;
       System.out.println("Enter employee file = ");
        em = scan2.next();
      while(Success2==false){
      try{
       
          File2 = new Scanner(new File(em));
          Success2 = true;
          System.out.println("\n");
          
        while (File2.hasNext()) {
        int checkErr = 0;
        String line = File2.nextLine();
        String[] buff = line.split(",");
        String name = buff[0].trim();
       int[] sales = new int[pA.size()];
         
        try{
          for (int i = 0; i < buff.length-1; i++) {
            try{ sales[i] = Integer.parseInt(buff[i +1].trim());}
            catch(NumberFormatException e){
              sales[i]=0;
              checkErr = 1;
            }
            if(sales[i]<0)
            {
             checkErr = 1;
              sales[i]=0;
            }
          }
        } 
       catch(ArrayIndexOutOfBoundsException e){
          checkErr = 1;
        }
        if(buff.length-1<pA.size()){
          
          checkErr = 1;
        }
        if(checkErr==1){
          System.out.println("Input error: "+line);
          System.out.print("Correction : "+name);
          for (int i = 0; i < sales.length; i++)
          {
            System.out.print(", "+sales[i]);
          }
          System.out.println("\n");
        }
          
        
        Employee e = new Employee(name, sales);
        for (int j = 0; j < sales.length; j++) {
          e.addsaleBonus(sales[j] * pA.get(j).calBonus());
          e.addSaleBaht(sales[j] * pA.get(j).getPrice());
          pA.get(j).addProduct(sales[j]);
        }
        eA.add(e);
  
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
       System.out.printf("\n");
      
      
       
      //---------3-----------
       boolean Success3 = false;
       System.out.println("Enter overtime file = ");
        ov = scan3.next();
      while(Success3==false){
      try{
        File3 = new Scanner(new File(ov));
        Success3 = true;
      
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
    int moneyAdded = (int)Math.round( (0.005 * eA.get(eA.size()-1).GetTotalSale())/count );
    for(int i = eA.size()-1;i>=0;i--){
      count--;
      eA.get(i).addextraBonus(moneyAdded);
      if(count==0)
        break;
    }

    // copy product name to array p
    String[] p = new String[pA.size()];
   // System.out.println(pA.size());
    for (int i = pA.size() - 1; i >= 0; i--)
      p[i] = pA.get(i).getName();

    System.out.println("\n=== Bonus Calculation ===");
    for (int i = eA.size() - 1; i >= 0; i--)
      eA.get(i).print(p);

    System.out.println("\n=== Product summary ===");
    Collections.sort(pA);
    for (int i = pA.size() - 1; i >= 0; i--)
      pA.get(i).print();
    
}
}
  
  

