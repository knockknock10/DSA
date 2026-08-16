class Solution {
    public int minSwaps(String s) {
        int count1=0 ,count0 = 0,miss0 = 0,miss1 = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){count1++;}
            else{count0++;}
        }
        if(Math.abs(count0-count1)>1){return -1;}
        for(int i=0;i<s.length();i+=2){
            if(s.charAt(i)!='0'){miss0++;}
            else{miss1++;}
        }
        return count0==count1?Math.min(miss0,miss1):count0>count1?miss0:miss1;
    }
}
