package _21_Graphs.Leetcode;

class EquationsPossible_990 {
    int[] parent;
    int[] rank;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentB != parentA) {
            parent[parentB] = parentA;
        }
    }

    public boolean equationsPossible(String[] equations) {
        parent = new int[130];
        for (int i = 0; i < 130; i++)
            parent[i] = i;

        for (String s : equations) {
            if (s.charAt(1) == '!')
                continue;
            // now all s are of == type
            int u = s.charAt(0);
            int v = s.charAt(3);
            union(u, v);
        }

        for (String s : equations) {
            if (s.charAt(1) == '=')
                continue;
            // now all s are of != type
            int u = s.charAt(0);
            int v = s.charAt(3);
            if(find(u) == find(v)) {
                return false;
            }
        }
        return true;
    }
}