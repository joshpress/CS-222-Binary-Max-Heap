//Josh Press Binary Max Heap CS 222

public class Driver {

    public static void main(String args[]) {
        MaxHeap heap=new MaxHeap(10);
           heap.insert(15);
           heap.insert(7);
           heap.insert(11);
           heap.insert(3);
           heap.insert(1);
           heap.insert(2);
           heap.insert(10);
           //display before extracting max
           heap.display();
  
    heap.extract_max();

       heap.display();
    
    }
}
