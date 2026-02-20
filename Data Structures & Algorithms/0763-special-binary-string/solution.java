class Solution {
    public String makeLargestSpecial(String s) {
        int cnt =0;
        List<String> list = new LinkedList<>();
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                cnt++;
            else cnt--;
            if(cnt==0)
            {
                list.add('1'+makeLargestSpecial(s.substring(j+1,i))+'0');
                j= i+1;
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return String.join("",list);
    }
}
