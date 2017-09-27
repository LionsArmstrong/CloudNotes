// 弹出新建笔记本对话框
function alertAddBookWindow() {
	$("#can").load("alert/alert_notebook.html");
	// 显示背景
	$(".opacity_bg").show();
}

//关闭对话框
function closeAlertWindow(){
	//清空div内容
	$("#can").empty();
	//隐藏背景色
	$(".opacity_bg").hide();
}	

//弹出新建笔记对话框
function alertAddNoteWindow() {
	//判断是否有笔记本被选中
	var $li = $("#book_ul a.checked").parent();
	if($li.length==0){
		alert("请选择笔记本");
	}else{//弹出创建笔记对话框
		$("#can").load("alert/alert_note.html");
		// 显示背景
		$(".opacity_bg").show();
	}
}

//弹出删除笔记对话框
function alertDeleteNoteWindow(){
	var $li =  $("#note_ul .note_menu:visible").parents("li");
	$("#can").load("alert/alert_delete_note.html");
	// 显示背景
	$(".opacity_bg").show();
	$("#can").data("deleteNote", $li);
	//return false;
}

//弹出移动笔记对话框
function alertMoveNoteWindow(){
	var $li =  $("#note_ul .note_menu:visible").parents("li");
	$("#can").load("alert/alert_move.html");
	$("#can").data("moveNote", $li);
	// 显示背景
	$(".opacity_bg").show();
}

//弹出从回收站恢复笔记对话框
function alertReplayNoteWindow(){
	var $li =  $("#recycle_ul .btn_replay:visible").parents("li");
	//console.log($li);
	$("#can").load("alert/alert_replay.html");
	$("#can").data("replayNote", $li);
	// 显示背景
	$(".opacity_bg").show();
}

function alertFinalDeleteNoteWindow(){
	var $li =  $("#recycle_ul .btn_delete:visible").parents("li");
	$("#can").load("alert/alert_delete_rollback.html");
	$("#can").data("finalDeleteNote", $li);
	// 显示背景
	$(".opacity_bg").show();
}