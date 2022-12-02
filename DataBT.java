import java.util.HashSet;

class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;

    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }

    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
    }

    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    public boolean isBigger(int e) {
        return (this.data >= e);
    }

    public int countOccurrences(int num) {

        if(num == this.data) {
            return 1 + this.right.countOccurrences(num) + this.left.countOccurrences(num);
        }
        else
            return this.right.countOccurrences(num) + this.left.countOccurrences(num);
    }

    public HashSet<Integer> createElementsList() {
        HashSet<Integer> returnList = new HashSet<>();
        returnList.add(this.data);
        returnList.addAll(this.left.createElementsList());
        returnList.addAll(this.right.createElementsList());
        return returnList;
    }

    public boolean isHeap() {
        return this.left.isBigger(this.data) && this.right.isBigger(this.data) && this.left.isHeap() && this.right.isHeap();
    }

}