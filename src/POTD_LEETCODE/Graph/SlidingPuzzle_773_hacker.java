package POTD_LEETCODE.Graph;

import java.util.HashMap;

class SlidingPuzzle_773_hacker {

    public static int slidingPuzzle(int[][] board) {
        String str = "";
        for (int[] arr : board)
            for (int num : arr)
                str += num;

        return map.getOrDefault(str, -1);
    }

    final static HashMap<String, Integer> map = new HashMap<>();
    static {
        map.put("302415", 16);
        map.put("321054", 20);
        map.put("214350", 18);
        map.put("412503", 5);
        map.put("340251", 15);
        map.put("410325", 11);
        map.put("021435", 15);
        map.put("254130", 10);
        map.put("253041", 14);
        map.put("015432", 7);
        map.put("013254", 15);
        map.put("314520", 16);
        map.put("502314", 14);
        map.put("140352", 15);
        map.put("523014", 10);
        map.put("143502", 15);
        map.put("501342", 12);
        map.put("502431", 16);
        map.put("140235", 17);
        map.put("210543", 13);
        map.put("234510", 14);
        map.put("043215", 7);
        map.put("024153", 9);
        map.put("302541", 18);
        map.put("340125", 11);
        map.put("301452", 12);
        map.put("240531", 13);
        map.put("345012", 10);
        map.put("105243", 16);
        map.put("432105", 19);
        map.put("512340", 14);
        map.put("245301", 13);
        map.put("421350", 14);
        map.put("532410", 18);
        map.put("034512", 13);
        map.put("132504", 15);
        map.put("402135", 18);
        map.put("123450", 0);
        map.put("031245", 15);
        map.put("145023", 18);
        map.put("204315", 16);
        map.put("241503", 11);
        map.put("205413", 16);
        map.put("420135", 19);
        map.put("305142", 8);
        map.put("230145", 5);
        map.put("254013", 10);
        map.put("351042", 14);
        map.put("532401", 17);
        map.put("520431", 15);
        map.put("245310", 14);
        map.put("142305", 15);
        map.put("042135", 17);
        map.put("234501", 15);
        map.put("025134", 9);
        map.put("325410", 14);
        map.put("341205", 15);
        map.put("251304", 17);
        map.put("523140", 8);
        map.put("210435", 17);
        map.put("134250", 16);
        map.put("432015", 18);
        map.put("154302", 13);
        map.put("403215", 6);
        map.put("345120", 10);
        map.put("124530", 12);
        map.put("352014", 12);
        map.put("053241", 15);
        map.put("035142", 7);
        map.put("031452", 11);
        map.put("032541", 19);
        map.put("054213", 11);
        map.put("053124", 11);
        map.put("534120", 12);
        map.put("143520", 14);
        map.put("015324", 13);
        map.put("014235", 17);
        map.put("352140", 10);
        map.put("254103", 9);
        map.put("451203", 9);
        map.put("431052", 10);
        map.put("412530", 6);
        map.put("540132", 9);
        map.put("450231", 11);
        map.put("041253", 9);
        map.put("325401", 13);
        map.put("025341", 15);
        map.put("243105", 5);
        map.put("021543", 13);
        map.put("134025", 14);
        map.put("153204", 13);
        map.put("213054", 14);
        map.put("054321", 15);
        map.put("052143", 5);
        map.put("312450", 14);
        map.put("354201", 13);
        map.put("534012", 12);
        map.put("402351", 14);
        map.put("014352", 15);
        map.put("503412", 16);
        map.put("501234", 16);
        map.put("314502", 15);
        map.put("354210", 12);
        map.put("342510", 16);
        map.put("241053", 10);
        map.put("042351", 15);
        map.put("214035", 18);
        map.put("512034", 16);
        map.put("453012", 18);
        map.put("301524", 18);
        map.put("345102", 9);
        map.put("241530", 12);
        map.put("135402", 5);
        map.put("401532", 8);
        map.put("425103", 19);
        map.put("403152", 18);
        map.put("145203", 17);
        map.put("203145", 4);
        map.put("521430", 14);
        map.put("231045", 16);
        map.put("305214", 10);
        map.put("542013", 8);
        map.put("415302", 9);
        map.put("542130", 8);
        map.put("304125", 12);
        map.put("230514", 13);
        map.put("342501", 17);
        map.put("023145", 3);
        map.put("134205", 15);
        map.put("423051", 10);
        map.put("452031", 14);
        map.put("453120", 20);
        map.put("410532", 7);
        map.put("314052", 16);
        map.put("102453", 2);
        map.put("514203", 13);
        map.put("103542", 16);
        map.put("032415", 17);
        map.put("315024", 12);
        map.put("350421", 13);
        map.put("531240", 16);
        map.put("014523", 13);
        map.put("253401", 13);
        map.put("413250", 6);
        map.put("310245", 13);
        map.put("012345", 15);
        map.put("120534", 13);
        map.put("304251", 14);
        map.put("125304", 11);
        map.put("251340", 16);
        map.put("250134", 9);
        map.put("421305", 13);
        map.put("543210", 14);
        map.put("541032", 10);
        map.put("213504", 13);
        map.put("135420", 4);
        map.put("435021", 10);
        map.put("210354", 19);
        map.put("150243", 15);
        map.put("524031", 16);
        map.put("342051", 16);
        map.put("025413", 17);
        map.put("405312", 10);
        map.put("542103", 7);
        map.put("243015", 6);
        map.put("521403", 13);
        map.put("520314", 15);
        map.put("530241", 15);
        map.put("034125", 13);
        map.put("514230", 14);
        map.put("351402", 13);
        map.put("420351", 15);
        map.put("145230", 18);
        map.put("143052", 16);
        map.put("250341", 15);
        map.put("034251", 15);
        map.put("035214", 9);
        map.put("531204", 17);
        map.put("205341", 14);
        map.put("325041", 14);
        map.put("450312", 11);
        map.put("510423", 13);
        map.put("543201", 13);
        map.put("102534", 14);
        map.put("413025", 4);
        map.put("412053", 4);
        map.put("152430", 4);
        map.put("415320", 10);
        map.put("320154", 13);
        map.put("425130", 20);
        map.put("315240", 12);
        map.put("130542", 17);
        map.put("130425", 3);
        map.put("423510", 8);
        map.put("201543", 12);
        map.put("240315", 15);
        map.put("425013", 18);
        map.put("312405", 15);
        map.put("423501", 9);
        map.put("530124", 11);
        map.put("043521", 11);
        map.put("243150", 6);
        map.put("132054", 14);
        map.put("430152", 19);
        map.put("213540", 14);
        map.put("430215", 7);
        map.put("215043", 18);
        map.put("351420", 14);
        map.put("513042", 16);
        map.put("201435", 16);
        map.put("350214", 11);
        map.put("120345", 13);
        map.put("231405", 15);
        map.put("520143", 7);
        map.put("204153", 8);
        map.put("503124", 10);
        map.put("504213", 12);
        map.put("401325", 12);
        map.put("354021", 14);
        map.put("150432", 5);
        map.put("503241", 14);
        map.put("451023", 10);
        map.put("543021", 12);
        map.put("405123", 20);
        map.put("153024", 12);
        map.put("024315", 15);
        map.put("413205", 5);
        map.put("031524", 19);
        map.put("053412", 17);
        map.put("051234", 17);
        map.put("310452", 13);
        map.put("205134", 8);
        map.put("504321", 14);
        map.put("502143", 6);
        map.put("041325", 13);
        map.put("120453", 1);
        map.put("150324", 13);
        map.put("302154", 12);
        map.put("140523", 13);
        map.put("245031", 12);
        map.put("340512", 15);
        map.put("305421", 12);
        map.put("045123", 19);
        map.put("052314", 13);
        map.put("510234", 15);
        map.put("123045", 2);
        map.put("312045", 16);
        map.put("125340", 12);
        map.put("203514", 12);
        map.put("405231", 10);
        map.put("051342", 13);
        map.put("052431", 15);
        map.put("142035", 16);
        map.put("013542", 17);
        map.put("012453", 3);
        map.put("013425", 3);
        map.put("402513", 6);
        map.put("230451", 13);
        map.put("253410", 14);
        map.put("324150", 14);
        map.put("235104", 7);
        map.put("103425", 2);
        map.put("041532", 9);
        map.put("154032", 12);
        map.put("453102", 19);
        map.put("024531", 15);
        map.put("045231", 11);
        map.put("514023", 14);
        map.put("510342", 13);
        map.put("531024", 18);
        map.put("315204", 11);
        map.put("032154", 13);
        map.put("035421", 11);
        map.put("201354", 18);
        map.put("042513", 7);
        map.put("152403", 3);
        map.put("102345", 14);
        map.put("341025", 14);
        map.put("104523", 12);
        map.put("023451", 11);
        map.put("154320", 14);
        map.put("451230", 10);
        map.put("021354", 19);
        map.put("431502", 9);
        map.put("103254", 14);
        map.put("513402", 15);
        map.put("235014", 8);
        map.put("105432", 6);
        map.put("231450", 14);
        map.put("534102", 11);
        map.put("401253", 8);
        map.put("532041", 18);
        map.put("124503", 11);
        map.put("501423", 12);
        map.put("524301", 15);
        map.put("530412", 17);
        map.put("410253", 7);
        map.put("504132", 10);
        map.put("541320", 12);
        map.put("512304", 15);
        map.put("045312", 11);
        map.put("214305", 17);
        map.put("452310", 12);
        map.put("324015", 14);
        map.put("153240", 14);
        map.put("104352", 14);
        map.put("321540", 20);
        map.put("430521", 11);
        map.put("132540", 16);
        map.put("043152", 17);
        map.put("105324", 12);
        map.put("104235", 16);
        map.put("541302", 11);
        map.put("540213", 13);
        map.put("341250", 16);
        map.put("350142", 9);
        map.put("125034", 10);
        map.put("421035", 14);
        map.put("142350", 16);
        map.put("415032", 8);
        map.put("123405", 1);
        map.put("524310", 16);
        map.put("521043", 14);
        map.put("310524", 17);
        map.put("523104", 9);
        map.put("250413", 15);
        map.put("432150", 20);
        map.put("215403", 17);
        map.put("452301", 13);
        map.put("450123", 21);
        map.put("431520", 10);
        map.put("513420", 14);
        map.put("324105", 13);
        map.put("130254", 15);
        map.put("051423", 11);
        map.put("540321", 13);
        map.put("023514", 11);
        map.put("054132", 11);
        map.put("124053", 10);
        map.put("204531", 14);
        map.put("012534", 15);
        map.put("251034", 18);
        map.put("435210", 8);
        map.put("320415", 15);
        map.put("321504", 19);
        map.put("235140", 6);
        map.put("234051", 16);
        map.put("240153", 7);
        map.put("403521", 10);
        map.put("215430", 18);
        map.put("352104", 11);
        map.put("015243", 17);
        map.put("203451", 12);
        map.put("420513", 7);
        map.put("304512", 14);
        map.put("301245", 14);
        map.put("152043", 4);
        map.put("435201", 9);
        map.put("135042", 6);
        map.put("320541", 19);
    }

}