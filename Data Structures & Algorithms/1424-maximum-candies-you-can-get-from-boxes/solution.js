const maxCandies = (status, candies, keys, containedBoxes, initialBoxes) => {
    let queue = [...initialBoxes];
    let total = 0;

    while (queue.length > 0) {
        let box = queue.shift();
        
        if (!status[box]) {
            if (!queue.length) return total;
            queue.push(box);
        } else {
            total += candies[box];
            for (const key of keys[box]) status[key] = 1;
            for (const contained of containedBoxes[box]) queue.push(contained);
        }
    }

    return total;
};
