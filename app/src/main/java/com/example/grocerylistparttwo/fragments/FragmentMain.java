package com.example.grocerylistparttwo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.grocerylistparttwo.Note;
import com.example.grocerylistparttwo.NoteListAdapter;
import com.example.grocerylistparttwo.NoteStorage;
import com.example.grocerylistparttwo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMain extends Fragment {


    private NoteStorage noteStorage;
    private RecyclerView recyclerView;
    private TextView textView;
    private String importantStuff;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMain.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMain newInstance(String param1, String param2) {
        FragmentMain fragment = new FragmentMain();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        noteStorage = NoteStorage.getInstance();
        recyclerView = view.findViewById(R.id.rvNoteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new NoteListAdapter(getContext(), noteStorage.getNotes()));

        /*StringBuilder sb = new StringBuilder("Supertärkeät:\n");
        for (Note note : noteStorage.getNotes()) {
            if (note.important) {
                sb.append(note.getNote() + "\n");
            }
        }*/
        textView = view.findViewById(R.id.tVSuper);
        textView.setMovementMethod(new ScrollingMovementMethod());



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
        Log.d("FragmentMain", "Number of notes in storage: " + noteStorage.getNotes().size());
        StringBuilder sb = new StringBuilder("Supertärkeät:\n");
        for (Note note : noteStorage.getNotes()) {
            if (note.important) {
                sb.append(note.getNote() + "\n");
            }
        }
        textView.setText(sb.toString());
    }
}


/*
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*noteStorage = NoteStorage.getInstance();
        recyclerView = view.findViewById(R.id.rvNoteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new NoteListAdapter(getContext(), noteStorage.getNotes()));
        recyclerView.getAdapter().notifyDataSetChanged();

    }*/