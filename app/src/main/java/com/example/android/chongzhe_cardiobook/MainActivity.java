package com.example.android.chongzhe_cardiobook;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_NOTE_REQUEST = 1;

    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton buttononAddNote = findViewById(R.id.button_add_note);
        buttononAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                adapter.setNotes(notes);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            int priority = data.getIntExtra(AddNoteActivity.EXTRA_PRIOTITY,1);
            String date = data.getStringExtra(AddNoteActivity.EXTRA_DATE);
            String time = data.getStringExtra(AddNoteActivity.EXTRA_TIME);
            int systolic = data.getIntExtra(AddNoteActivity.EXTRA_SYSTOLIC,0);
            int diastolic = data.getIntExtra(AddNoteActivity.EXTRA_DIASTOLIC, 0);
            int heartrate = data.getIntExtra(AddNoteActivity.EXTRA_HEARTRATE, 0);
            String comments = data.getStringExtra(AddNoteActivity.EXTRA_COMMENTS);

            Note note = new Note(priority, date, time, systolic, diastolic, heartrate, comments);
            noteViewModel.insert(note);

            Toast.makeText(this, "Measurement Saved", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Measurement not saved", Toast.LENGTH_SHORT).show();
        }
    }
}
