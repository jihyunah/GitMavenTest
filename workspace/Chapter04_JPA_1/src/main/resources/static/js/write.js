//등록
$('#writeBtn').click(function (){
	$.ajax({
		type: 'post',
		url: '/user/write',
		data: $('#writeForm').serialize(), //'name=홍길동&id=hong&pwd=111'로 문자열로 controller로 보낸다.
		success: function(){
			alert('등록 완료');
			location.href='/user/list';
		},
		error: function(err){
			console.log(err);
		}
	});
});

//아이디 중복체크
$('#id').focusout(function(){
	  $('#idDiv').empty();

  if ($('#id').val() == '') {
    $('#idDiv').text('먼저 아이디를 입력하세요.');
    $('#id').focus();
  } else {
		$.ajax({
			type:'post',
			url:'/user/isExistId',
			data: 'id='+$('#id').val(),
			dataType:'text',
			success:function(data){
				if(data == 'exist'){
					$('#idDiv').text('사용 불가능');
					$('#idDiv').css('color','red');
					
				}else if(data == 'non_exist'){
					$('#idDiv').text('사용 가능');
					$('#idDiv').css('color','blue');
				}
			},
			error: function(err){
			console.log(err);
			}
		});
	}
	
});








