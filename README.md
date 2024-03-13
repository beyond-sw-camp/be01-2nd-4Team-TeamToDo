<h1 align="center"> To_DO List 개인 및 팀 버전  </h1>

[초기 공동 작업 git 바로가기](https://github.com/CoffeerLatte/git-4team)


-----------------------------
```


전승민(팀장), 박대호, 김민성, 심규혁


```



----------------------------------------------------------------------------------------------------------------------------------------------------------------

[Google Sheet(4팀 프로젝트 문서)](https://docs.google.com/spreadsheets/d/1W5FWxfUWDjQPUbMkPeahi3Vn_Bxx6TmZ9QnIumbHlPE/edit?usp=sharing)


### 프로젝트 목표 :

개인이 사용할 수 있는 To-Do List 및 구성원과 팀원이 서로 공유하고 볼 수 있는 To-Do list를 만들어보자.

사용 기술 스택: spring boot, rest api, maven, mariadb


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

------------------------------------------------------------------------------------------------------------------------------------------------------------------

<details>
<summary> # 요구 사항 및 기능</summary>

```

1. 회원가입 ( + 로그인 기능) (세션 사용)

2. 개인 To-Do List                                            ​

3. 날짜, 내용 입력하여 할 일 추가                                            ​

4. 날짜,  할 일, 수행 여부 확인 가능 ​

5. 날짜,  할 일, 수행 여부 변경 가능  + 삭제 기능                                             ​

7. 팀 To-Do List​

8. 팀별 To-Do만 따로 확인 및 기능 구현 + 전체 팀(default)​

9. 팀별 날짜, 내용 입력하여 할 일 추가 + 팀 id 기입 ​

10. 팀원 날짜, 할 일, 수행 여부  확인 가능                                        ​

11. 팀원 날짜, 할 일, 수행 여부 변경 가능 + 삭제 기능​

12. 팀 To-Do <-> 개인 To-Do  버튼을 이용한 자유로운 이동​

13. 팀 및 개인 To-Do에서 로그아웃 기능 및 개인  마이 페이지(계정 정보)​

```
</details>

------------------------------------------------------------------------------------------------------------------------------------------------------------------

<details>
<summary> # 초기 구성 </summary>
  
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/76007f30-4c8a-4c18-9863-cff0406a49d2)

* 기본적인 데이터 입력 및 수정, 제거 기능 구현. todo의 기능 구현


초기 구성 flow

![ToDo_flow](https://github.com/CoffeerLatte/git-4team/assets/80744883/4be876c3-ae46-47e7-8514-f8a812527932)

* todo 사용자 -> 회원가입 유무를 본인이 확인 -> 아이디가 있다면 로그인 -> 개인 Todo List 사용 -> 팀 Todo List 사용 -> 개인 Todo List 사용(자유롭게 이동 가능)
  
> 아이디가 없다면 회원가입

> 팀용 todolist에서의 팀원들 마다 구별법 추후 구상.

![캡처](https://github.com/CoffeerLatte/git-4team/assets/125641153/9225727a-c756-491b-a76a-651649f2b6c6)

* 사용하게 될 기본적인 table 구상.
  
</details>

-----------------------------------------------------------------------------------------------------------------------------------------------------------

<details>

  <summary> # 구현완료된 동작에 대한 캡쳐 및 설명 </summary>
  
개인 할일 페이지지 Rest로 구현

// 개인 페이지에서의 todo 작성
![insert](https://github.com/CoffeerLatte/git-4team/assets/76561901/7e5716f6-620a-4d71-81b0-c0a84ac43a23)


// 개인 페이지에서의 todo 작성 결과

![insert2](https://github.com/CoffeerLatte/git-4team/assets/76561901/4f8c6cf8-91a4-4846-85ed-52c4992158c9)

// 개인 페이지에서의 todo 열람
![get](https://github.com/CoffeerLatte/git-4team/assets/76561901/f7d411bc-e407-4c91-b55d-4e5758989698)

// 개인 페이지에서의 todo 수정
![update](https://github.com/CoffeerLatte/git-4team/assets/76561901/b인 할일 페이지 구현

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
로그인 및 회원가입

// 로그인
![로그인](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/0b2bda0b-ce83-44b2-bd92-36deb37fabba)

// 회원가입
![회원가입](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/783ec273-0121-4848-84e5-1b62508c4e26)

//비밀번호가 틀렸을 경우
![회원가입 비밀번호](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/5bc97e0d-c65e-4fac-a8b8-3a201e33f58f)

// 다른 회원이 사용중인 닉네임의 경우
![회원가입 중복](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/9502381d-cffa-4f21-a6ab-5cae21d7a419)

// 로그인 시 자신만의 개인 todo리스트로 이동
![개인 todo](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/e49995f8-0b95-492f-9fe3-413726c32ac5)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

개인 할일 페이지

// 개인 페이지에서의 todo 작성
![개인todo메인](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/36bd0790-9808-48e9-a3dc-614e8b18b842) 

// 버튼 정상 동작
![개인todo완료](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/42232a2b-bfb4-4e71-9b9e-0cd0b20794e8)

// 개인 페이지에서의 수정 정상 기능
![개인todo수정](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/bf50ff9d-821e-497d-8396-97a1bfd92ed2)

// 개인 페이지에서의 데이터 삭제 정상
![개인todo삭제](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/0795dc7c-9818-421b-94bb-7911157888c4)

// 개인 페이지에서의 수정, 삭제 이후
![개인 수정 삭제 이후](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/2ac061fb-35ab-4624-9f1a-36b9fc96d9f3)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

팀 할일 버튼 및 로그아웃 버튼 상호 작용 가능.

// 팀 할일 페이지
![팀 todo](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/48ee7f8c-205f-4b8e-8a4d-a6840a0a816b)

// 팀 할일 페이지에서의 todo 삭제 메시지 띄우기
![팀 삭제](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/505a153a-fbd3-4f72-a6a6-9132d67fe9ba)

// 팀 할일 페이지에서 수정 버튼을 눌러서 완수 날짜 및 할일을 수정하는 캡쳐
![팀 수정](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/b3286e66-8720-41d5-ad84-03283af484e3)

// 팀 할일 페이지에서 수정, 삭제 이후
![팀 수정 삭제 이후](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/309160cd-3ace-4657-9afd-6a9736348593)

// 완료 버튼 정상 동작
![팀 완료](https://github.com/beyond-sw-camp/be01-2nd-4Team-TeamToDo/assets/80744883/a77f862b-138f-4eb4-a3cb-864ece1b3404)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// maria db 데이터 베이스에 쌓이는 todoentity 정보 (팀)

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/3777d2c1-dca3-4da4-9037-3c804a17fa43) 

// maria db 데이터 베이스에 쌓이는 todoentity 정보 (개인)

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/4aaf1122-e8f7-4ef7-97fc-079cbbbe3635) 


// maria db 데이터베이스에 쌓이는 회원가입한 계정 정보

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/36771c35-b123-4c29-abfb-0fe82e4b50ff) 

</details>

-----------------------------------------------------------------------------------------------------------------------------------------------------------

<details>
  <summary> # 개선 및 추가 예정 사항 </summary>

1. jwt 토큰 방식으로의 로그인
2. 관리자 권한 기능 추가
3. 팀원 구별 추가(닉네임/id)

</details>

-----------------------------------------------------------------------------------------------------------------------------------------------------------

<details>
  <summary> # 문제점 및 힘들었던 부분 </summary>

로그인 시 세션과 ToDo List 연결 과정

원인
-> 서로다른 테이블을 join하는 방법으로 원하는 데이터를 가져오려고 함.

-> join 과정에서 데이터 타입이 달라서 타입 변환하는데 어려움 발생.

해결
-> joincolumn을 사용하지 않고, 로그인을 하자마자, 로그인하는 파트에서 바로 데이터를 넘겨주는 방식으로 해결.
![tempsnip](https://github.com/CoffeerLatte/git-4team/assets/125641153/40d58adc-6a8d-43a4-a431-5ff388d64dfc)
[해결 캡처]

-----------------------------------------------------------------------------------------------------------------------------------------------------------

session login + TodoList + team_todolist  연동과정

안되었던 부분
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/3ab1ec85-0ba9-4d6b-bfec-046437a87e81)

원인
-> team_todolist 수정 과정에서 코드에서 문제는 없었지만, html 에서 JSON 방식으로 넘겨 받는 과정에서 JSON 형식에 맞지 않아 에러 발생

해결
-> html 에서 입력받는 데이터를 JSON 형식에 맞게 전달하여 해결.

-----------------------------------------------------------------------------------------------------------------------------------------------------------

리다이렉션 문제

원인
-> 데이터를 update, insert, delete, complete 과정 후 나서 원하는 페이지로 redirection이 되지 않고, 메인 페이지로 이동.

해결
-> resource / template/ teamtodo.html 파일을 수정하여 update, delete, complete 과정에서 데이터 이동 동작 후 page를 reload하게 만듬.

-> 데이터를 입력 후 입력한 데이터가 현재 html 페이지에 정상 반영됨.

-----------------------------------------------------------------------------------------------------------------------------------------------------------

개인 To-Do List에서의 다른 사용자의 개인 할 일이 보이는 문제
  
원인
-> 로그인 시 로그인 정보를 get, set 하는 방식 사용.

-> 여러 사람이 로그인 시 가장 최근에 로그인한 사용자의 정보를 set함.

-> 다른 사람들도 가장 최근에 로그인한 사용자의 정보를 set하는 문제 발생.

해결
-> 로그인 시 사용자의 세션 정보를 가져오는 방식 사용.

-> 여러명이 로그인 해도 각 사용자들의 세션 정보에서 id를 가져올 수 있게 됨.


</details>


