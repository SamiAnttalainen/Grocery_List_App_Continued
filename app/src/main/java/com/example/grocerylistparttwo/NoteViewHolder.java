package com.example.grocerylistparttwo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    TextView holderNote, holderNotice;


    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);

        holderNote = itemView.findViewById(R.id.tvNote);
        holderNotice = itemView.findViewById(R.id.tvNotice);
    }
}
