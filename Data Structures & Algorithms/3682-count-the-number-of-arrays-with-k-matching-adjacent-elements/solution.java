import java.math.BigInteger;

class Solution {
    static final int MX = 100000;
    static final BigInteger MOD = BigInteger.valueOf(1_000_000_007);
    static final BigInteger[] fact = new BigInteger[MX];
    static final BigInteger[] invFact = new BigInteger[MX];

    static BigInteger qpow(BigInteger x, BigInteger n) {
        BigInteger res = BigInteger.ONE;
        while (n.signum() > 0) {
            if (n.testBit(0)) {
                res = res.multiply(x).mod(MOD);
            }
            x = x.multiply(x).mod(MOD);
            n = n.shiftRight(1);
        }
        return res;
    }

    static void init() {
        if (fact[0] != null) return;
        fact[0] = BigInteger.ONE;
        for (int i = 1; i < MX; i++) {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i)).mod(MOD);
        }
        invFact[MX - 1] = qpow(fact[MX - 1], MOD.subtract(BigInteger.TWO));
        for (int i = MX - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1].multiply(BigInteger.valueOf(i + 1)).mod(MOD);
        }
    }

    static BigInteger comb(int n, int m) {
        if (m < 0 || m > n) return BigInteger.ZERO;
        return fact[n].multiply(invFact[m]).mod(MOD).multiply(invFact[n - m]).mod(MOD);
    }

    public int countGoodArrays(int n, int m, int k) {
        init();
        BigInteger res = comb(n - 1, k);
        res = res.multiply(BigInteger.valueOf(m)).mod(MOD);
        res = res.multiply(qpow(BigInteger.valueOf(m - 1), BigInteger.valueOf(n - k - 1))).mod(MOD);
        return res.intValue();
    }
}
