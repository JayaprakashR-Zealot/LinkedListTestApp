package com.cesit.linkedlisttestapplication;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by JAYAPRAKASH-FGTS on 20-02-2018.
 */

public class DoublyLinkedList {

    private Node first;
    private Node last;


    public boolean isEmpty() {
        return (first == null);
    }

    // used to add a node at the start of linked list
    public void addDataAtFirst(String data){
        Node newNode = new Node(data);
        if (first == null)
            last = newNode;
        else
            first.previous = newNode;
        newNode.next = first;
        first = newNode; // first --> newNode
    }


    /*
     * Fetch data from Doubly LinkedList
     */
    public LinkedList<Node> fetchAddedData() {
        LinkedList<Node> listAddedData=new LinkedList<>();
        if(first==null){  //If LinkedList is in empty, throw exception.
            throw new LinkedListEmptyException("LinkedList doesn't contain any Nodes.");
        }

        Node tempDisplay = last; // start at the end of linkedList
        while (tempDisplay != null) {// Executes until we don't find start of list.
            //tempDisplay.displayNode();
            listAddedData.add(tempDisplay);
            tempDisplay = tempDisplay.previous; // move to previous Node
        }
        return listAddedData;
    }
}
