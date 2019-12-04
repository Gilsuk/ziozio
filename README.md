# ziozio
똑똑한 의상 추천 플랫폼 (semi-project)

## 해야할 일 (TODO)
- (서지오)공지사항 게시판에 로그아웃 상태로 글 쓸 수 있음.
- (서지오)/resources/sql/later.sql나누기
- (고인호)날씨 정보 가져오기(ajax) (날씨 페이지)
- (고인호)미세먼지 가져오기(ajax) (미세먼지 페이지)
- (고인호)의상추천 알고리즘
- 호불호 표시
- (박윤솔)관리자
- (박윤솔)소셜 로그인
- 마이페이지 (개인정보 수정 (닉네임, 비밀번호 변경))
- 마이페이지 ( 내옷장, 선호하는 패션, 옷커스텀 페이지(컨트롤러)
- 회원가입에 정규식 만들기
- 프로필사진 업로드
- 개인정보 처리 방침, 이용약관페이지 / 동의
- 회원탈퇴 기능
- 메세지 알림기능(표시, 읽음, 안읽음 기능)
- 이메일 계정 인증 & 계정 찾기
- ClothDAOImpl 450행 중복처리 SQLException 해야됨!!
-QnA write, update, view 오류 처리해야함. 글쓰기에서 작성누르면 에러..
- style 별 옷 리스트 출력시 다중선택 가능하게
- StyleServiceImpl에서 파라미터 분석 메서드 미구현
- 옷 최종 반환시 색깔 넣어서 반환


## sql 쿼리 작동 순서

### account
1. account_grade
2. account
3. cookie

### weather
1. location
2. weather
3. temperature_grade
4. weather_info

### cloth
1. cloth_category
2. style
3. cloth
4. color
5. cloth_set

### 아래 테이블들은 위 작업 이후 순서 없이 작동 가능
- cloth_style
- cloth_weather
- cloth_temperature_grade
- account_style
- account_library
- account_like

## 개발환경
windows 10, apache-tomcat v9.0.27, eclipse EE 2019-9, openjdk-11, oracle, javascript, html, css

## 개발환경 세팅 가이드
[위키 페이지](https://github.com/Gilsuk/ziozio/wiki/%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD-%EC%84%B8%ED%8C%85%ED%95%98%EA%B8%B0)

## 설계서
- [요구사항 정의서](https://docs.google.com/spreadsheets/d/1oa3t7seEsTh60JEOmgY0olRsSnVOR4yWjhi9Btae1Qk/edit#gid=0)
- [요구사항 명세서](https://docs.google.com/spreadsheets/d/1oa3t7seEsTh60JEOmgY0olRsSnVOR4yWjhi9Btae1Qk/edit#gid=1204896733)
- [클래스 다이어그램](https://drive.google.com/file/d/1REHZqw83wSpMwfWqOtHbWFYzI6dvh_42/view?usp=sharing)
- [ERD](https://www.erdcloud.com/d/F7wreMfCbCMhmc2H5)
- [스토리보드](https://docs.google.com/presentation/d/1nyAoGdxpssrEMZWDgQZHmT5UBk-hUczQGKG47H1k50o/edit#slide=id.p)
