class Solution:
    def largestPower(self, nums: list[int]) -> list[int]:
        v=nums
        n=len(v)
        MAX = 1<<15
        f = [0]*MAX;
        for x in v:
            f[x]+=1
        s = []
        r = n
        mask = MAX-1
        while r>0:
            for m in range(MAX):
                if f[m]>0 and (m&mask)==mask:
                    c=f[m]
                    f[m]=0
                    r-=c
                    s.extend([m]*c)
            if r==0:
                break
            bm,bv=-1,-1
            for m in range(MAX):
                if f[m]>0:
                    v=m&mask
                    if v>bv:
                        bv= v
                        bm = m
            f[bm]-=1
            s.append(bm)
            r-=1
            mask&=bm
        pow = [0]*15
        for i in range(15):
            bit=1<<(14-i)
            p= 0
            while p<n and (s[p]&bit)!=0:
                p+=1
            pow[i]=p
        return pow
