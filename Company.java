import java.io.*;
import java.util.*;
        
public class Company {
    public static void main(String[] args){
        ArrayList<Product> pA = new ArrayList<Product>();
        MyArrayList eA = new MyArrayList();
        try{
         Scanner File1 = new Scanner(new File("products.txt"));
         while(File1.hasNext()){
             String line = File1.nextLine();
             String[] buff = line.split(",");
             String name = buff[0].trim();
             int price = Integer.parseInt(buff[1].trim());
             Product p = new Product(name,price);
             pA.add(p);
         }
        File1.close();
        Scanner File2 = new Scanner(new File("employees.txt"));
        while(File2.hasNext()){
            String line = File2.nextLine();
            String []buff = line.split(",");
            String name = buff[0].trim();
            int[] sales = new int[buff.length-1];
            for(int i = 0;i<sales.length;i++){
                sales[i] = Integer.parseInt(buff[i+1].trim());
            }
            Employee e = new Employee(name,sales);
            for(int i =0;i<sales.length;i++){
                  e.addsaleBonus(sales[i] * pA.get(i).calBonus());
                  e.addSaleBaht(sales[i] * pA.get(i).getPrice());
                  pA.get(i).addProduct(sales[i]);
            }
            eA.add(e);
        }
        File2.close();
        Scanner File3 = new Scanner(new File("overtime.txt"));
        while(File3.hasNext()){
            int c;
            String line = File3.nextLine();
            String[] buff = line.split(",");
            for(int i = 0;i<buff.length;i++){
                  c = eA.indexOf(buff[i].trim());
                  if(c!=-1)
                    eA.get(c).addOvertimeBonus();
                        
            }
        }
        File3.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        String [] p = new String[pA.size()];
        for(int i = pA.size()-1; i>=0; i--)
                p[i] = pA.get(i).getName();        
      
        
        System.out.println("\n=== Bonus Calculation ===");
        for(int i = eA.size()-1; i>=0; i--)
                eA.get(i).print(p);
        
        System.out.println("\n=== Product summary ===");
         Collections.sort(pA);
            for(int i = pA.size()-1; i>=0; i--)
                pA.get(i).print();
        String FileName = "products.txt";
        
        
        try{
           
        } 
        catch(Exception e)
            {
                System.out.println(e);
                System.out.printf("New file name : ");
                Scanner s = new Scanner(System.in);
                FileName = s.next();
            }
       
    }
}
