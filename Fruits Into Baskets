import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    
    if(arr.length == 0)return 0;

    HashMap<Character, Integer> hashMap = new HashMap<>();

    int len = arr.length;
    char prevChar = arr[0];
    int prevLen = 0;
    int ans = 0;

    for(int i =0 ;i<len;i++) {
      
      char ch = arr[i];
      boolean contain = hashMap.containsKey(ch);

      if(prevChar == ch) prevLen++;
      else if(hashMap.size() <=2 && contain){
        prevChar = ch;
        prevLen = 1;
      }

      if(contain){
        int prev = hashMap.get(ch);
        prev = prev + 1;
        hashMap.replace(ch, prev);
      }
      else {
        if(hashMap.size()>=2){  
          int sum = 0;
          for(Map.Entry<Character, Integer> e : hashMap.entrySet()){
            sum = sum + e.getValue();
          }
          ans = Math.max(ans, sum);    
          hashMap.clear();
          hashMap.put(prevChar, prevLen);
          hashMap.put(ch,1);
          prevChar = ch;
          prevLen = 1;
        } else {
          hashMap.put(ch,1);
          prevChar = ch;
          prevLen = 1;
        }


      }

    }

          int sum = 0;
          for(Map.Entry<Character, Integer> e : hashMap.entrySet()){
            sum = sum + e.getValue();
          }
          ans = Math.max(ans, sum); 


    return ans;
  }
}
