package com.example.grocerylistparttwo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.grocerylistparttwo.Note;
import com.example.grocerylistparttwo.NoteListAdapter;
import com.example.grocerylistparttwo.NoteStorage;
import com.example.grocerylistparttwo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAdd#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAdd extends Fragment {

    public EditText textNote, textNotice;
    public String note, notice;
    public Boolean important;
    public RadioButton radioButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAdd() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAdd.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAdd newInstance(String param1, String param2) {
        FragmentAdd fragment = new FragmentAdd();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_add, container, false);
        textNote = view.findViewById(R.id.editNoteName);
        textNotice = view.findViewById(R.id.editNotice);
        radioButton = view.findViewById(R.id.rbBoolean);

        Button addNewNote = view.findViewById(R.id.buttonAddNote);
        addNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote(view);
            }
        });
        return view;
    }

    public void addNote(View view) {
        note = textNote.getText().toString();
        notice = textNotice.getText().toString();

        if (radioButton.isChecked()) {
            important = true;
        }
        else {
            important = false;
        }

        Note newNote = new Note(note, notice, important);
        NoteStorage.getInstance().addNote(newNote);
        System.out.println("Listassa on " + NoteStorage.getInstance().getNotes().size() + " muistiinpanoa.");
    }
}