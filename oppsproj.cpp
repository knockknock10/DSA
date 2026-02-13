// TimeTableGenerator.cpp
// Compile: g++ -std=c++17 TimeTableGenerator.cpp -o ttg
// Run: ./ttg
// Author: Group No. 1 - Abhishek Singh, Sanjeev Kumar, Shashank, Aayush Shah
// Project: TimeTable Generation (OOP C++)

#include <bits/stdc++.h>
using namespace std;

struct Slot
{
    string subject;
    string faculty;
    Slot(const string &s = "", const string &f = "") : subject(s), faculty(f) {}
};

class TimeTableGenerator
{
public:
    TimeTableGenerator(int days_per_week = 5,
                       int periods_per_day = 8,
                       const vector<string> &subjects = {},
                       const map<string, int> &specials = {},
                       const map<string, string> &faculty_map = {},
                       bool avoid_consecutive = true,
                       unsigned int seed = 42)
        : days(days_per_week),
          periods(periods_per_day),
          subjects(subjects),
          specials(specials),
          faculty_map(faculty_map),
          avoid_consecutive(avoid_consecutive),
          rng(seed)
    {
        if (this->subjects.empty())
        {
            this->subjects = {"Math", "Physics", "Chemistry", "Biology", "English", "Computer"};
        }
        // defaults for faculty_map are allowed to be missing; we'll show "TBD"
    }

    // Main public API: returns true if timetable generated successfully
    bool generate()
    {
        total_slots = days * periods;
        if (!buildTargets())
            return false;
        buildPool();
        bool ok = tryGreedyPlacement(500); // attempt limit
        if (!ok)
            fallbackFill();
        buildFinalTable();
        return true;
    }

    void printTimetable() const
    {
        vector<string> daysNames = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        cout << "Timetable (" << days << " days x " << periods << " periods = " << total_slots << " slots)\n";
        // header
        cout << left << setw(8) << "Day/Per";
        for (int p = 0; p < periods; ++p)
        {
            cout << setw(18) << ("P" + to_string(p + 1));
        }
        cout << "\n";
        for (int d = 0; d < days; ++d)
        {
            string dayLabel = d < (int)daysNames.size() ? daysNames[d] : ("Day" + to_string(d + 1));
            cout << setw(8) << dayLabel;
            for (int p = 0; p < periods; ++p)
            {
                const Slot &s = table[d][p];
                string cell = s.subject + " (" + s.faculty + ")";
                if ((int)cell.size() > 17)
                    cell = cell.substr(0, 14) + "...";
                cout << setw(18) << cell;
            }
            cout << "\n";
        }
        cout << "\nSummary counts:\n";
        for (auto &kv : summary)
        {
            cout << "  " << setw(12) << kv.first << ": " << kv.second << "\n";
        }
        cout << "Targets:\n";
        for (auto &kv : targets)
        {
            cout << "  " << setw(12) << kv.first << ": " << kv.second << "\n";
        }
    }

    const map<string, int> &getTargets() const { return targets; }
    const map<string, int> &getSummary() const { return summary; }

private:
    int days;
    int periods;
    int total_slots;
    vector<string> subjects;
    map<string, int> specials;
    map<string, string> faculty_map;
    bool avoid_consecutive;
    mt19937 rng;

    map<string, int> targets;
    vector<string> pool;           // multiset of subjects to place
    vector<vector<string>> placed; // intermediate placed subjects by day/period
    vector<vector<Slot>> table;    // final table with faculty
    map<string, int> summary;

    bool buildTargets()
    {
        targets.clear();
        int specials_total = 0;
        for (auto &kv : specials)
        {
            targets[kv.first] = kv.second;
            specials_total += kv.second;
        }
        int remaining = days * periods - specials_total;
        if (remaining < 0)
        {
            cerr << "Error: Not enough slots to place required special hours.\n";
            return false;
        }
        int m = (int)subjects.size();
        int base = remaining / max(1, m);
        int extra = remaining % max(1, m);
        for (int i = 0; i < m; ++i)
        {
            targets[subjects[i]] = base + (i < extra ? 1 : 0);
        }
        // verify sum
        int sum = 0;
        for (auto &kv : targets)
            sum += kv.second;
        if (sum != days * periods)
        {
            cerr << "Internal error: targets sum mismatch.\n";
            return false;
        }
        return true;
    }

    void buildPool()
    {
        pool.clear();
        for (auto &kv : targets)
        {
            for (int i = 0; i < kv.second; ++i)
                pool.push_back(kv.first);
        }
    }

    bool validPlace(int d, int p, const string &sub, const vector<vector<string>> &tt)
    {
        if (!avoid_consecutive)
            return true;
        // check previous period same day
        if (p > 0 && tt[d][p - 1] == sub)
            return false;
        // optional: check next if already filled
        if (p + 1 < periods && tt[d][p + 1] == sub)
            return false;
        return true;
    }

    bool tryGreedyPlacement(int maxAttempts)
    {
        int attempt = 0;
        placed.assign(days, vector<string>(periods, ""));
        vector<string> poolCopy;
        while (attempt < maxAttempts)
        {
            ++attempt;
            shuffle(pool.begin(), pool.end(), rng);
            poolCopy = pool;
            bool fail = false;
            for (int d = 0; d < days && !fail; ++d)
            {
                for (int p = 0; p < periods; ++p)
                {
                    bool placedHere = false;
                    // try linear scan for an item that fits
                    for (int idx = 0; idx < (int)poolCopy.size(); ++idx)
                    {
                        string cand = poolCopy[idx];
                        if (validPlace(d, p, cand, placed))
                        {
                            placed[d][p] = cand;
                            poolCopy.erase(poolCopy.begin() + idx);
                            placedHere = true;
                            break;
                        }
                    }
                    if (!placedHere)
                    {
                        fail = true;
                        break;
                    }
                }
            }
            if (!fail && poolCopy.empty())
            {
                // success
                return true;
            }
            // else try again
        }
        return false;
    }

    void fallbackFill()
    {
        // simple fallback: place pool items in order ignoring avoid_consecutive
        placed.assign(days, vector<string>(periods, ""));
        vector<string> poolCopy = pool;
        int idx = 0;
        for (int d = 0; d < days; ++d)
        {
            for (int p = 0; p < periods; ++p)
            {
                placed[d][p] = poolCopy[idx++];
            }
        }
    }

    void buildFinalTable()
    {
        table.assign(days, vector<Slot>(periods, Slot()));
        summary.clear();
        for (int d = 0; d < days; ++d)
        {
            for (int p = 0; p < periods; ++p)
            {
                string subj = placed[d][p];
                string fac = "TBD";
                auto it = faculty_map.find(subj);
                if (it != faculty_map.end())
                    fac = it->second;
                table[d][p] = Slot(subj, fac);
                summary[subj]++;
            }
        }
    }
};

// ----------   example testcases ----------
void runTC1()
{
    cout << "\n=== TC1: Default (Project Spec) ===\n";
    vector<string> subjects = {"Math", "Physics", "Chemistry", "English", "Computer", "History"};
    map<string, int> specials = {{"Sports", 1}, {"Library", 1}, {"Mentoring", 1}};
    map<string, string> faculty = {
        {"Math", "Abhishek Singh"},
        {"Physics", "Sanjeev Kumar"},
        {"Chemistry", "Shashank"},
        {"English", "Aayush Shah"},
        {"Computer", "Faculty X"},
        {"History", "Faculty Y"},
        {"Sports", "Faculty G"},
        {"Library", "Faculty H"},
        {"Mentoring", "Faculty I"}};
    TimeTableGenerator gen(5, 8, subjects, specials, faculty, true, 7);
    if (!gen.generate())
    {
        cerr << "Failed to generate TC1\n";
        return;
    }
    gen.printTimetable();
}

void runTC2()
{
    cout << "\n=== TC2: High special requirements (edge) ===\n";
    vector<string> subjects = {"Math", "Physics", "Chemistry", "English", "Computer", "History"};
    // require many special hours
    map<string, int> specials = {{"Sports", 3}, {"Library", 2}, {"Mentoring", 2}};
    map<string, string> faculty; // leave blank for brevity
    TimeTableGenerator gen(5, 8, subjects, specials, faculty, true, 13);
    if (!gen.generate())
    {
        cerr << "TC2 generation failed (likely infeasible or internal error)\n";
        return;
    }
    gen.printTimetable();
}

void runTC3()
{
    cout << "\n=== TC3: Small week ===\n";
    vector<string> subjects = {"Math", "Physics", "Chemistry", "English", "Computer", "History"};
    map<string, int> specials = {{"Sports", 1}, {"Library", 1}, {"Mentoring", 1}};
    TimeTableGenerator gen(3, 6, subjects, specials, {}, true, 21);
    if (!gen.generate())
    {
        cerr << "TC3 generation failed\n";
        return;
    }
    gen.printTimetable();
}

void runTC4()
{
    cout << "\n=== TC4: avoid_consecutive = false (allows repeats) ===\n";
    vector<string> subjects = {"Math", "Physics", "Chemistry", "English", "Computer", "History"};
    map<string, int> specials = {{"Sports", 1}, {"Library", 1}, {"Mentoring", 1}};
    TimeTableGenerator gen(5, 8, subjects, specials, {}, false, 99);
    if (!gen.generate())
    {
        cerr << "TC4 generation failed\n";
        return;
    }
    gen.printTimetable();
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cout << "TimeTable Generator - OOP C++ Implementation\n";
    runTC1();
    runTC2();
    runTC3();
    runTC4();

    cout << "\nAll testcases executed. Use screenshots of these outputs in PPT.\n";
    return 0;
}
