function updateNote(){
			//获取参数
			var $li = $("#note_ul a.checked").parent();
			//获取笔记Id
			var id = $li.data("noteId");
			//获取笔记的标题和内容
			var title = $("#input_note_title").val().trim();
			var body = um.getContent();
/* 			console.log(title);
			console.log(body);
			console.log(id); */
			if (id!=null){
				$.ajax({
					url:path+"/note/update.do",
					type:"post",
					data:{"title":title, "body":body,"id":id},
					dataType:"json",
					success:function(result){
						if(result.status==0){
							var value = '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+
										title+
										'<button onclick="toggleSlideDown(event,this)" type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
							//将字符串替换到li的a元素里
							$li.find("a").html(value);
							//提示成功
							alert(result.msg);
						}
						
					},
					error:function(){
						alert("保存笔记失败！");
					}
				}); 
			}
		};