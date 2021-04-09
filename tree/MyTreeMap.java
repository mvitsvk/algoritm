package lesson6;

import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;
    private Integer leftLen;
    private Integer rigthLen;

    public MyTreeMap(){
        this.leftLen = 0;
        this.rigthLen = 0;
    }

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        //вот только надо ли хранить эту переменную вопрос...
        int length;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
            //вот только надо ли хранить эту переменную вопрос...
            length = 0;
        }
    }

    public Integer getLeftLen() {
        return leftLen;
    }

    public Integer getRigthLen() {
        return rigthLen;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key не должен быть null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        checkKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public boolean  isBalance(){
        return Math.abs (this.leftLen - this.rigthLen) > 1 ? false: true;
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        if (value == null) {
            //remove(key)
            return;
        }
        root = put(root, key, value, 0, 0);
    }

    private Node put(Node node, Key key, Value value, int LR, int len) {
        if (node == null) {
            if (LR < 0 && len > this.leftLen) {
                this.leftLen = len;
            }

            if (LR > 0 && len > this.rigthLen) {
                this.rigthLen = len;
            }
            Node temp = new Node(key, value);
            //вот только надо ли хранить эту переменную вопрос...
            temp.length = len;
            return temp;
        }

        int cmp = key.compareTo(node.key);

        //first init len
        if (cmp < 0 && LR == 0) {
            //this.leftLen++;
            LR = -1;
        };
        if (cmp > 0 && LR == 0) {
            //this.rigthLen++;
            LR = 1;
        };

        len++;

        if (cmp == 0) {
            node.value = value;

        } else if (cmp < 0) {
            node.left = put(node.left, key, value, LR, len);
        } else {
            node.right = put(node.right, key, value, LR, len);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key minKey() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;

        }
        return min(node.left);
    }

    public Key maxKey() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delele(Key key) {
        checkKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + "  " +
                node.key + " = " + node.value + "  " +
                toString(node.right);
    }
}
