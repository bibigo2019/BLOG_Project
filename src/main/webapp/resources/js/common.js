/**
 * 
 */
$.fn.deletePanel = function(opt){
	var self = this;
	var templ = 
	`<form class="my-3">
		비밀번호 :
		<input type="password" name="password" required>
		<button type="submit" class="btn btn-primary btn-sm">
		<i class="fas fa-times"></i> 삭제
		</button>
		<button type="button" class="btn btn-primary btn-sm cancel">
		<i class="fas fa-undo"></i> 취소
		</button>
	</form>`;
	
	self.append(templ);
	var password = self.find(':password');
	var triger = $(opt.triger);
	var url;
	var items = [];
	triger.click(function() {
		var userId = $(this).data('member-id');
		//특정인 제거
		console.log(userId);
		if(userId){
			url = opt.url.replace('\{member-id\}', userId );			
		}
		else {
			//선택 삭제
			if($(this).data('mode') == 'multiple') {
				$(opt.multiple).each(function(){
					console.log($(this).val());
					items.push($(this).val()); //선택된 사용자 ID 배열에 추가
				});
			} 
			//view 페이지에서 삭제
			else {
				url = opt.url
			}
		}
			
		self.show();
	})
	
	self.on('click','.cancel', ()=>{
		password.val('');
		self.hide();
	})
	
	self.on('submit','form',function(e){
		e.preventDefault();
		if(!confirm("삭제할까요?")) return;
		
		console.log(items);
		
		if(items.length == 0) {
			//Ajax 로 delete 요청
			axios.delete(url + '?password=' + password.val())
				.then(function(obj){
					if(obj.data.result == 'success'){
						location.href = opt.moveUrl;
					}
					else {
						alert(obj.data.message);						
					}
				})
				.catch(console.log);
		}
		else {
			items.forEach(function(element) {
				url = opt.url.replace('\{member-id\}', element );
				
				//Ajax 로 delete 요청
				axios.delete(url + '?password=' + password.val())
					.then(function(obj){
						if(obj.data.result != 'success'){
							alert(obj.data.message);
						}
					})
					.catch(console.log);
			});
			
			location.href = opt.moveUrl;
		}
	});
}