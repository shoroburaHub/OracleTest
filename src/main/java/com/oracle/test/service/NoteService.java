package com.oracle.test.service;

import com.oracle.test.entity.Note;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
public interface NoteService {

    void save(Note note);
    List<Note> findAll();

}
