<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../include/header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signUp회원가입</title>

<script type="text/javascript">
$(function() {
	var id_check;	//아이디 사용가능 여부
	var pass_check1;//비밀번호 일치 여부
	var pass_check2;
	var name_check;
	var phone_check;//전화번호 숫자만 썼는지 여부
	var email_check;

	$("#user_id").blur(function() {
		alert("호잇");
		alert('호호잇');
		var id = $("#user_id").val(),
			regex = /^[A-Za-z0-9+]{4, 16}$/;
			if(id==""|id==null){
				$("#idMsg").html("<font color='red'>ID를 입력해주세요.");
				id_check = false;
			}else if(!regex.test(id)){
				$("#idMsg").html("<font color='red'>4~16자리, 영문과 숫자만 가능합니다.");
				id_check = false;
			}else{
				id_check = true;
			}
		var param = "user_id="+user_id.val();
		$.ajax({
			type : "POST",
			url : "${path}/member/searchId.do",
			data : param,
			success : function(data) {
				if(data=="success"){
					idMsg.text("사용가능한 ID");
					id_check = true;
				}else{
					idMsg.html("<font color='red'>사용 불가능한 ID");
					id_check = false;
				}
			}
		});
	});
	$("#password").blur(function(){
		var pass = $("#password").val(),
			regex = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{4, 16}$/;
		if(pass==""|pass==null){
			passMsg1.html("<font color='red'>비밀번호를 입력해 주세요.");
			pass_check1 = false;
		}else if(!regex.test(pass)){
			passMsg1.html("<font color='red'>4~16자리, 숫자 혹은 특수문자를 반드시 포함하세요.");
			pass_check1 = false;
		}else{
			passMsg1.html("<font color='green'>확인");
			pass_check1 = true;
		}
	});
	$("#password2").blur(function(){
		var pass = $("#password").val();
		var pass2 = $("#password2").val();
		if(pass2==""|pass2==null){
			passMsg2.html("<font color='red'>비밀번호 확인을 입력해 주세요.");
			pass_check2 = false;
		}else if(pass!=pass2){
			passMsg2.html("<font color='red'>비밀번호가 일치하지 않습니다.");
			pass_check2 = false;
		}else{
			passMsg2.html("<font color='green'>확인");
			pass_check2 = true;
		}
	});
	$("#user_name").blur(function(){
		var name = $(this).val(),
			regex = /^[가-힣]{1,12}$/;
			if(name==""|name==null){
				$("#nameMsg").html("<font color='red'>이름을 입력해 주세요.");
				name_check = false;
			}else if(!regex.test(name)){
				$("#nameMsg").html("<font color='red'>12글자 이내로 입력해 주세요.");
				name_check = false;
			}else{
				$("#nameMsg").html("<font color='green'>확인");
				name_check = true;
			}
	});
	$("#tel1").blur(function(){
		if(isNaN($("#tel1"))){
			telMsg.html("<font color='red'>숫자만 입력해주세요.");
			phone_check = false;
		}else{
			$("#tel2").blur(function(){
				if(isNaN($("#tel2"))){
					telMsg.html("<font color='red'>숫자만 입력해주세요.");
					phone_check = false;
				}else{
					$("#tel3").blur(function(){
						if(isNaN($("#tel3"))){
							telMsg.html("<font color='red'>숫자만 입력해주세요.");
							phone_check = false;
						}else{
							telMsg.html("<font color='green'>확인");
							phone_check = true;
						}
					});
				}
			});
		}
	});

	//이메일 앞
	$("#email1").focusout(function(){
		var email1 = $(this).val(),
			regex = /^([\w-]+(?:\.[\w-]+)*)$/;
		if(email1==""||email1==null){
			$("#emailMsg").html("<font color='red'>이메일을 입력해 주세요.");
			email_check = false;
		}else if(!regex.test(email1)){
			$("#emailMsg").html("<font color='red'>이메일형식에 맞지 않습니다.");
			email_check = false;
		}else{
			//이메일 뒤
			$("#email2").focusout(function(){
				var email2 =  $(this).val(),
					regex = /^((?:[\w-]+\.)*\w[\w-]{0, 66})\.([a-z]{2, 6}(?:\.[a-z]{2})?)$/;
				if(email2==""|email2==null){
					$("#emailMsg").html("<font color='red'>이메일을 입력해 주세요.");
					email_check = false;
				}else if(!regex.test(email2)){
					$("#emailMsg").html("<font color='red'>이메일형식에 맞지 않습니다.");
					email_check = false;
				}else{
					$("#emailMsg").html("<font color='green'>확인");
					email_check = true;
				}
			});
		}
	});
	
});
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('sample6_address').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('sample6_address2').focus();
        }
    }).open();
}
</script>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<form action="signup.do" method="post" onsubmit="return signupChk()">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-7">
			<h3 style="text-align: center;">회원가입</h3>
			<table border="0">
				<tr>
					<th>아이디</th>
					<td><input id="user_id" class="inputText" type="text" name="user_id"></td>
				</tr>
				<tr>
					<td colspan="2" class="msgTd">
						<div class="msgDiv">
							<label id="idMsg">4~16자리, 영문과 숫자만 입력가능합니다.</label>
						</div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input id="password"  class="inputText"type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2" class="msgTd">
						<div class="msgDiv">
							<label id="passMsg1">4~16자리, 숫자 혹은 특수문자를 반드시 포함시켜 입력하세요.</label>
						</div>
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input id="password2" class="inputText" type="password" name="password2"></td>
				</tr>
				<tr>
					<td colspan="2" class="msgTd">
						<div class="msgDiv">
							<label id="passMsg2"></label>
						</div>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input id="user_name" class="inputText" type="text" name="user_name"></td>
				</tr>
				<tr>
					<td colspan="2" class="msgTd">
						<div class="msgDiv">
							<label id="nameMsg">한글이름 12자 이내로 입력하세요.</label>
						</div>
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>
						<div id="birthDiv">
							<select id="birthY" class="birthText" name="birthY">
								<c:forEach var="y" begin="1900" end="2017">
									<option name="birthY" value="${y}">${y}년</option>
								</c:forEach>
							</select>
							<select id="birthM" class="birthText" name="birthM">
								<c:forEach var="m" begin="1" end="12">
									<option name="birthM" value="${m}">${m}월</option>
								</c:forEach>
							</select>
							<select id="birthD" class="birthText" name="birthD">
								<c:forEach var="d" begin="1" end="31">
									<option name="birthD" value="${d}">${d}일</option>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="msgTd">
						<div class="msgDiv">
							<label id="birthMsg"></label>
						</div>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<div id="genderDiv">
							<label><input class="radio" type="radio" name="gender" value="M" checked="checked">남성</label>
							<label><input class="radio" type="radio" name="gender" value="F">여성 </label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="msgTd">
						<div class="msgDiv">
							<label id="genderMsg"></label>
						</div>
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<div id="telDiv">
							<select class="telText" name="tel1" id="tel1">
								<option name="tel1" value="010">010</option>
								<option name="tel1" value="011">011</option>
								<option name="tel1" value="016">016</option>
								<option name="tel1" value="017">017</option>
								<option name="tel1" value="018">018</option>
								<option name="tel1" value="019">019</option>
							</select>
							 - <input class="telText" type="text" name="tel2" id="tel2">
							 - <input class="telText" type="text" name="tel3" id="tel3">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="msgTd">
						<div class="msgDiv">
							<label id="telMsg"></label>
						</div>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" class="emailText" name="email1"> @ <input type="text" class="emailText" name="email2" ></td>
				</tr>
				<tr>
					<td colspan="2" class="msgTd">
						<div class="msgDiv">
							<label id="emailMsg"></label>
						</div>
					</td>
				</tr>
				<tr>
					<th rowspan="2">주소</th>
					<td>
						<div class="addressDiv">
							<input type="post" class="inputAddress" name="address1" id="sample6_postcode" placeholder="우편번호" readonly="readonly">
							<input type="button" id="buttonAddress" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
						</div>
					</td>
				<tr>
					<td>
						<div class="addressDiv">
							<input type="addess1" class="inputAddress" name="address2" id="sample6_address" placeholder="주소" readonly="readonly">
							<input type="addess2" class="inputAddress" name="address3" id="sample6_address2" placeholder="상세주소">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="msgTd">
						<div class="msgDiv">
							<label id="addressMsg"></label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input id="button" type="submit" value="가입하기"></td>
				</tr>
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>
</form>
</body>
</html>