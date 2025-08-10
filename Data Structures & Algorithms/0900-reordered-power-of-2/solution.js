const reorderedPowerOf2 = n => {
    const countDigits = x => [...String(x)].sort().join('');
    const target = countDigits(n);
    
    for (let i = 0; i < 31; i++)
        if (countDigits(1 << i) === target) return true;

    return false;
};
