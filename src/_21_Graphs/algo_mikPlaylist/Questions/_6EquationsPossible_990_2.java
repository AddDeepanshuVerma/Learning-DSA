package _21_Graphs.algo_mikPlaylist.Questions;

class _6EquationsPossible_990_2 {
    int[] parent;

    int find(int i) {
        if(i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(parentB != parentA) {
            parent[parentB] = parentA;
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        for (int i = 0; i < 26; i++)
            parent[i] = i;

        for (String s : equations) {
            if(s.charAt(1) == '=')
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
        }

        for (String s : equations) {
            if(s.charAt(1) == '!')
                if(find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a'))
                    return false;
        }
        return true;
    }
}