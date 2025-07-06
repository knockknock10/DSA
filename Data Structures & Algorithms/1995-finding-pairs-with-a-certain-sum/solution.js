class FindSumPairs {
    constructor(nums1, nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freqMap2 = new Map();

        for (const num of nums2) {
            this.freqMap2.set(num, (this.freqMap2.get(num) || 0) + 1);
        }
    }

    add(index, val) {
        const oldVal = this.nums2[index];
        const newVal = oldVal + val;

        // Update frequency map
        this.freqMap2.set(oldVal, this.freqMap2.get(oldVal) - 1);
        if (this.freqMap2.get(oldVal) === 0) {
            this.freqMap2.delete(oldVal);
        }

        this.nums2[index] = newVal;
        this.freqMap2.set(newVal, (this.freqMap2.get(newVal) || 0) + 1);
    }

    count(tot) {
        let count = 0;

        for (const n1 of this.nums1) {
            const target = tot - n1;
            count += this.freqMap2.get(target) || 0;
        }

        return count;
    }
}
