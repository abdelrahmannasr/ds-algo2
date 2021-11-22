public class MaxHeap {

    public static void heapify(int[] array) {
        // First step find the last parent node
        // then reverse loop direction and starting with the last parent index
        // this for optimization our heapify method as we sgoing to start from
        // the deepest parent node a lot of these nodes are going to in right position
        var lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0 ; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftChildIndex = index * 2 + 1;
        if (leftChildIndex < array.length && array[leftChildIndex] > array[largerIndex])
            largerIndex = leftChildIndex;

        var rightChildIndex = index * 2 + 2;
        if (rightChildIndex < array.length && array[rightChildIndex] > array[largerIndex])
            largerIndex = rightChildIndex;

        if (largerIndex == index) return;

        swap(array, index, largerIndex);

        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new Heap(array.length);

        for (var item : array)
            heap.insert(item);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }
}
