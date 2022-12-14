package com.example.lab08_idnp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostulanteInfoActivity extends AppCompatActivity {
    public Helper helper = new Helper();
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);
        context = getApplicationContext();

        RecyclerView rv = findViewById(R.id.viewRegister);
        List<String> data = new ArrayList<>();
        String line;
        Scanner scanner = new Scanner(helper.readFile(context));
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            data.add(line);
        }
        scanner.close();

        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter= new MyAdapter(this, data);
        rv.setAdapter(adapter);
    }
}