package com.cesit.linkedlisttestapplication;

/**
 * Created by JAYAPRAKASH-FGTS on 20-02-2018.
 */

public class HashNode<K,V> {

    K key;
    V value;

    // Reference to next node
    HashNode<K, V> next;

    // Constructor
    public HashNode(K key, V value)
    {
        this.key = key;
        this.value = value;
    }


}
