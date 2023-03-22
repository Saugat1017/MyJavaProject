package com.gradle.tutorial.Project.Project1;

import java.util.Iterator;

public class RoomBST<K extends Comparable<K>,V> implements Iterable<V>{
    private RoomNode root;
    private int size;

    public RoomBST() {
        root = null;
        size = 0;
    }

    public V find(K target) {
        return find(root, target);
    }

    public RoomNode getRoot() {
        return root;
    }

    // Internally, we have to keep track of the current RoomNode.
    private V find(RoomNode currentRoomNode, K key) {
        if (currentRoomNode == null) return null;
        int compareResult = key.compareTo(currentRoomNode.getKey());
        if (compareResult == 0) return currentRoomNode.value;
        if (compareResult < 0)
            // Return the result of find in the left subtree.
            return find(currentRoomNode.left, key);
        return find(currentRoomNode.right, key);
    }


    /*
     * Insert strategy:
     * - If the current root is null, replace current root with a
     *      new RoomNode containing the item
     * - If the item equals the current root RoomNode's data, do nothing.
     * - If item < current root RoomNode's data, recursively insert into left subtree.
     * - If item > current root RoomNode's data, recursively insert into right subtree.
     */

    public boolean add(K key, V value) {
        int oldSize = size;
        root = add(root, key, value);
        return oldSize != size;
    }

    private RoomNode add(RoomNode currentRoomNode, K key, V value) {
        if (currentRoomNode == null) {
            size++;
            return new RoomNode(key, value);
        }
        if (key.compareTo(currentRoomNode.getKey()) == 0) {
            return currentRoomNode;
        }
        if (key.compareTo(currentRoomNode.getKey()) < 0) {
            // Go left, and store the left RoomNode in the left.
            currentRoomNode.left = add(currentRoomNode.left, key, value);
            currentRoomNode.left.parent=currentRoomNode;
            return currentRoomNode;
        }
        //else (item.compareTo(currentRoomNode.data) > 0) {
        currentRoomNode.right = add(currentRoomNode.right, key, value);
        currentRoomNode.right.parent=currentRoomNode;
        return currentRoomNode;
        //}
    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private RoomNode remove(RoomNode currentRoomNode, K key) {
        if (currentRoomNode == null) {
            return null;
        }else if (key.compareTo(currentRoomNode.getKey()) < 0) {
            currentRoomNode.left = remove(currentRoomNode.left, key);
        }else if (key.compareTo(currentRoomNode.getKey()) > 0) {
            currentRoomNode.right =  remove(currentRoomNode.right, key);
        }else if (key.compareTo(currentRoomNode.getKey()) == 0) {

            if (currentRoomNode.left == null && currentRoomNode.right == null) {
                return null;
            }else if (currentRoomNode.left != null && currentRoomNode.right == null) {
                return currentRoomNode.left;
            }else if (currentRoomNode.left == null) {
                return currentRoomNode.right;
            }

            RoomNode newNode= findPredeceser(currentRoomNode);
            remove(newNode.key);
            newNode.left = currentRoomNode.left;
            newNode.right = currentRoomNode.right;
            currentRoomNode=newNode;
        }
        return currentRoomNode;
    }


    private RoomNode findPredeceser(RoomNode current) {
       RoomNode temp = current.left;
          while(temp.right != null){
              temp = temp.right;
          }
       return temp;
    }


    public String toString() {
        if (root == null) return "null";
        return root.toString();
    }

    @Override
    public Iterator<V> iterator() {
        return new TreeIterator<V>(root);
    }

    public class RoomNode {
        // The data stored in the node
        private V value;

        private K key;
        // The root of the left subtree
        protected RoomNode left;

        // The root of the right subtree
        protected RoomNode right;
        protected RoomNode parent;

        public RoomNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        public RoomNode getLeft() {
            return left;
        }

        public RoomNode getRight() {
            return right;
        }

        public RoomNode getParent() {
            return parent;
        }

        public String toString() {
        return "(" + left + " - " + value + " - " + right + ")";
        //return data.toString();
    }

        public K getKey() {
            return key;
        }
    }

    public class TreeIterator<V> implements Iterator<V>{
        private RoomNode currentRoomNode;
        public TreeIterator (RoomNode currentRoomNode){
            this.currentRoomNode = root;
        }

        @Override
        public boolean hasNext() {
            return (currentRoomNode != null);
        }

        @Override
        public V next() {
            if(currentRoomNode.left == null) {
                currentRoomNode.value = currentRoomNode.parent.value;
                currentRoomNode = currentRoomNode.right;
            }
            else{
                currentRoomNode.parent= currentRoomNode.left;
                while(((currentRoomNode.parent.right != currentRoomNode) && (currentRoomNode.parent.left != currentRoomNode))) {
                    currentRoomNode.parent= currentRoomNode.parent.right;
                }
            }
            if(currentRoomNode.right == null){
               currentRoomNode.parent.right=currentRoomNode;
               currentRoomNode=currentRoomNode.left;
            }
            else{
                currentRoomNode.parent.right = null;
                currentRoomNode.value = currentRoomNode.parent.value;
                currentRoomNode= currentRoomNode.right;
            }
            V value = (V) currentRoomNode.value;
            return value;
        }
    }

    public void traverse(){
        if(root != null) {
            traverse(root);
        }

    }
    public void traverse(RoomNode currentNode){
        if(currentNode.left != null){
            traverse(currentNode.left);
        }
        System.out.println(currentNode.value);
        System.out.println("___________________");
        if(currentNode.right != null){
            traverse(currentNode.right);
        }

    }

}



