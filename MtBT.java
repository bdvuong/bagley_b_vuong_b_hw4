import java.util.HashSet;

class MtBT implements IBinTree {
    MtBT(){}

    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }

    // returns 0 since empty tree has no elements
    public int size() {
        return 0;
    }

    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }

    public boolean isBigger(int e) {
        return true;
    }

    // returns 0 because an empty heap contains no elements
    public int countOccurrences(int num) {
        return 0;
    }
    public HashSet<Integer> createElementsList() {
        return null;
    }

    public boolean isHeap() {
        return true;
    }
}

