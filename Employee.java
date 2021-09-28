public class Employee implements Comparable<Employee>{
    private String name;
    private int[] sales;
    private int salesBonus = 0,overtimeBonus = 0,totalBonus = 0,extraBonus = 0,totalSale = 0;
    public Employee(String name ,int[] s){
        this.name = name;
        sales = s;
    }
    public void addOvertimeBonus(){
        overtimeBonus += 2000;
        totalBonus+=2000;
    }
    public void addsaleBonus(int n){
        salesBonus+=n;
        totalBonus+=n;
    }
    public void addextraBonus(int n){
        extraBonus +=n;
        totalBonus +=n;
    }
    public void addSaleBaht(int n){
        totalSale+=n;
    }
    
    public String getName(){
        return name;
    }

    public int GetTotalSale(){
      return totalSale;
    }
    public void print(String[] p){
       System.out.printf("\n%-7s >> ",name);
        for(int i = 0;i<p.length;i++){
            System.out.printf("%s %d ",p[i],sales[i]);
        }
        
        System.out.printf("\n%-15s = %10s %13s = %8s   %s = %s\n","total sales",addComma(totalSale),"sales bonus",addComma(salesBonus),"extrabous",addComma(extraBonus));
        System.out.printf("%-15s = %10s %13s = %8s\n","overtime bonus",addComma(overtimeBonus),"total bonus",addComma(totalBonus));
    
    }
    
     private static String addComma(int number){
        String a = "" + number;
        String b = "";
        int count = 0;
        for(int i = a.length()-1;i>=0;i--){
            if((count!=0)&&(count%3==0))
                b  =a.charAt(i)+"," + b;
            else
                 b =  a.charAt(i) + b;
            count++;
        }
        return b;
    
    }

    public int compareTo(Employee other) { 
        if (this.totalSale > other.totalSale)
            return 1;
        else if(this.totalSale < other.totalSale)
            return -1;
        else{
            if(this.salesBonus > other.salesBonus)
                return 1;
            else if(this.salesBonus < other.salesBonus)
                return -1;
            else{
                if(this.overtimeBonus > overtimeBonus)
                    return 1;
                else if(this.overtimeBonus < other.overtimeBonus)
                    return -1;
                else{
                    if(this.name.compareTo(other.name)>0)
                        return -1;
                    else if(this.name.compareTo(other.name)<0)
                        return 1;
                    else 
                        return 0;
                }
            }
        } 
    }
}