
import java.util.HashMap;
public class Find_Duplicate_num {

    public static int findDuplicate(int[] nums){

     HashMap<Integer,Integer> map = new HashMap<>();
     int duplicate_num = -1;

     for(int num : nums){
        if(map.containsKey(num)){
            duplicate_num = num;
            break;
        }else{
            map.put(num,map.getOrDefault(num,0)+1);
        }
     }  
     return duplicate_num;  
    }
    public static void main(String[] args) {

        int [] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
}
