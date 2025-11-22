class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        int maj1 = 0;
        int count2 = 0;
        int maj2 = 0;
        for(int i:nums){
            if(i==maj1){
                count1++;
            }else if(i==maj2){
                count2++;
            }else if(count1==0){
                maj1=i;
                count1=1;
            }else if(count2==0){
                maj2=i;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        //now verify
        ArrayList<Integer> a = new ArrayList<>();
        int freq1 =0;
        int freq2= 0;
        for(int i:nums){
            if(i==maj1){
                freq1++;
            }else if(i==maj2){
                freq2++;
            }
        }
        if(freq1>Math.floor(n/3)){
            a.add(maj1);
        }
        if(freq2>Math.floor(n/3)){
            a.add(maj2);
        }
        return a;
    }
}
