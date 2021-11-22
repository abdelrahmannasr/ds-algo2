import java.util.*;

public class main {

    public static void main(String[] args) {
//        Tree
//        Tree tree = new Tree();
//        tree.insert(7);
//        tree.insert(4);
//        tree.insert(9);
//        tree.insert(1);
//        tree.insert(6);
//        tree.insert(8);
//        tree.insert(10);
//        tree.traverseLevelOrder();
//        System.out.println(tree.getNodeAtK(1));
//        tree.swapRoot();
//        System.out.println(tree.isBinarySearchTree());
//        Tree tree1 = new Tree();
//        tree1.insert(7);
//        tree1.insert(4);
//        tree1.insert(9);
//        tree1.insert(1);
//        tree1.insert(6);
//        tree1.insert(8);
//        tree1.insert(11);
//        System.out.println(tree.equals(tree1));
//        System.out.println(tree.height());
//        System.out.println(tree.min());
//        System.out.println(tree.minBinarySearchTree());
//        tree.traversePreOrder();
//        System.out.println("======================");
//        tree.traverseInOrder();
//        System.out.println("======================");
//        tree.traversePostOrder();
//        System.out.println(tree.find(50));
//        Recursion
//        System.out.println(factorial(4));
//        int N = 10;
//        for (int i = 0; i < N; i++) {
//            System.out.print(fib(i) + " ");
//        }
//        var result = "";
//        System.out.println(findBinary(223, result));
//        AVL Tree
//        AVLTree avlTree = new AVLTree();
//        avlTree.insert(20);
//        avlTree.insert(10);
//        avlTree.insert(15);
//        Heap
//        Heap heap = new Heap(6);
//        heap.insert(10);
//        heap.insert(5);
//        heap.insert(17);
//        heap.insert(4);
//        heap.insert(22);
//        System.out.println( heap.remove());
//        Sort Heap
//        int[] numbers = {5, 3, 10, 1, 4, 2};
//        var heap = new Heap(6);
//        for (var number: numbers)
//            heap.insert(number);
//        // Desc order
//        for (int i = 0; i < numbers.length; i++)
//            numbers[i] = heap.remove();
//        System.out.println("Desc Order "+ Arrays.toString(numbers));
//
//        for (var number: numbers)
//            heap.insert(number);
//        // Asc order
//        for (int i = numbers.length - 1; i >= 0; i--)
//            numbers[i] = heap.remove();
//        System.out.println("Asc Order "+ Arrays.toString(numbers));
//        Heapify
//        int[] numbers = {5, 3, 8, 4, 1, 2};
//        MaxHeap.heapify(numbers);
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(MaxHeap.getKthLargest(numbers, 1));
//        Trie
//        var trie =  new Trie();
//        trie.insert("car");
//        trie.insert("card");
//        trie.insert("care");
//        trie.insert("careful");
//        trie.insert("egg");
//        System.out.println(trie.contains("care"));
//        trie.preOrderTraverse();
//        System.out.println("====================");
//        trie.postOrderTraverse();
//        trie.remove(null);
//        System.out.println(trie.contains("car"));
//        System.out.println(trie.contains("care"));
//        var words = trie.findWords("c");
//        System.out.println(words);
//        Graph
//        Graph graph = new Graph();
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addNode("D");
//        graph.addEdge("A" , "B");
//        graph.addEdge("B" , "D");
//        graph.addEdge("D" , "C");
//        graph.addEdge("A" , "C");
//        graph.removeEdge("D", "C");
//        graph.removeNode("A");
//        graph.addEdge("B" , "C");
//        graph.print();
//        graph.traverseDepth("C");
//        graph.traverseBreadthFirst("C");
//        graph.addNode("X");
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("P");
//        graph.addEdge("X" , "A");
//        graph.addEdge("X" , "B");
//        graph.addEdge("A" , "P");
//        graph.addEdge("P" , "A");
//        System.out.println(graph.topologicalSort());
//        System.out.println(graph.hasCycle());
//        System.out.println("done");
//        Find Substring
//        System.out.println(findSubstrings("bcada"));
//        Weighted Graph
//        var weightedGraph = new WeightedGraph();
//        weightedGraph.addNode("A");
//        weightedGraph.addNode("B");
//        weightedGraph.addNode("C");
//        weightedGraph.addNode("D");
//        weightedGraph.addEdge("A", "B", 3);
//        weightedGraph.addEdge("B", "D", 4);
//        weightedGraph.addEdge("C", "D", 5);
//        weightedGraph.addEdge("A", "C", 1);
//        weightedGraph.addEdge("B", "C", 2);
//        var tree = weightedGraph.getMinSpinningTree();
//        tree.print();
//        System.out.println(weightedGraph.hasCycle());
//        var path = weightedGraph.getShortestPath("K", "C");
//        System.out.println(path);
//        weightedGraph.print();
//        Sort Array
//        int[] numbers = {5, 3, 10, 1, 4, 2};
//        Heap heap = new Heap(numbers.length);
//        var output = heap.sortArray(numbers);
//        System.out.println(Arrays.toString(output));
    }

    // Recursion
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n -1) + fib(n-2);
    }

    public static String findBinary(int decimal, String result) {
        if (decimal == 0)
            return result;

        result = decimal % 2 + result;
        return findBinary(decimal/2, result);
    }

    public static int findSubstrings(String s) {
        // Write your code here
        Set<String> set = new HashSet<>();
        int outOfCount = 0;

        for (int i=0; i < s.length(); i++) {
            boolean[] arr = new boolean[26];

            String subStr = "";

            for (int j = i; j < s.length(); j++) {

                int current = s.charAt(j) - 'a';

                if (arr[current] == true) break;

                arr[current] = true;

                subStr += s.charAt(j);


                if (set.contains(subStr) && subStr.length() == 1)
                    outOfCount++;

                set.add(subStr);
            }
        }

        return set.size() + outOfCount;
    }
}
