const lexicalOrder = (n, r = []) => {
    const dfs = (res, cur, max) => {
        if (cur > max) return;
        res.push(cur);
        for (let i = 0; i < 10; i++) {
            const nxt = cur * 10 + i;
            if (nxt > max) return;
            dfs(res, nxt, max);
        }
    };

    for (let i = 1; i < 10; i++)
        dfs(r, i, n);

    return r;
};
