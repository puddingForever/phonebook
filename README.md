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
 
 [GET 처리]
1.클라이언트는 GET방식으로 JSP를 요청한다.
2.Controller에서 GET방식으로 JSP/Form을 리턴한다.
 
 [POST 처리]
1. 클라이언트는 POST방식으로 데이터를 보내는 요청을 한다.
2.Controller에서 Request로 보낸 데이터가 입력이 가능한지 확인하기 위해 Service의 registerUser()를 실행한다.
3.Service의 registerUser()는 DAO의 getUserByEmail()를 사용하여 이메일이 존재하는지 확인요청을 한다. 
4.DAO는 SELECT구문과 where절을 이용하여 사용자의 이메일이 DB에 존재하는지 확인한다.
 (이메일이 존재하는 경우)
5.에러가 나는 경우 값이 클라이언트 정보가 입력되지 않도록 DAO의  getUserByEmail()에게 정보가 입력될 수 없다고 전달한다.
6.DAO는 해당 리턴값을 service의 registerUser()에게 전달하고 Controller는 requestDispatcher를 이용하여 request를 다시 클라이언트에게 돌려보낸다.
 (이메일이 존재하지 않는 경우)
 7.이메일이 존재하는 경우 DAO는 Service의 getUserByEmail()에게 중복된 이메일이 없다고 알려준다.
 8.에러가 없기 때문에 Service에서는 다시 DAO에게 회원가입이 허용하다는 코드를 실행하도록 한다.
 9.DAO는 Insert문을 활용하여 DB에 회원의 정보를 등록해준다.
 10.회원정보가 성공적으로 등록되었다면 , 이중등록을 막기위해 location.href나 sendRedirect를 이용하여 브라우저가 새로운 request객체를 요청하도록 만들고 메인 페이지로 이동시켜준다. 
 
 
 

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




