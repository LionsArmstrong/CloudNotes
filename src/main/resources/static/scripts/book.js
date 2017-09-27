//根据用户id显示笔记本列表
function loadUserBooks(){
	//获取userId
	var userId = getCookie("userId");
	//alert(userId);
	//判断是否获取到有效userId
	if(userId==null){
		window.location.href="log_in.html";
	}
	//发送ajax请求
	$.ajax({
		url:path+"/book/loadbooks.do",
		type:"post",
		data:{"userId": userId},
		dateType:"json",
		success:function(result){
			//判断查询是否成功
			if(result.status==0){
				//获取笔记本集合
				var books = result.data;
				for (var i = 0; i < books.length; i++) {
					//获取笔记本ID
					var bookId = books[i].cn_notebook_id;
					//获取笔记本名称
					var bookName = books[i].cn_notebook_name;
					//创建一个笔记本列表的li元素
					createBookLi(bookId,bookName);
					
				}
			}
		},
		
		error:function(){
			alert("笔记本加载失败！");
		}
	});
}

//创建一个笔记本li元素
function createBookLi(bookId, bookName){
	var sli=
		'<li class="online">'+
			'<a>'+ 
				'<i class="fa fa-book" title="online" rel="tooltip-bottom"> </i>'+
				bookName+
				'<input type="hidden" value='+bookId+'/>'+
			'</a>'+
		'</li>';
	//将sli字符串转换成jQuery对象的li元素
	var $li = $(sli);
	//将bookId值与jQuery对象绑定
	$li.data("bookId", bookId);
	$("#book_ul").append($li);
}

function addBook(){
	var userId = getCookie("userId");
	var bookName = $("#input_notebook").val().trim();
	console.log(bookName);
	if(bookName==""){
		alert("请输入笔记本名");
	}else{
		$.ajax({
			url: path+"/book/add.do",
			type: "post",
			data: {"userId":userId, "bookName":bookName},
			dataType: "json",
			success:function(result){
				if(result.status==0){
					var bookId = result.data;
					createBookLi(bookId, bookName);
					closeAlertWindow();
				}
			},
			error:function(){
				alert("添加笔记本失败");
			}
		});
	}
}