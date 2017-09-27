package com.example.demo.mapper;

import com.example.demo.entity.notes.Notes;
import com.example.demo.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * Created by Administrator on 2017/7/26.
 */
@Repository(value="iNotesMapper")
public interface INotesMapper {
    public List<Notes> queryNotesByUserId(User user);

    public int insertNotes(Notes notes);
    public int updateNotesByNotiesId(Notes notes);
    public int deleteNotiesByNotiesId(Notes notes);
    public Notes queryNotesByNotiesId(Notes notes);
}
