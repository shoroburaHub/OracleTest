package com.oracle.test.dao;

import com.oracle.test.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 12/30/2017.
 */
public interface NoteDao extends JpaRepository<Note, Long> {
}
