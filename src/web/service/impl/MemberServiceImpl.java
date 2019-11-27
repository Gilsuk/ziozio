package web.service.impl;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.MemberDao;
import web.dao.impl.MemberDaoImpl;
import web.dto.Member;
import web.service.face.MemberService;

public class MemberServiceImpl implements MemberService {

	//MemberDao 객체
	private MemberDao memberDao = new MemberDaoImpl();

	@Override
	public Member getLoginMember(HttpServletRequest req) {
		Member member = new Member();

		member.setUserid(req.getParameter("userid"));
		member.setUserpw(req.getParameter("userpw"));

		return member;
	}

	@Override
	public Member getJoinMember(HttpServletRequest req) {
		Member member = new Member();

		member.setUserid(req.getParameter("userid"));
		member.setUserpw(req.getParameter("userpw"));
		member.setUsernick(req.getParameter("usernick"));

		return member;
	}

	@Override
	public boolean login(Member member) {

		if( memberDao.selectCntMemberByUseridAndUserpw(member) >= 1 ) {
			//로그인 성공
			return true;

		} else {
			//로그인 실패
			return false;

		}

	}

	@Override
	public Member getMemberByUserid(Member member) {
		return memberDao.selectMemberByUserid(member);
	}

	@Override
	public void join(Member member) {
		memberDao.insert(member);
	}

}

