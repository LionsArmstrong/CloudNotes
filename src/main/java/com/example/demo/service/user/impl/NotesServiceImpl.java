package com.example.demo.service.user.impl;

import com.example.demo.entity.notes.Notes;
import com.example.demo.entity.user.User;
import com.example.demo.mapper.INotesMapper;
import com.example.demo.service.user.INotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value="iNotesService")
public class NotesServiceImpl implements INotesService {

	@Autowired
	private INotesMapper iNotesMapper;


	@Override
	public List<Notes> queryNotesByUserId(User user) {
		return iNotesMapper.queryNotesByUserId(user);
	}

	@Override
	public int insertNotes(Notes notes) {
		return iNotesMapper.insertNotes(notes);
	}

	@Override
	public int updateNotesByNotiesId(Notes notes) {
		int bool=iNotesMapper.updateNotesByNotiesId(notes);
		if(bool>0){
			return bool;
		}else{
			return insertNotes(notes);
		}
	}

	@Override
	public int deleteNotiesByNotiesId(Notes notes) {
		return iNotesMapper.deleteNotiesByNotiesId(notes);
	}

	@Override
	public Notes queryNotesByNotiesId(Notes notes) {
		return iNotesMapper.queryNotesByNotiesId(notes);
	}
}
