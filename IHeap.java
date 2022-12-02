interface IHeap extends IBinTree {
 // adds given element to the heap without removing other elements
 IHeap addElt(int e);

 // removes one occurrence of the smallest element from the heap
 IHeap remMinElt();

 // Merge the current heap with another heap
 IHeap merge(IHeap withHeap);

 // Determine if the root of this heap is bigger than the given element
 boolean isBigger(int e);

 // Determine if a given heap is a heap
 boolean isHeap();

 // Determine number of occurrences of an element (dev note: can technically just start at a subtree and continue down technically...?)
 int countOccurrences(int num);


}




