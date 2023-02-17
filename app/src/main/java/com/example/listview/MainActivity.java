package com.example.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.SortedList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> ContactList;
    private Adapter ListAdapter;
    private EditText etSearch,Phone,ID,Name;
    private ListView lstContact;
    private FloatingActionButton btnAdd;
    private FloatingActionButton btnOK;
    private static  long SelectedId;
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactList = new ArrayList<>();
        ContactList.add(new Contact(1,"img","Nguyễn Văn Huan","34251821"));
        ContactList.add(new Contact(2,"img2","Nguyễn Văn QQ","15151821"));
        ContactList.add(new Contact(3,"img3","Hoàng Thái Bình","12341821"));
        ListAdapter = new Adapter(ContactList,this);
        etSearch = findViewById(R.id.etSearch);
        lstContact = findViewById(R.id.LstContact);
        btnAdd = findViewById(R.id.floatingActionButton);
        lstContact.setAdapter(ListAdapter);
        registerForContextMenu(lstContact);
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        Bundle bundle = new Bundle();
        startActivityForResult(intent,100);


        lstContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SelectedId = l;
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }



    String a[],b[];
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.mnuEdit:
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                Contact c = ContactList.get((int) SelectedId);
                Bundle b = new Bundle();
                b.putInt("Id",c.getId());
                b.putString("Image",c.getImages());
                b.putString("Name",c.getName());
                b.putString("Phone",c.getPhone());
                intent.putExtras(b);
                startActivityForResult(intent,200);
                break;
            case R.id.menuSortName:
//                Collections.sort(ContactList,new Comparator<Contact>(){
//                    public int compare(Contact s1,Contact s2){
//                        a = s1.getName().split(" ");
//                        b= s2.getName().split(" ");
//                        return a[a.length - 1].compareTo(b[b.length-1]);
//                    }
//                });
//                lstContact.setAdapter(ListAdapter);
//                registerForContextMenu(lstContact);
//                break;
            case R.id.menuSortPhone:
                Collections.sort(ContactList,new Comparator<Contact>(){
                    public int compare(Contact s1,Contact s2){
                        return s1.getPhone().compareTo(s2.getPhone());
                    }
                });
                lstContact.setAdapter(ListAdapter);
                registerForContextMenu(lstContact);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
