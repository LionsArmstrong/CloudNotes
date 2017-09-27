package com.example.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.notes.Notes;
import com.example.demo.entity.user.User;
import com.example.demo.service.user.INotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class NotesController {

	@Autowired
	private INotesService iNotesService;



	@RequestMapping(value="/queryNotes.do")
    @ResponseBody
	public String queryNotes(HttpServletRequest request, HttpSession session){
		System.out.println("进入queryNotes");
		User u= (User) session.getAttribute("USER");
		u.setUserName(null);
		System.out.println("/*queryNotes*/USERID:"+u.getId());
		List<Notes> list = iNotesService.queryNotesByUserId(u);
		StringBuffer s=new StringBuffer();
		for (Notes notes:list) {
			System.out.println(notes.getId()+"：："+notes.getNtitle());
		}
		JSONArray array = new JSONArray();
		array.addAll(list);
		String json = array.toJSONString();
        System.out.println(json);
        return json;
		//session.setAttribute("USER", user);
		//model.addAttribute("USER",user);
		//return "edit";
	}


	@RequestMapping(value="/queryNotesByQname.do")
	@ResponseBody
	public String queryNotesByQname(String Qname,HttpServletRequest request, HttpSession session){
		System.out.println("进入queryNotesByQname");
		User u= (User) session.getAttribute("USER");
		u.setUserName(Qname);
		System.out.println("/*queryNotes*/Qname:"+u.getUserName());
		List<Notes> list = iNotesService.queryNotesByUserId(u);
		StringBuffer s=new StringBuffer();
		for (Notes notes:list) {
			System.out.println(notes.getId()+"：："+notes.getNtitle());
		}
		JSONArray array = new JSONArray();
		array.addAll(list);
		String json = array.toJSONString();
		System.out.println(json);
		return json;
	}

	@RequestMapping(value="/toupdateNotes.do")
	@ResponseBody
	public String toupdateNotes(int id,HttpServletRequest request, HttpSession session){
		System.out.println("*****************进入toupdateNotes");
		Notes notes=new Notes();
		notes.setId(id);
		System.out.println("*****************notesID:"+notes.getId());
		Notes qNotes = iNotesService.queryNotesByNotiesId(notes);
		StringBuffer s=new StringBuffer();
		JSONArray array = new JSONArray();
		array.add(qNotes);
		String json = array.toJSONString();
		System.out.println(json);
		return json;
	}

	@RequestMapping(value="/doupdateNotes.do")
	@ResponseBody
	public String doupdateNotes(int id,String ntitle,String ntext,HttpServletRequest request, HttpSession session){
		System.out.println("*****************进入DoupdateNotes");
		Notes notes=new Notes();
		notes.setId(id);
		notes.setNtext(ntext);
		notes.setNtitle(ntitle);
		System.out.println("*****************notesID:"+notes.getId());
		System.out.println("*****************notesNtext:"+notes.getNtext());
		System.out.println("*****************notesNtitle:"+notes.getNtitle());
		int bool = iNotesService.updateNotesByNotiesId(notes);
		if(bool>0){
			return "true";
		}else{
			return "false";
		}
	}

	@RequestMapping(value="/doDeleteNotes.do")
	@ResponseBody
	public String doDeleteNotes(int id,HttpServletRequest request, HttpSession session){
		System.out.println("--------进入DoDeleteNotes");
		Notes notes=new Notes();
		notes.setId(id);
		System.out.println("--------DoDeleteNotesID:"+notes.getId());
		int bool = iNotesService.deleteNotiesByNotiesId(notes);
		if(bool>0){
			return "true";
		}else{
			return "false";
		}
	}





	@RequestMapping(value="AddNotesById.do")
    @ResponseBody
	public String AddNotesById(String ntitle,String ntext,HttpServletResponse response,HttpSession session){
		Notes notes=new Notes();
        notes.setNtext(ntext);
        notes.setNtitle(ntitle);
		if (notes.getNtitle()==""||notes.getNtitle()==null){
			return "Ntitleisnull";
		}
		if (notes.getNtext()==""||notes.getNtext()==null){
			return "Ntextisnull";
		}
	    System.out.println("AddNotesById:"+notes.getNtitle()+"成功!");
		User u=(User)session.getAttribute("USER");
        notes.setUserid(u.getId());
        System.out.println("Notes:"+notes.getNtext()+"成功!");
		int bool = iNotesService.insertNotes(notes);
		/*try {
			response.getWriter().write("<script>alert('register was successful！！！')</script>");
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
		if(bool>0){
            return "true";
        }else{
		    return "false";
        }

	}


}
