const answerString = (word, numFriends, res = '') => {
    if (numFriends === 1) return word;

    const L = word.length;

    for (let i = 0; i < L; i++) {
        let str = word.substring(i, Math.min(i + L - numFriends + 1, L));
        if (str > res) res = str;
    }

    return res;
};

