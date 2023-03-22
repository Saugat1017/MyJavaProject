//package com.gradle.tutorial.Project.Project1;
//
//
//import org.w3c.dom.Node;
//
///**
// * a list where individual are wrapped in Nodes
// * @param <E>
// */
//
//public class LinkedList<E> {
//    private Node<E> head;
//    private Node<E> tail;
//    private int size;
//
//    public LinkedList(){
//        head=null;
//        tail=null;
//        size=0;
//    }
//    /**
//     * tracks data
//     * @param data the data to add
//     */
//    private void addFirst( E data){
//        head= null;
//        Node<E> newNode = new Node<>(data);
//        newNode.next=head;
//        head=newNode;
//
//        head= new Node<E>(data,head);
//        size++;
//
//    }
//    /**
//     * @param data to data to add
//     */
//
//    private void addLast( E data){
//        tail= null;
//        Node<E> newNode = new Node<>(data);
//        newNode.next=tail;
//        tail=newNode;
//        tail= new Node<E>(data,head);
//        size++;
//    }
//    /**
//     * Add a new node fpr data after node
//     * @param data the new data to add
//     * @param node the prior to the new node.
//     */
//    private void addAfter(E data, Node<E> node){
//        node.next= new node<>(data,node.next);
//        size++;
//    }
//    /**
//     * Add an element at the index
//     * @param data the data to add
//     * @param idx the index to add at
//     */
//    public void add(E data, int idx){
//        if(idx<0 || idx> size){
//            throw new IndexOutOfBoundsException();
//
//        }
//        if(idx==0){
//            addFirst(data);
//
//        }
//    }
//}
