# ziozio
똑똑한 의상 추천 플랫폼 (semi-project)

## 해야할 일 (TODO)
- 공지사항 게시판에 로그아웃 상태로 글 쓸 수 있음.(지오는 해결하시오)
- 공지사항 게시판, 공지사항 댓글, 공지사항 파일업로드 테이블 생성 SQL 문을 /resources/sql/.. 에 추가
- 소셜 로그인
- 이메일 계정 인증 & 계정 찾기
- 날씨 정보 가져오기(ajax)
- 미세먼지 가져오기(ajax)
- 의상추천 알고리즘
- 좋아요
- 마이페이지

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
2. cloth
3. style
4. cloth_combined

### 아래 테이블들은 순서 없이 작동 가능
- cloth_style
- cloth_weather
- cloth_weather_grade
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
- [클래스 다이어그램](https://www.draw.io/?state=%7B%22ids%22:%5B%221REHZqw83wSpMwfWqOtHbWFYzI6dvh_42%22%5D,%22action%22:%22open%22,%22userId%22:%22112892481326909512500%22%7D#G1REHZqw83wSpMwfWqOtHbWFYzI6dvh_42)
- [ERD](https://www.erdcloud.com/d/F7wreMfCbCMhmc2H5)
- [스토리보드](https://docs.google.com/presentation/d/1nyAoGdxpssrEMZWDgQZHmT5UBk-hUczQGKG47H1k50o/edit#slide=id.p)
