import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Online_Stock_Span {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
    }
}
class StockSpanner{
    private Stack<Integer> stack;
    private List<Integer> prices;
    
    public StockSpanner(){
          stack = new Stack<>();
          prices = new ArrayList<>();
    }

    public int next(int price){
      int idx = prices.size();
      prices.add(price);
      while (!stack.isEmpty() && price >= prices.get(stack.peek())){
          stack.pop();
      }
        int span;
        if(stack.isEmpty()){
          span = idx +1;
        }else{
          span = idx - stack.peek();
        }
        stack.push(idx);
        return span; 
      }
}
