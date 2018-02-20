package com.cesit.linkedlisttestapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements NodeRecyclerViewAdapter.ItemClickListener {


    private final String TAG="MainActivity";

    HashNode hashNode;
    ArrayList<LinkedListNode> listNodes=new ArrayList<>();
    LinkedListMap<Integer,String> map = new LinkedListMap<>();

    NodeRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*DoublyLinkedList doublyLinkedList=new DoublyLinkedList();

        doublyLinkedList.addDataAtFirst("First Data");
        doublyLinkedList.addDataAtFirst("Second Data");

        listAddedData=doublyLinkedList.fetchAddedData();

        Log.i(TAG,"Stored data from Linked list");
        for (int i=0;i<listAddedData.size();i++){
            Log.d(TAG,i+" ---"
                    +"------"+listAddedData.get(i).data);
        }*/

        // Adding data to Map
        map.add(1,"My First Node");
        map.add(2,"My second Node");
        map.add(3,"My third Node");

        loadList();

        loadDataToRecyclerView(listNodes);
    }

    private void loadList(){
        if(listNodes.size()>0) listNodes.clear();
        for (int i=1;i<=map.size();i++){
            hashNode=map.get(i);
            LinkedListNode node=new LinkedListNode(hashNode.key.hashCode(),hashNode.value.toString(),hashNode.value.hashCode());
            listNodes.add(node);
        }
    }

    private void loadDataToRecyclerView(ArrayList<LinkedListNode> listNodes){
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvLinkedList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NodeRecyclerViewAdapter(this, listNodes);
        adapter.setClickListener(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        LinkedListNode node= adapter.getItem(position);
        updateNodeValue(node);
        //Toast.makeText(this, "You clicked " + node.strAddedValue + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    private void updateNodeValue(final LinkedListNode node){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Node");
        alertDialog.setMessage("Update value");

        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        input.setText(node.strAddedValue);

        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        map.add(node.previousHash,input.getText().toString());
                        Toast.makeText(getApplicationContext(),
                                "Node is updated.", Toast.LENGTH_SHORT).show();
                        loadList();
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                });

        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

}
