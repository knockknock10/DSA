const earliestAndLatest = (n, firstPlayer, secondPlayer) => {
    let left = Math.min(firstPlayer, secondPlayer);
    let right = Math.max(firstPlayer, secondPlayer);

    if (left + right === n + 1) return [1, 1];
    if (n === 3 || n === 4) return [2, 2];

    if (left - 1 > n - right) {
        const temp = n + 1 - left;
        left = n + 1 - right;
        right = temp;
    }

    const nextRound = (n + 1) >> 1;
    const results = [];

    if (right * 2 <= n + 1) {
        const preLeft = left - 1;
        const midGap = right - left - 1;

        for (let i = 0; i <= preLeft; i++) {
            for (let j = 0; j <= midGap; j++) {
                const [minRes, maxRes] = earliestAndLatest(nextRound, i + 1, i + j + 2);
                results.push([1 + minRes, 1 + maxRes]);
            }
        }

    } else {
        const mirrored = n + 1 - right;
        const preLeft = left - 1;
        const midGap = mirrored - left - 1;
        const innerGap = right - mirrored - 1;

        for (let i = 0; i <= preLeft; i++) {
            for (let j = 0; j <= midGap; j++) {
                const second = i + j + 1 + ((innerGap + 1) >> 1) + 1;
                const [minRes, maxRes] = earliestAndLatest(nextRound, i + 1, second);
                results.push([1 + minRes, 1 + maxRes]);
            }
        }
    }


    return [results.reduce((min, [a]) => Math.min(min, a), n),
            results.reduce((max, [, b]) => Math.max(max, b), 1)]
};



