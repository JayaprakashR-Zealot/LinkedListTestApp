package com.cesit.linkedlisttestapplication;

/**
 * Created by JAYAPRAKASH-FGTS on 20-02-2018.
 */

public class LinkedListNode {

    public int previousHash=0;
    public String strAddedValue=null;
    public int nextHash=0;

    /**
     * Constructor
     */
    public LinkedListNode(int hashPrev,String data,int hashNext){
        this.strAddedValue = data;
        this.previousHash = hashPrev;
        this.nextHash = hashNext;
    }
}
