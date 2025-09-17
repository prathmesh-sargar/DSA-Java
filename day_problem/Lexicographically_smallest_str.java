import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Lexicographically_smallest_str {

    public static String lexicographicalStr(String s) {

        StringBuilder vowels = new StringBuilder();
        StringBuilder consonents = new StringBuilder();

        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        // hashset give me unorder traversal 
        for(char ch :set){
            if(ch == 'a'|| ch == 'e' || ch == 'i' || ch =='o' || ch =='u'){
                vowels.append(ch);
            }else{
                consonents.append(ch);
            }
        }
        // System.out.println(vowels.toString());
        // System.out.println(consonents.toString());

        char [] vchar = vowels.toString().toCharArray();
        char [] cchar = consonents.toString().toCharArray();

        Arrays.sort(vchar);
        Arrays.sort(cchar);
        
        return new String(vchar)+ new String(cchar);
    }
    public static void main(String[] args) {
        String s = "acbacae";
        System.out.println(s);
        // output remove duplicates | first come all vowels in sorted manner then all
        // consonents as like we wnat
        String ans = lexicographicalStr(s);
        System.out.println(ans);

    }
}
