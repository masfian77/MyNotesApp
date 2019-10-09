package com.example.mynotesapp.helper;

import android.database.Cursor;

import com.example.mynotesapp.entity.Note;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static android.provider.CallLog.Calls.DATE;
import static android.provider.MediaStore.Files.FileColumns.TITLE;
import static android.provider.MediaStore.Images.ImageColumns.DESCRIPTION;

public class MappingHelper {

    public static ArrayList<Note> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<Note> notesList = new ArrayList<>();
        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(_ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TITLE));
            String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DESCRIPTION));
            String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DATE));
            notesList.add(new Note(id, title, description, date));
        }
        return notesList;
    }

    public static Note mapCursorToObject(Cursor notesCursor) {
        notesCursor.moveToFirst();
        int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(_ID));
        String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TITLE));
        String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DESCRIPTION));
        String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DATE));
        return new Note(id, title, description, date);
    }
}
