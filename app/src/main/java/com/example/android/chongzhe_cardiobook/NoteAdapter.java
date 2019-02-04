package com.example.android.chongzhe_cardiobook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.note_item,viewGroup, false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int i) {
        Note currentNote = notes.get(i);
        noteHolder.textViewDate.setText("date: " + currentNote.getDate());
        noteHolder.textViewTime.setText("time: " + currentNote.getTime());
        noteHolder.textViewSystolic.setText("Systolic Pressure : " + String.valueOf(currentNote.getSystolic_Pressure()));
        noteHolder.textViewDiastolic.setText("Diastolic Pressure : " + String.valueOf(currentNote.getDiastolic_Pressure()) );
        noteHolder.textViewHeartRate.setText("Heart Rate : " + String.valueOf(currentNote.getHeart_Rate()));
        noteHolder.textViewComments.setText("Comments : " + currentNote.getComment());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewMeasurement;
        private TextView textViewDate;
        private TextView textViewTime;
        private TextView textViewSystolic;
        private TextView textViewDiastolic;
        private TextView textViewHeartRate;
        private TextView textViewComments;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewMeasurement = itemView.findViewById(R.id.text_view_measurement);
            textViewDate = itemView.findViewById(R.id.text_view_date);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewSystolic = itemView.findViewById(R.id.text_view_systolic);
            textViewDiastolic = itemView.findViewById(R.id.text_view_diastolic);
            textViewHeartRate = itemView.findViewById(R.id.text_view_heartRate);
            textViewComments = itemView.findViewById(R.id.text_comment);
        }
    }
}
