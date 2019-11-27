package web.dao.face;

import web.dto.Member;

public interface MemberDao {


	/**
	 * userid와 userpw가 일치하는 회원 수 조회
	 * 
	 * @param member - userid와 userpw를 가진 회원
	 * @return int - 1(존재하는 회원), 0(존재하지않는회원), -1(에러)
	 */
	public int selectCntMemberByUseridAndUserpw(Member member); 

	/**
	 * userid로 유저정보 조회
	 * 
	 * @param member - 조회할 회원, userid 필수
	 * @return Member - 조회된 결과
	 */
	public Member selectMemberByUserid(Member member);

	/**
	 * 회원가입
	 * 
	 * @param member - 회원가입 정보
	 */
	public void insert(Member member);

}