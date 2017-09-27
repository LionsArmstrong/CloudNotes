package com.example.demo.service.user;

import com.example.demo.entity.notes.Notes;
import com.example.demo.entity.user.User;

import java.util.List;

public interface INotesService {

	public List<Notes> queryNotesByUserId(User user);

	public int insertNotes(Notes notes);
	public int updateNotesByNotiesId(Notes notes);
	public int deleteNotiesByNotiesId(Notes notes);
	public Notes queryNotesByNotiesId(Notes notes);
}
