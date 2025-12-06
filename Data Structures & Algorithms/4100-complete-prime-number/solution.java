class Solution {
    private boolean isprime(int x){
        if(x<2){return false;}
        if(x==2 || x==3){return true;}
        if(x%2==0){return false;}
        for(int i=3;i*i<=x;i+=2){
            if(x%i==0){return false;}
        }return true;
    }
    public boolean completePrime(int num) {
        
        String s = String.valueOf(num);
        int n = s.length();
        for(int i=1;i<=n;i++){
            int pre = Integer.parseInt(s.substring(0,i));
            if(!isprime(pre)) {
                return false;
            }
        }
        for(int i=0;i<n;i++){
            int suff = Integer.parseInt(s.substring(i));
            if(!isprime(suff)){
                return false;
            }
        }return true;
    }
}
