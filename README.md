# 📪  Phonebook Application 📞
<p>Java EE, myBatis, H2 </p>

<h1>💭연락처 프로젝트 구상 및 접근방법<h1>

<h3>프로젝트명</h3>
 
<h4>Phonebook Application</h4>

<h3>프로젝트 개요</h3>
<p>사용자는 웹사이트 회원가입 후, 친구목록에 연락처를 추가할 수 있음</p>
<p>추가된 연락처를 한번에 볼 수 있는 목록이 있으며, 연락처 삭제 가능</p>

<h3>시스템 구상</h3>
<h4>회원가입 프로세스</h4>
<img src="https://user-images.githubusercontent.com/126591306/234473604-836e73c1-767a-4a17-84a5-e87f0d337cbe.png" width="500" height="300"/>
 
 [GET 처리] <br/>
1.클라이언트는 GET방식으로 JSP를 요청한다.<br/>
2.Controller에서 GET방식으로 JSP/Form을 리턴한다.<br/>
 
 [POST 처리]<br/>
1. 클라이언트는 POST방식으로 데이터를 보내는 요청을 한다.<br/>
2.Controller에서 Request로 보낸 데이터가 입력이 가능한지 확인하기 위해 Service의 registerUser()를 실행한다.<br/>
3.Service의 registerUser()는 DAO에 있는 getUserByEmail()로 먼저 이메일이 있는지 확인 후, createUser()를 사용하여 회원가입을 진행하도록 구성되어있다.<br/>
 4.DAO의 getUserByEmail()은 where 조건문을 이용하여 클라이언트의 이메일을 확인하여 DB에 이메일이 등록되어있는지 확인한다.<br/>
 5.이메일이 존재한다면 User가 리턴되며, 이메일이 존재하지 않는다면 null이 리턴되도록 되어있다.<br/>
 [이메일이 DB에 있는 경우]<br/>
 6.이메일이 존재하는 경우, User가 리턴되며, Service에서는 Map을 이  용하여 에러가 있다고 등록시키고 null을 리턴해준다.<br/>
 7.Controller에서는 Service에서 리턴한 Map에 값이 있다면 RequestDispatcher를 이용하여 사용자의 request를 그대로 돌려보내고 회원가입을 막는다. 
 
 [이메일이 DB에 존재하지 않는 경우]<br/>
 8.이메일이 존재하지 않는다면 , DAO의 getUserByEmail()은 null을 리턴하며,Service에서는 이를 확인하여 DAO의 createUser()를 이용해 회원가입을 진행시킨다.<br/>
 9.DB에 회원정보가 등록된 후, Service에서는 해당 User객체를 리턴해준다. <br/>
 10.Controller에서는 Service로 부터 받은 User객체를 이용하여 session을 만들어주고, 중복등록을 막기 위해 response.sendRedirect("./메인페이지")를 이용하여 브라우저에서 새로운 request를만들도록 하여 메인페이지로 이동시켜준다. 
 
 
 

<h4>회원탈퇴  프로세스</h4>
<h4>로그인 프로세스</h4>

<h4>로그아웃 프로세스</h4>

<h1>🪂결과🪂</h1>

 🔗메인페이지 <br/>
<img src="https://user-images.githubusercontent.com/126591306/233263179-b08d4a63-6a75-4a54-b96a-0555ee69b0c2.png" width="500" height="300"/> <br/>
 footer에 쿠키를 설정하여 테마를 바꿀 수 있도록 함.<br/>
 
🔗회원가입 페이지<br/>
 <img src="https://user-images.githubusercontent.com/126591306/233263215-aaa1f1af-1b3b-4122-96ce-05edb6ac4921.png" width="500" height="300"/> <br/>
DB와 연결되는 UserDao에서 이메일로 DB에 정보가 있는지를 체크하여, DB에  있는 사용자라면 아이디를 만들어주지 않고 에러 메세지를 표시해주고 DB에 없는 사용자라면 회원가입을 처리하도록 함.<br/>
 
회원가입 프로세스 
 


<h4>회원탈퇴 페이지</h4>
🔗

<h4>로그인 페이지</h4>
🔗

<h4>연락처 추가 페이지</h4>
🔗

<h4>연락처 삭제 페이지</h4>
🔗

<h4>로그아웃 페이지</h4>
🔗



<h3>📈예상효과</h3>

  
  
<h3>🚨결론</h3>




