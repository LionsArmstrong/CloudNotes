function searchMoreNote(){
	//获取参数
	var keyword = $("#search_note").val().trim();
	page++;
	//发送ajax请求加载列表
	loadPageShare(keyword, page);
}

function loadPageShare(keyword, page){
	$.ajax({
		url:path+"/share/search.do",
		type:"post",
		data:{
			"keyword":keyword,
			"page":page
		},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				//alert(result.msg);
				$(".col-xs-3").hide();
				$("#pc_part_6").show();
				//获取数据
				var shares = result.data;
				//console.log(shares);
				
				for (var i = 0; i < shares.length; i++) {
					var shareId = shares[i].cn_share_id;
					//var noteId = shares[i].cn_note_id;
					var shareTitle = shares[i].cn_share_title;
					//var shareBody = shares[i].cn_share_body;
					//console.log(shareId+","+noteId+","+shareTitle);
					createNoteLi(shareId, shareTitle, '1', "#search_ul");
				}
			}
		},
		error:function(){
			alert("搜索失败！")
		}
	});
}

/*
 * 搜索分享笔记
 */
function searchNote(event){
	var code = event.keyCode;
	if(code==13){//按下回车
		var keyword = $("#search_note").val().trim(); //获取请求参数
		page = 1;
		$("#search_ul").empty();
		loadPageShare(keyword, page);
	}
}

/*
 * 预览搜索出的笔记
 */
function previewSearchedNote(){
	$("#search_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	$(".col-sm-7").hide();
	$("#pc_part_5").show();
	var shareId = $(this).data("noteId");
	$.ajax({
		url:path+"/share/loadshare.do",
		type:"post",
		data:{"shareId":shareId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var shareTitle = result.data.cn_share_title;
				var shareBody = result.data.cn_share_body;
				$("#noput_note_title").html(shareTitle);
				$("#noput_note_title").next("p").html(shareBody);
			}
		},
		error:function(){
			alert("笔记预览失败!");
		}
	});
}
