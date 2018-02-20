package com.cesit.linkedlisttestapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by JAYAPRAKASH-FGTS on 20-02-2018.
 */

public class LinkedListMap<K, V> {
    private final String TAG="LinkedListMap";
    // bucketArray is used to store array of chains
    private LinkedList<HashNode<K, V>> bucketArray;

    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    // Constructor (Initializes capacity, size and
    // empty chains.
    public LinkedListMap()
    {
        bucketArray = new LinkedList<>();
        numBuckets = 10;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    // This implements hash function to find index
    // for a key
    private int getBucketIndex(K key)
    {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }


    // Adds a key value pair to hash
    public void add(K key, V value) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * size) / numBuckets >= 0.7) {
            LinkedList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new LinkedList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }

        }
        if(newNode!=null) {
            Log.d(TAG,"Next Hash:"+newNode.value.hashCode());
        }

    }

    // Returns value for a key
    //public V get(K key)
    public HashNode<K, V> get(K key)
    {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Search key in chain
        while (head != null)
        {
            if (head.key.equals(key))
                return head;
            head = head.next;
        }

        // If key not found
        return null;
    }



}
