
let index = {
	init: function() {
		$("#btn-board-save").on("click", () => {
			this.save();
		});
		
		
		$("#btn-board-update").on("click", () => {
			this.update();
		});
		
		$("#btn-board-delete").on("click", () => {
			this.delete();
		});

	},
	save: function() {
		let data= {
			title:$("#title").val(),
			content:$("#content").val()
		}
		console.log(data);
		
		//ajax호출시 default는 비동기
		//만약 하위코드가 존재하면, ajax코드와 하위 코드 동시에 실행. interrupt 발생하면 ajax꺼 실행함.
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면, 자동으로 자바 오브젝트로 변환해준다.
		$.ajax({
			// 회원가입 수행 요청. 정상 -> done, 실패 -> fail/ try-catch같은 느낌
			type:"POST",
			url:"/api/board",
			// 아래 두개 코드는 세트임!
			data:JSON.stringify(data),//전달할 파라미터
			contentType:"application/json; charset=utf-8", //서버로 데이터를 보낼때에 어떤타입으로 보낼것인지를 지정합니다.  
			//dataType:"json" //클라이언트 -> 서버 (서버에서 반환되는 형식)
			//dataType을 알아서 지정하도록 한다.
		}).done(function(resp){
			alert("새로운 글을 등록!");// resp에 1이 리턴된다.
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert("새로운 글 등록 실패!");
			//alert(JSON.stringify(error))
			loctaion.href="/board/write";
		});// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여  insert 요청을 한다.
	},
	
	update: function() {
		let data= {
			title:$("#title").val(),
			content:$("#content").val(),
			id:$("#id").val()
		}
		console.log(data);
		
		//ajax호출시 default는 비동기
		//만약 하위코드가 존재하면, ajax코드와 하위 코드 동시에 실행. interrupt 발생하면 ajax꺼 실행함.
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면, 자동으로 자바 오브젝트로 변환해준다.
		$.ajax({
			// 회원가입 수행 요청. 정상 -> done, 실패 -> fail/ try-catch같은 느낌
			type:"POST",
			url:"/api/board/update",
			// 아래 두개 코드는 세트임!
			data:JSON.stringify(data),//전달할 파라미터
			contentType:"application/json; charset=utf-8", //서버로 데이터를 보낼때에 어떤타입으로 보낼것인지를 지정합니다.  
			//dataType:"json" //클라이언트 -> 서버 (서버에서 반환되는 형식)
			//dataType을 알아서 지정하도록 한다.
		}).done(function(resp){
			alert("기존 글 수정완료!");// resp에 1이 리턴된다.
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert("기존 글 수정실패!");
			alert(JSON.stringify(error))
		});// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여  insert 요청을 한다.
	},
	delete: function() {

		id = $("#id").text(),// html text는 무조건 이 방식으로 받아들인다.
		
		//ajax호출시 default는 비동기
		//만약 하위코드가 존재하면, ajax코드와 하위 코드 동시에 실행. interrupt 발생하면 ajax꺼 실행함.
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면, 자동으로 자바 오브젝트로 변환해준다.
		$.ajax({
			// 회원가입 수행 요청. 정상 -> done, 실패 -> fail/ try-catch같은 느낌
			type:"POST",
			url:"/api/board/delete/"+id , //Restful하게 전한다.
			
			data: { // data: /api/board/delete로 data에서 id를 담아서 보낸다.
	            id: id
	    	},   
			contentType:"application/json; charset=utf-8",// 클라이언트 -> 서버로.
			//dataType:"json"// 서버 ->크라이언트로, =>javascript로 바꿔준다.
		}).done(function(resp){
			alert("기존 글 삭제완료!");// resp에 1이 리턴된다.
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			//alert("기존 글 수정실패!");
			alert(JSON.stringify(error))
		});
	}
	
}

index.init(); // init 함수 호출