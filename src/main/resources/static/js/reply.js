
let reply = {
	init: function() {
		$("#btn-board-reply").on("click", () => {
			this.reply();
		});		
	},
	reply: function() {
		
		let data= {
			content:$("#content").val(),
			id:$("#boardId").val()
		}
		console.log(data);
		
		//ajax호출시 default는 비동기
		//만약 하위코드가 존재하면, ajax코드와 하위 코드 동시에 실행. interrupt 발생하면 ajax꺼 실행함.
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면, 자동으로 자바 오브젝트로 변환해준다.
		$.ajax({
			// 회원가입 수행 요청. 정상 -> done, 실패 -> fail/ try-catch같은 느낌
			type:"POST",
			url:"/api/reply/save",

			// 아래 두개 코드는 세트임!
			data:JSON.stringify(data),//전달할 파라미터
			contentType:"application/json; charset=utf-8", //서버로 데이터를 보낼때에 어떤타입으로 보낼것인지를 지정합니다.  
			//dataType:"json" //클라이언트 -> 서버 (서버에서 반환되는 형식)
			//dataType을 알아서 지정하도록 한다.
		}).done(function(resp){
			alert("새로운 댓글 등록 성공!.");// resp에 1이 리턴된다.
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error))
		});// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여  insert 요청을 한다.
	}
}

reply.init(); // init 함수 호출