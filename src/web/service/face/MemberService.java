package web.service.face;

import javax.servlet.http.HttpServletRequest;

import web.dto.Member;

public interface MemberService {

	/**
	 * 로그인 정보 파싱
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 로그인 정보
	 */
	public Member getLoginMember(HttpServletRequest req);

	/**
	 * 회원가입 정보 파싱
	 * 
	 * @param req - 요청 정보 객체
	 * @return Member - 회원가입 정보
	 */
	public Member getJoinMember(HttpServletRequest req);

	/**
	 * 로그인 처리
	 * 
	 * @param member - 로그인 정보
	 * @return boolean - true(인증), false(비인증)
	 */
	public boolean login(Member member);

	/**
	 * 유저정보가져오기
	 * 
	 * @param member - 회원 아이디를 가진 객체
	 * @return Member - 조회된 회원
	 */
	public Member getMemberByUserid(Member member);

	/**
	 * 회원가입
	 * 
	 * @param member - 회원가입 정보 객체;
	 */
	public void join(Member member);

}
