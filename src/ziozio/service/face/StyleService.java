package ziozio.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ziozio.dto.Account;
import ziozio.dto.Style;
import ziozio.service.exception.AccountNotFountException;

public interface StyleService {

	/*
	 * DB에 존재하는 모든 스타일을 가져온다.
	 */
	List<Style> getAllStyles();

	/*
	 * 계정별로 설정된 선호 스타일만 가져온다.
	 */
	List<Style> getStylesByAccount(Account account);

	/*
	 * 위 두 메소드를 먼저 구현한 후,
	 * 로그인 된 사용자라면 로그인된 유저의 스타일을,
	 * 비로그인 사용자라면 모든 스타일을 가져오도록 구현한다.
	 * 위에 구현한 두 메소드를 가져다 사용하기만 하면 된다.
	 */
	List<Style> getAccountStyles(HttpServletRequest req) throws AccountNotFountException;
	
	List<Style> getSelectedStyles(HttpServletRequest req);
	
	int addStylesToAccount(Account account, List<Style> styles);
}
