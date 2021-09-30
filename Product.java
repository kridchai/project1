 public class Product implements Comparable<Product>{
    private int price,totalSalesUnit,totalSalesBaht;
    private String name;
    public Product(String name,int price){
        this.name = name;
        this.price = price;
        this.totalSalesBaht = 0;
        this.totalSalesUnit = 0;
    }
    public void addProduct(int number){
        totalSalesUnit+=number;
        totalSalesBaht+=(number * price);
    
    }
    public void print(){
        System.out.printf("%-20s price = %6s (bonus = %5s)  total sales = %4s units %13s baht\n",name,addComma(price),addComma(this.calBonus()),addComma(totalSalesUnit),addComma(totalSalesBaht));
    
    }
    public int calBonus(){
        if(price < 10000)
            return (int)(price * 0.01);
        else if((price >= 10000) && (price< 30000))
            return (int)(price * 0.015);
        else if((price >= 30000) && (price< 50000))
            return (int)(price * 0.02);
        else
            return (int)(price * 0.025);
    }
    
    public int getPrice(){
        return price;
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

    public  String getName(){
      return name;

    }
    
    public int compareTo(Product other) { 
        if (this.totalSalesBaht > other.totalSalesBaht)
            return 1;
        else if(this.totalSalesBaht < other.totalSalesBaht)
            return -1;
        else{
            if(this.totalSalesUnit > other.totalSalesUnit)
                return 1;
            else if(this.totalSalesUnit < other.totalSalesUnit)
                return -1;
            else{
                if(this.price > other.price)
                    return 1;
                else if(this.price < other.price)
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
