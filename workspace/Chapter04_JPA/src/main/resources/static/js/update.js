$(function(){
	$('#updateDiv').hide();
	
	$('#searchIdBtn').click(function(){
	$('#resultDiv').empty();
	
	if($('#searchId').val().trim() == ''){
		$('#resultDiv').text('먼저 아이디를 입력');
		$('#resultDiv').css('color', 'pink');
		$('#searchId').focus();
	} else {
		$.ajax({
			type: 'post',
			url: '/user/getUser',
			data: 'id=' + $('#searchId').val(),
			success: function(data){
				//Optional<UserDTO> 값이 있으면 JSON으로 오고 없으면 null로 온다.
				console.log(JSON.stringify(data));
				
				if(data == null){
					$('#updateDiv').hide();
					
					$('#resultDiv').text('찾고자 하는 아이디가 없습니다.');
					$('#resultDiv').css('color', 'pink');
					$('#resultDiv').css('font-weight', 'bold');
				} else {
					$('#updateDiv').show();
					
					$('#name').val(data.name);
					$('#id').val(data.id);
				}
				
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});
});

/*
** dataType을 생략하면 자료에 맞게 자동으로 형식이 지정된다.
//서버에서 받아오는 데이터 타입은 'text', 'html', 'xml', 'json' 형식을 지정할 수 있다
         //getUser에서 id를 찾으면 제대로 JSON으로 오지만 
         //           id가 없으면 JSON으로 오지를 못한다.
         //그래서 dataType를 생략해야 한다. (dataType를 생략하면 자료에 맞게 자동으로 형식이 지정된다.)
*/

