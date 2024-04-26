public class UnionFind {
    protected int[] parent; // array that holds/represents the subset
    protected int s1;
    protected int s2;
    public UnionFind(int size) {
        parent = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
        }
    }

    public int Find(int x) {
        // compress the paths as we seek out the root
        if (x == parent[x]){
            return x;
        }
        // so that, now, all members point to root
        parent[x] = Find(parent[x]);
        return parent[x];
    }

    public void Union(int x, int y) {
        int s1 = Find(x); // find which subset x is in
        int s2 = Find(y);  // find which subset y is in

        if(s1 != s2){ // if the sets are NOT the same, then join set x into set y
            parent[s1] = s2;
        }
    }

    public int Size() { // number of subsets
    // just count the roots found in the parent[ ] and return that count
        int count = 0;
        for(int i = 0; i < parent.length; i++){
            count++;
        }
        return count;
    }
}