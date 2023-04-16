package com.example.grocerylistparttwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private Context context;
    private ArrayList<Note> notes = new ArrayList<>();

    public NoteListAdapter(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.note_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        holder.holderNote.setText(notes.get(position).getNote());
        holder.holderNotice.setText(notes.get(position).getNotice());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
