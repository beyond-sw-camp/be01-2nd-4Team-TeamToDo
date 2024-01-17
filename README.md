<h1 align="center"> To_DO List 개인 및 팀 버전  </h1>


팀원
=======
```


전승민(팀장), 박대호, 김민성, 심규혁


```


미니 프로젝트: spring boot, rest api, maven
> 미완료 : MSA(JWT 구성)



### 프로젝트 목표 :

개인이 사용할 수 있는 todo list 구성과 팀원이 서로 공유하고 볼 수 있는 todolist를 만들어보자


# 역할 분담
```
전승민
1. 프로젝트 설계​

2. 개인/ 팀간 데이터 연결 ​

3. 발표 자료 작성 및 발표 ​

4. 세션 로그인


심규혁
1. 개인 ToDo List (rest/ html)​

2. DB 설계​

3. 다이어 그램 작성


박대호
1. 팀별 할일 작성/ 삭제/ 수정/ 완료 기능 구현(Rest / html) ​

2. Spring Session - 메인 클래스 간   관계 기술


김민성
1. 세션 로그아웃​

2. 마이페이지​

3. html, css 디자인 
```



[Google Sheet(4팀 프로젝트 문서)](https://docs.google.com/spreadsheets/d/1W5FWxfUWDjQPUbMkPeahi3Vn_Bxx6TmZ9QnIumbHlPE/edit?usp=sharing)
------------------------------------------------------------------------------------------------------------------------------------------------------------------
<details>
<summary>초기 구성에 대한 캡처 및 설명</summary>
  
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/76007f30-4c8a-4c18-9863-cff0406a49d2)

* 기본적인 데이터 입력 및 수정, 제거 기능 구현. todo의 기능 구현


초기 구성 flow

![ToDo_flow](https://github.com/CoffeerLatte/git-4team/assets/80744883/4be876c3-ae46-47e7-8514-f8a812527932)

* todo 사용자 -> 회원가입 유무를 본인이 확인 -> 아이디가 있다면 로그인 -> 개인 Todo List 사용 -> 팀 Todo List 사용 -> 개인 Todo List 사용(자유롭게 이동 가능)
  
> 아이디가 없다면 회원가입
> 
> 팀용 todolist에서의 팀원들 마다 구별법 추후 구상.

![캡처](https://github.com/CoffeerLatte/git-4team/assets/125641153/9225727a-c756-491b-a76a-651649f2b6c6)

* 사용하게 될 기본적인 table 구상.
  
</details>

-----------------------------------------------------------------------------------------------------------------------------------------------------------
<details>

  <summary>구현완료된 동작에 대한 캡쳐 및 설명</summary>
  
  

-----------------------------------------------------------------------------------------------------------------------------------------------------------
session login 완성 및 todo_list와 연동 과정

-> 서로다른 테이블을 join하는 방법으로 원하는 데이터를 가져오려고 했다.

-> 실패 (이유는 새로운 객체를 생성하여 가져오고 있었기 때문)

디버깅
-> joincolumn을 사용하지 않고, 로그인을 하자마자, 로그인하는 파트에서 바로 데이터를 넘겨주는 방식으로 해결.
![tempsnip](https://github.com/CoffeerLatte/git-4team/assets/125641153/40d58adc-6a8d-43a4-a431-5ff388d64dfc)
[해결 캡처]


-----------------------------------------------------------------------------------------------------------------------------------------------------------
session login + TodoList + team_todolist  연동과정


안되었던 부분
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/3ab1ec85-0ba9-4d6b-bfec-046437a87e81)

team_todolist 수정 과정에서 코드에서 문제는 없었지만, html 에서 JSON 방식으로 넘겨 받는 과정에서 JSON 형식에 맞지 않아 에러 발생
-> html 에서 입력받는 데이터를 JSON 형식으로 전달하여 해결.

-----------------------------------------------------------------------------------------------------------------------------------------------------------

리다이렉션 문제

-> 데이터를 update, insert, delete, complete하고 나서 원하는 페이지로 redirection이 되지 않았음. 계속 메인페이지로 load.

-> resource / template/ teamtodo.html 파일을 수정하여 update, delete, complete는 데이터 이동 동작 후 page를 reload하게 만듬.

-> 결과 : 데이터를 입력 후 입력한 데이터가 현재 html 페이지에 정상 반영됨.

// 로그인
![로그인](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/0b2bda0b-ce83-44b2-bd92-36deb37fabba)

// 회원가입
![회원가입](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/d3a80098-19bd-41f5-89a0-3a105e31b76b)

//비밀번호가 틀렸을 경우
![비밀번호오류](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/b22667c7-908e-4815-bd29-21d400c94d03)

// 다른 회원이 사용중인 닉네임의 경우
![회원가입닉네임](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/43f2d89d-a58a-45b4-9379-e96ad8958fa9)

// 로그인 시 자신만의 개인 todo리스트로 이동
![개인todo메인](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/475a27a6-dfbb-49d0-9845-e380961d56e2)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

팀 할일 페이지 Rest로 구현

// 팀 할일 페이지 팀별 todolist 확인

![image](https://github.com/CoffeerLatte/git-4team/assets/76561901/427b9eaa-5d62-4df3-ba5d-ab9fca2c1cbd) 

// 팀 할일 페이지 팀별 todolist 작성

![insert](https://github.com/CoffeerLatte/git-4team/assets/76561901/5925b9ca-6922-416f-9809-9f85a17dcead) 

//  팀 할일 페이지 팀별 todolist 작성 결과

![insert2](https://github.com/CoffeerLatte/git-4team/assets/76561901/761d32ac-8100-4f29-882e-01dadd2ba5ca) 


//  팀 할일 페이지 팀별 할일 수정 전

![update1](https://github.com/CoffeerLatte/git-4team/assets/76561901/6fd72434-13ac-41be-b46d-66e92c6a4ee7) 

//  팀 할일 페이지 팀별 할일 수정 화면

![update2](https://github.com/CoffeerLatte/git-4team/assets/76561901/f9f135ae-cbd0-4592-88c9-1ac292b4545e) 

//  팀 할일 페이지 팀별 할일 수정 후

![update3](https://github.com/CoffeerLatte/git-4team/assets/76561901/c0c1965f-89fd-4b9e-9dab-a06e60fef495) 


// 팀 할일 페이지 할일 완료 처리

![completed](https://github.com/CoffeerLatte/git-4team/assets/76561901/d9e84329-3f6e-4e97-87e4-bc47ba88f903) 

// 팀 할일 페이지 할일 완료 처리 결과

![completed2](https://github.com/CoffeerLatte/git-4team/assets/76561901/308b8f34-2e20-430d-8c91-dc0a2392f23f) 


// 팀 할일 페이지 할일 삭제 처리

![delete](https://github.com/CoffeerLatte/git-4team/assets/76561901/dd6f656f-1f44-4a29-b20d-359cbadab8a6) 

// 팀 할일 페이지 할일 삭제 처리 결과

![delete2](https://github.com/CoffeerLatte/git-4team/assets/76561901/cd24c320-270e-46e6-996c-de665f71920f) 

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

+ 팀 할일 버튼 및 로그아웃 버튼 상호 작용 가능.

// 팀 할일 페이지
![팀todo](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/68d61b07-24eb-46b7-82ff-b8ce2934f956)

// 팀 할일 페이지에서의 todo 삭제 메시지 띄우기
![팀todo삭제](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/431cfe35-3ddc-47ae-bdc9-0597577d4a21)

// 팀 할일 페이지에서 수정 버튼을 눌러서 완수 날짜 및 할일을 수정하는 캡쳐
![팀todo수정](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/3979bdde-d523-4acb-9b14-c5036cfe4f62)

// 팀 할일 페이지에서 방금 수정한 내용이 즉시 반영되는 모습
![팀todo수정완료](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/9b4d4646-8cca-433e-af8b-f773491cf0b6)

// 완료 버튼 정상 동작
![팀todo완료](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/f81cf27f-c676-4c75-91cd-bd0a81117762)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

+ 개인 페이지 todo Rest로 구현

// 개인 페이지에서의 todo 작성
![insert](https://github.com/CoffeerLatte/git-4team/assets/76561901/7e5716f6-620a-4d71-81b0-c0a84ac43a23)


// 개인 페이지에서의 todo 작성 결과

![insert2](https://github.com/CoffeerLatte/git-4team/assets/76561901/4f8c6cf8-91a4-4846-85ed-52c4992158c9)

// 개인 페이지에서의 todo 열람
![get](https://github.com/CoffeerLatte/git-4team/assets/76561901/f7d411bc-e407-4c91-b55d-4e5758989698)

// 개인 페이지에서의 todo 수정
![update](https://github.com/CoffeerLatte/git-4team/assets/76561901/b8f5ff8b-fa2a-45c2-a11a-d3773a49248a)

// 개인 페이지에서의 todo 수정 결과

![update2](https://github.com/CoffeerLatte/git-4team/assets/76561901/d88ac97c-c732-4658-bc4c-b97093476e97)

// 개인 페이지에서의 todo 완료 처리 
![completed](https://github.com/CoffeerLatte/git-4team/assets/76561901/a202e13b-aa3d-4999-874e-910350f9b926)

// 개인 페이지에서의 todo 완료 처리 결과

![completed2](https://github.com/CoffeerLatte/git-4team/assets/76561901/d9824008-8b45-4919-bf26-0e9159f8dd24)

// 개인 페이지에서의 todo 삭제
![delete](https://github.com/CoffeerLatte/git-4team/assets/76561901/83971fb4-e683-426f-9896-a5f1d38f8194)

// 개인 페이지에서의 todo 삭제 결과

![delete2](https://github.com/CoffeerLatte/git-4team/assets/76561901/b58ada6f-181f-4fbe-98e6-74cf0c19d2d9)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

+ 개인 페이지 todo

// 개인 페이지에서의 todo 작성

![개인todo메인](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/36bd0790-9808-48e9-a3dc-614e8b18b842) 

// 버튼 정상 동작

![개인todo완료](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/42232a2b-bfb4-4e71-9b9e-0cd0b20794e8)

// 개인 페이지에서의 수정 정상 기능

![개인todo수정](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/bf50ff9d-821e-497d-8396-97a1bfd92ed2)

// 개인 페이지에서의 데이터 삭제 정상

![개인todo삭제](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/0795dc7c-9818-421b-94bb-7911157888c4)

// maria db 데이터 베이스에 쌓이는 todoentity 정보 (팀)

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/3777d2c1-dca3-4da4-9037-3c804a17fa43) 

// maria db 데이터 베이스에 쌓이는 todoentity 정보 (개인)

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/4aaf1122-e8f7-4ef7-97fc-079cbbbe3635) 

// maria db 데이터베이스에 쌓이는 회원가입한 계정 정보

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/36771c35-b123-4c29-abfb-0fe82e4b50ff) 

</details>




# 최종

- css 적용 완료된 최종 버전을 올릴 예정
