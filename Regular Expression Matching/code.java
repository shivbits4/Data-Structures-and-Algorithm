class Solution {
    public boolean isMatch(String s, String p) {
        
        int len_s = s.length();
        int len_p = p.length();
        
        boolean[][] dp = new boolean[len_s+1][len_p+1];
        
        initialize(dp,len_s,len_p);
        
        for(int i=1;i<=len_p;i++){
            
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            } 
        }
        
        for(int i = 1;i<=len_s;i++){
            for(int j = 1;j<=len_p; j++){
                
                if(p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*'){
                    
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i-1][j];
                    } 
                    
                    dp[i][j] = dp[i][j] || dp[i][j-2];
                    
                } else {
                    dp[i][j] = false;
                } 
            }
        }
        
        return dp[len_s][len_p];
    }
    
    
    // initializing the dp matrix
    public void initialize(boolean[][] dp, int len_s, int len_p){
        
        for(int i =0;i<=len_s;i++){
            
            dp[i][0] = false;
        }
        
        for(int j=0;j<=len_p;j++){
            dp[0][j] = false;
        }
        
        dp[0][0] = true;
        
    }
}
