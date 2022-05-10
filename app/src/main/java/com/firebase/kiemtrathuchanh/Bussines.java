package com.firebase.kiemtrathuchanh;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Bussines extends AppCompatActivity {
    private DatabaseReference mDatabase;
    List<KhoaHoc> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussines);
        mDatabase = FirebaseDatabase.getInstance().getReference("KhoaHoc");

        list= new ArrayList<>();
        EditText txt = findViewById(R.id.editTextTextPersonName);
        EditText txt2 = findViewById(R.id.editTextTextPersonName2);
        Button btn = findViewById(R.id.button2);

        laydc(list);

        updateui();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhoaHoc a= new KhoaHoc(txt.getText().toString(),Integer.valueOf(txt2.getText().toString()));
                list.add(a);
                mDatabase.setValue(list);
                list = new ArrayList<>();
                laydc(list);
                updateui();
            }
        });

    }

    public void updateui(){
        ListView listView = (ListView) findViewById(R.id.idList);
        Adapter adt = new Adapter(this,R.layout.activity_deltail,list);
        listView.setAdapter(adt);

    }


    public  void laydc(List<KhoaHoc> list){

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    KhoaHoc c = postSnapshot.getValue(KhoaHoc.class);
                    list.add(c);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
    }


}