public class Heap {

    private int[] items;
    private int size;

    public Heap(int size) {
        items = new int[size];
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = value;
        bubbleUp();
//        Use the below line when using recursionBubbleUp
//        var index = size - 1;
//        var parentIndex = parent(index);
//        if (items[parentIndex] < value)
//            recursionBubbleUp(index, parentIndex);
    }

    public int remove() {
        if(isEmpty())
            throw new IllegalStateException();

        var root = items[0];
        items[0] = items[--size];
        bubbleDown();

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public int max() {
        if (isEmpty()) throw new IllegalStateException();
        return items[0];
    }

    public int[] sortArray(int[] numbers) {
        for (int number : numbers)
            insert(number);
        for (int i = numbers.length - 1; i >= 0; i--)
            numbers[i] = remove();
        return numbers;
    }

    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) return index;
        if (!hasRightChild(index)) return leftChildIndex(index);

        return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) return true;

        var isValid = items[index] >= leftChild(index);
        if(hasRightChild(index))
            isValid&= items[index] >= rightChild(index);

        return isValid;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private void recursionBubbleUp(int index, int parentIndex) {
        if (items[parentIndex] > items[index] || index == 0) return;

        var temp = items[parentIndex];
        items[parentIndex] = items[index];
        items[index] = temp;
        var nextParentIndex = parent(parentIndex);
        recursionBubbleUp(parentIndex, nextParentIndex);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }
}
