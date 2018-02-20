package com.cesit.linkedlisttestapplication;

/**
 * Created by JAYAPRAKASH-FGTS on 20-02-2018.
 */

/**
 *Node class, which holds data and contains next which points to next Node.
 */
class Node {
    public String data; // data in Node.
    public Node next; // points to next Node in list.
    public Node previous; // points to previous Node in list.


    /**
     * Constructor
     */
    public Node(String data){
        this.data = data;
    }

    /**
     * Display Node's data
     */
    public void displayNode() {
        System.out.print( data + " ");
    }

}