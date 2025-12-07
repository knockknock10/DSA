class Solution:
    def sortByReflection(self, nums: List[int]) -> List[int]:
        def reflect(x:int)->int:
            rev = 0
            while x:
                rev = (rev<<1)|(x&1)
                x>>=1
            return rev
        pairs=[(reflect(x),x) for x in nums]
        pairs.sort()
        return [x for _,x in pairs]
