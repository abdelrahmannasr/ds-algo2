public class AVLTree {

    private class AVLNode {
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "node= " + value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {

        if (root == null) {
            return new AVLNode(value);
        }

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        root.height = resetHeight(root);

        return balance(root);
    }

    private AVLNode balance(AVLNode root) {
        if (isHeavyLeft(root)) {
            System.out.println("Left Heavy " + root.value);
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = leftRotate(root.leftChild);
            return rightRotate(root);
        } else if (isHeavyRight(root)) {
            System.out.println("Right Heavy " + root.value);
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rightRotate(root.rightChild);
            return leftRotate(root);
        }
        return root;
    }

    private AVLNode leftRotate(AVLNode root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        root.height = resetHeight(root);
        newRoot.height = resetHeight(newRoot);
        return newRoot;
    }

    private AVLNode rightRotate(AVLNode root) {
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        root.height = resetHeight(root);
        newRoot.height = resetHeight(newRoot);
        return newRoot;
    }

    private int resetHeight(AVLNode node) {
        return  Math.max(
                height(node.leftChild),
                height(node.rightChild)
        ) + 1;
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private boolean isHeavyLeft(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isHeavyRight(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }
}
