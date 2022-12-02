import java.util.HashSet;

interface IBinTree {

 // determines whether element is in the tree
 boolean hasElt(int e);

 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();

 // returns depth of longest branch in the tree
 int height();

 // Determine if the root of this heap is bigger than the given element
 boolean isBigger(int e);

 // Determine number of occurrences of an element in a given tree
 /**
  * Count the number of times a number occurs within a given tree
  * @param num a number we are looking for
  * @return the number of times that number occurs
  */
 int countOccurrences(int num);

 // Creates an array list of all elements within the tree
 /**
  * creates a HashSet of a heap and its children
  * @return a HashSet of the root and its children roots
  */
 HashSet<Integer> createElementsList();

 // Determine if the given tree is a heap based on the basic definition of a heap
 /**
  * Determines if the root and its children are heaps
  * @return true if the root and all of its children are heaps
  *         false if a root/children does not follow the
  *         attributes of a heap.
  */
 boolean isHeap();

}

