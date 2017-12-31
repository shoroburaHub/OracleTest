package com.oracle.test.serviceImpl;

import com.oracle.test.dao.NoteDao;
import com.oracle.test.entity.Note;
import com.oracle.test.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteDao noteDao;

    @Override
    public void save(Note note) {
        noteDao.save(note);
    }

    @Override
    public List<Note> findAll() {
        return noteDao.findAll();
    }
}
