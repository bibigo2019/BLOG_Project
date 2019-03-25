/**
 * 
 */
$.fn.checkUserId = function(){
	var self = this;
	var idInput = this.closest('.form-group').find('input');
	var msgSpan = this.next();
	var submitBtn = $(':submit');
	
	self.click(function(){
		var memberId = idInput.val();	
		if(!memberId) return alert('사용자 ID를 입력하세요');
		
		$.get('id-check/' + memberId, function(data){
			if(data.result == 'ok'){
				msgSpan.html(data.message).removeClass('error');
				submitBtn.prop('disabled', false);
				self.prop('disabled', true);
			} else {
				msgSpan.html(data.message).addClass('error');
				submitBtn.prop('disabled', true);
			}
		});
	});
	
	idInput.change(function(){
		msgSpan.html('ID 중복 체크를 해야합니다.').removeClass('error');
		submitBtn.prop('disabled', true);
		self.prop('disabled', false);
	})
}

$.fn.checkPassword = function(pass1 = '#password', pass2 = '#password2'){
	this.submit(function(e){
		e.preventDefault();
		var password1 = $(pass1).val();
		var password2 = $(pass2).val();
		
		if(password1 == password2){
			this.submit();
		} else {
			alert('비밀번호가 일치하지 않습니다.');
		}
	})
}