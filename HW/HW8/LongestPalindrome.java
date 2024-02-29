
import java.util.*;
class LongestPalindrome {

    public int longestPalindrome(String s){
        if ((1 <= s.length() && s.length()<= 2000)) {
            int i, count = 0;
            char ch = ' ';
            String s_new = "", s_palin1 ="", s_palin2 ="";
            for(i = 0; i< s.length(); i++){
                ch = s.charAt(i);
                if(Character.isLetter(ch)){
                    s_new = s_new + ch;
                }
                else{
                    return -1;
                }
            }
            HashMap<Character, Integer> map_Palin = new HashMap<>();

            for ( i = 0; i<s_new.length(); i++){
                ch = s_new.charAt(i);
                if(map_Palin.containsKey(ch)){
                    map_Palin.put(ch, map_Palin.get(ch) + 1);
                }
                else
                    map_Palin.put(ch,1);
            }

            for(Map.Entry<Character, Integer> e : map_Palin.entrySet()){
                i = e.getValue()/2;
                for(int j = 0; j<i;j++){
                    s_palin1 = s_palin1 + e.getKey();
                    s_palin2 = e.getKey() + s_palin2;
                    count++;
                }
                if(s_palin2 == "" && (e.getValue()%2)!= 0){
                    ch = e.getKey();
                    count++;
                }
            }

            return (s_palin1+ch+s_palin2).length();
          }
        else{
            return -1;
        }
    
    }
    public static void main (String args[]){
        Scanner in = new Scanner (System.in);

        LongestPalindrome palinOb = new LongestPalindrome();
        System.out.println("Enter the phrase");
        String s = in.nextLine();
        int result = palinOb.longestPalindrome(s);
        if (result !=-1)
            System.out.println(result);
        else
            System.out.println("Invalid Entry");

    }
    
    
}
