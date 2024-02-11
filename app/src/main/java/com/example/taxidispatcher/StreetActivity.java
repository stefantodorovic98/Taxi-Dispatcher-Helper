package com.example.taxidispatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.taxidispatcher.adapter.CustomBaseAdapter;
import com.example.taxidispatcher.model.Street;
import com.example.taxidispatcher.util.StreetUtil;

import java.util.LinkedList;
import java.util.List;

public class StreetActivity extends AppCompatActivity {

    List<Street> streetList = new LinkedList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        streetList = StreetUtil.getStreetForLetter(text);

        CustomBaseAdapter customBaseAdapter =
                new CustomBaseAdapter(this, this.streetList);
        listView = (ListView) findViewById(R.id.customListView);
        listView.setAdapter(customBaseAdapter);
    }
    
}