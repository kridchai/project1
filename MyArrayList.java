import java.util.*;
public class MyArrayList extends ArrayList<Employee>  {
    public int indexOf(String n){
        for(int i = 0;i<this.size();i++){
            if(this.get(i).getName().equals(n))
                return i;
        }
        return -1;
    }
}
