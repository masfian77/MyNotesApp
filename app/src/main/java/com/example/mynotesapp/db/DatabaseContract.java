package com.example.mynotesapp.db;

import android.net.Uri;
import android.provider.BaseColumns;

public final class DatabaseContract {

    public static final String AUTHORITY = "com.example.mynotesapp";
    private static final String SCHEME = "content";

    private DatabaseContract(){}

    public static final class NoteColumns implements BaseColumns {

        public static final String TABLE_NAME = "note";
        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String DATE = "date";

        public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build();
    }
}
