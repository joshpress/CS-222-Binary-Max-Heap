
//Josh Press Binary Max Heap CS 222

public class MaxHeap {
    // array based implementation, create an array for the heap
    // data items
    private int[] heap;

    // data items
    private int position;
    private int capacity;

    // take in a value for the size of the array, and make the array
    public MaxHeap(int value) {
        position = 1;
        capacity = value;
        heap = new int[capacity];
    }

    public void insert(int value) {

        // only run if the heap is not full
        if (position == capacity - 1) {
            System.out.print("Heap full");

        } else {
            // set the value at the end of the heap
            heap[position] = value;
            // recursively heapify up
            heapifyUp(position);
            // increment the position
            position++;

        }
    }

    // heapify up
    private void heapifyUp(int value) {
        // get the parent and current values
        int parent = value / 2;
        int current = value;
        // while the parent is greater than 0 and the heap's value is greater than the
        // parent
        while (parent > 0 && heap[current] > heap[parent]) {
            // swap the current and parent values
            int temp = heap[current];
            heap[current] = heap[parent];
            heap[parent] = temp;

            current = parent;
            parent = current / 2;
        }

    }

    public int extract_max() {
        // if the heap is empty
        if (position == 1) {
            System.out.println("The Heap is empty.");
            return 0;
        } else {
            // get the max value
            int max = heap[1];
            // remove the max value (set it to the next value)
            heap[1] = heap[position - 1];
            position--;
            // recursively heapify down from the root to fix the tree
            heapifyDown(1);
            System.out.println("Max = " + max);
            return max;
        }
    }

    // heapify down method
    private void heapifyDown(int index) {
        // get the left, right and max values
        int left = 2 * index;
        int right = 2 * index + 1;
        int max = index;
        // if left is smaller, set it to the left
        if (left < position && heap[left] > heap[max]) {
            max = left;
        }
        // if the right is smaller, set it to the right
        if (right < position && heap[right] > heap[max])
            max = right;

        if (max != index) {
            // swap the value and max
            int temp = heap[index];
            heap[index] = heap[max];
            heap[max] = temp;
            heapifyDown(max);
        }
    }

    public void display() {
        // print out the array
        System.out.print("[");
        for (int i = 1; i < position; i++) {
            System.out.print(heap[i] + ",");
        }
        System.out.println("]");

        // start at the first index
        display_recursive(1, 0);
    }

    private void display_recursive(int index, int level) {
        // get the left and right values
        int left = 2 * index;
        int right = 2 * index + 1;
        // only run if the heap index is not 0 and the end of the array has not been
        // reached
        if (index < position && heap[index] != 0) {

            // recursively display the left value
            display_recursive(right, level + 1);

            // add a space
            for (int i = 0; i < level; i++) {
                System.out.print("     ");
            }
            // print the value and recursively display the right value
            System.out.println(heap[index]);
            display_recursive(left, level + 1);

        }
    }
}
