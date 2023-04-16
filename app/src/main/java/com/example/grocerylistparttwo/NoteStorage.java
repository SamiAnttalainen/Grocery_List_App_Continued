package com.example.grocerylistparttwo;

import java.util.ArrayList;

public class NoteStorage {

    ArrayList<Note> notes = new ArrayList<>();

    private static NoteStorage noteStorage = null;

    private NoteStorage() {}

    public static NoteStorage getInstance() {
        if (noteStorage == null) {
            noteStorage = new NoteStorage();
        }
        return noteStorage;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public ArrayList<Note> getSuperNotes() {
        ArrayList<Note> superNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.important) {
                superNotes.add(note);
            }
        }
        return superNotes;
    }
}
