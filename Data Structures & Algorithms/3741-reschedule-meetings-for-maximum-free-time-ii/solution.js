const maxFreeTime = (eventTime, startTime, endTime) => {
    const len = startTime.length;
    const gaps = new Array(len + 1);
    let lastEnd = 0;

    startTime.forEach((s, i) => {
        gaps[i] = s - lastEnd;
        lastEnd = endTime[i];
    });

    gaps[len] = eventTime - lastEnd;

    const rightMax = new Array(len + 1).fill(0);
    rightMax.reduceRight((a, val, i) => {
        if (i < len) rightMax[i] = Math.max(rightMax[i + 1], gaps[i + 1]);
        return a;
    }, 0);

    let leftMax = 0;
    let maxGap = 0;

    startTime.map((s, i) => i + 1).forEach(i => {
        const dur = endTime[i - 1] - startTime[i - 1];
        const gapL = gaps[i - 1];
        const gapR = gaps[i];

        if (leftMax >= dur || rightMax[i] >= dur)
            maxGap = Math.max(maxGap, gapL + dur + gapR);

        maxGap = Math.max(maxGap, gapL + gapR);
        leftMax = Math.max(leftMax, gapL);
    });

    return maxGap;
};


