import java.util.ArrayList;

public class Node {
    public Node left;
    public Node right;
    public Integer value;

    private static boolean isNodeExist(Node node) {
        return node != null && node.value != null;
    }

    private static void createNode(Node node, Integer value) {
        node.left = new Node();
        node.right = new Node();
        node.value = value;
    }

    private static void insert(Node node, int value) {
        if (!isNodeExist(node)) {
            createNode(node, value);
        } else if (value < node.value) {
            insert(node.left, value);
        } else {
            insert(node.right, value);
        }
    }

    private static Node getMin(Node node) {
        if (!isNodeExist(node))
            return null;

        if (!isNodeExist(node.left))
            return node;

        return getMin(node.left);
    }

    //todo
    private static Node getMax(Node node) {
        if (!isNodeExist(node))
            return null;

        if (!isNodeExist(node.right))
            return node;

        return getMax(node.right);
    }


    //todo
    private static Node search(Node node, int value) {
        return null;
    }


    private static void search2(Node node, int value) {
        if (!isNodeExist(node)) {
            return;
        }

        search2(node.left, value);

        if(node.value == value) {
            System.out.println("Value '" + value + "' is found!");
        }

        search2(node.right, value);
    }


    // Симметричный
    private static void inOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println("[" + node.value + "]");
        inOrderTraversal(node.right);
    }

    //todo: Прямой
    private static void directOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        System.out.println("[" + node.value + "]");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }

    //todo: Обратный
    private static void postOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
        System.out.println("[" + node.value + "]");
    }


    public static void main(String[] args) {
        Integer[] digit = { 6, 2, 5, 13, 9, 10, 14, 7, 33 };
        Node node = new Node();
        createNode(node, digit[0]);

        for (int i = 1; i < digit.length; i++) {
            insert(node, digit[i]);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("----- inOrderTraversal ------");
        inOrderTraversal(node);

        System.out.println("----- directOrderTraversal ------");
        directOrderTraversal(node);

        System.out.println("----- postOrderTraversal ------");
        postOrderTraversal(node);

        System.out.println("----- getMin ------");
        System.out.println(getMin(node).value);

        System.out.println("----- getMax ------");
        System.out.println(getMax(node).value);

        System.out.println("----- search2 ------");
        search2(node, 9);
    }
}
