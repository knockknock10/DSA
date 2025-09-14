class Solution {
public:
    static constexpr unsigned vowMask=(1<<('A'&31))+(1<<('E'&31))+(1<<('I'&31))+(1<<('O'&31))+(1<<('U'&31));
    static string tolow(string w) {
        for (char& c : w) c=tolower(c);
        return w;
    }

    static string toDeV(string w) {
        for (char& c : w)
            if((vowMask>>(c&31))&1) c='$';
        return w;
    }

    static vector<string> spellchecker(vector<string>& wordlist, vector<string>& queries) {
        const int n=wordlist.size();
        unordered_set<string> W(wordlist.begin(), wordlist.end());
        unordered_map<string, string> Wlow, WdeV;
        Wlow.reserve(n), WdeV.reserve(n);

        for (const auto& w : wordlist) {
            const string lw = tolow(w), dv = toDeV(lw);
            if (!Wlow.count(lw)) Wlow[lw] = w;
            if (!WdeV.count(dv)) WdeV[dv] = w;
        }

        for (auto& q : queries) {
            if (W.count(q)) continue;
            string low = tolow(q), deV = toDeV(low);
            if (Wlow.count(low)) q = Wlow[low];
            else if (WdeV.count(deV)) q = WdeV[deV];
            else q = "";
        }
        return queries;
    }
};

auto init = []()
{ 
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    return 'c';
}();
