package Contest.Weekly_Contest._416;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ReportSpam_3295 {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> banned = new HashSet<>(Arrays.asList(bannedWords));

        int count = 0;
        for (int i = 0; i < message.length; i++) {
            if (banned.contains(message[i])) {
                count++;
                if (count == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}