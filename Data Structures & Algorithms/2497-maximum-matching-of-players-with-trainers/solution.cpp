class Solution {
public:
    int matchPlayersAndTrainers(vector<int>& players, vector<int>& trainers) {
        // Sort both arrays to enable greedy matching
        sort(players.begin(), players.end());
        sort(trainers.begin(), trainers.end());
        
        int matches = 0;  // Count of successful matches
        int playerIndex = 0;  // Pointer for players array
        int trainerIndex = 0;  // Pointer for trainers array
        
        // Use two pointers to find optimal matches
        while (playerIndex < players.size() && trainerIndex < trainers.size()) {
            // If current trainer can train current player
            if (trainers[trainerIndex] >= players[playerIndex]) {
                matches++;  // Successful match found
                playerIndex++;  // Move to next player
            }
            // Always move trainer pointer forward
            // (either we used this trainer or need a better one)
            trainerIndex++;
        }
        
        return matches;
    }
};
