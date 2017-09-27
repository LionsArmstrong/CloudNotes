function loadActivites(){
	$.ajax({
		url:path+"/activity/load.do",
		type:"post",
		data:{},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var activities = result.data;
				console.log(activities);
				for (var i = 0; i < activities.length; i++) {
					var activityId = activities[i].cn_activity_id;
					var activityTitle = activities[i].cn_activity_title;
					var act = "<a href='activity_detail.html'>"+(i+1)+"."+activityTitle+"</a></br>";
					$(act).data("activityId", activityId);
					if(i%3==0){
						$("#col_0").append(act);
					}
					if(i%3==1){
						$("#col_1").append(act);
					}
					if(i%3==2){
						$("#col_2").append(act);
					}
					
				}
			}
		},
		error:function(){
			alert("活动加载失败！");
		}
	});
}