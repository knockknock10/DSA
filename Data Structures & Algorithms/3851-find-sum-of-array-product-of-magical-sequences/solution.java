import java.util.*;

public class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[] fact;
    private long[] invFact;
    private int[] numbers;
    private int n;
    private Map<Long, Long> memo;

    public int magicalSum(int totalCount, int targetOdd, int[] numbers) {
        this.numbers = numbers;
        this.n = numbers.length;
        precomputeFactorials(totalCount);
        memo = new HashMap<>();
        long ans = dfs(totalCount, targetOdd, 0, 0);
        return (int)(ans % MOD);
    }

    private void precomputeFactorials(int maxN) {
        fact = new long[maxN + 1];
        invFact = new long[maxN + 1];
        fact[0] = 1L;
        for (int i = 1; i <= maxN; ++i) fact[i] = fact[i - 1] * i % MOD;
        invFact[maxN] = modInverse(fact[maxN]);
        for (int i = maxN - 1; i >= 0; --i) invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    private long nCk(int n, int k) {
        if (k < 0 || k > n) return 0L;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    private long modPow(long base, int exp) {
        base %= MOD;
        long res = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    private long modInverse(long x) {
        return modPow(x, (int)(MOD - 2));
    }

    private long dfs(int remaining, int oddNeeded, int index, int carry) {
        if (remaining < 0 || oddNeeded < 0) return 0L;
        if (remaining + Integer.bitCount(carry) < oddNeeded) return 0L;
        if (remaining == 0) return (oddNeeded == Integer.bitCount(carry)) ? 1L : 0L;
        if (index >= n) return 0L;

        long key = packKey(remaining, oddNeeded, index, carry);
        if (memo.containsKey(key)) return memo.get(key);

        long ans = 0L;
        for (int take = 0; take <= remaining; ++take) {
            long comb = nCk(remaining, take);
            long pow = modPow(numbers[index], take);
            long ways = (comb * pow) % MOD;
            int newCarry = carry + take;
            int oddSubtract = newCarry % 2;
            long sub = dfs(remaining - take, oddNeeded - oddSubtract, index + 1, newCarry / 2);
            ans = (ans + ways * sub) % MOD;
        }

        memo.put(key, ans);
        return ans;
    }

    private long packKey(int remaining, int oddNeeded, int index, int carry) {
        return (((long) remaining) << 48) | (((long) oddNeeded) << 32)
             | (((long) index) << 16) | ((long) carry & 0xffffL);
    }
}
