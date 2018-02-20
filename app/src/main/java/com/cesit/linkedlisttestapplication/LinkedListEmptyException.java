package com.cesit.linkedlisttestapplication;

/**
 * Created by JAYAPRAKASH-FGTS on 20-02-2018.
 */

/**
 *Exception to indicate that Doubly LinkedList is empty.
 */
class LinkedListEmptyException extends RuntimeException{
    public LinkedListEmptyException(){
        super();
    }

    public LinkedListEmptyException(String message){
        super(message);
    }
}