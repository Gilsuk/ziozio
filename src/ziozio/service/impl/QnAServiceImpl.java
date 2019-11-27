package ziozio.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ziozio.dao.face.QnADAO;
import ziozio.dao.impl.QnADAOImpl;
import ziozio.dto.Paging;
import ziozio.dto.QnA;
import ziozio.service.face.QnAService;

public class QnAServiceImpl implements QnAService {

	private QnADAO qnaDAO = new QnADAOImpl();
	
	
	@Override
	public List getList() {
		return qnaDAO.selectAll();
	}

	@Override
	public List getList(Paging paging) {
		return qnaDAO.selectAll(paging);
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}		
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = qnaDAO.selectCntAll(); // DB는 쿼리스트링형태?
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		


		return paging;
	}

	@Override
	public QnA getQnAno(HttpServletRequest req) {
	
		//요청파라미터 boardno를 파싱한다
		String param = req.getParameter("qna_no");
		int qna_no = 0;
		if( param!=null && !"".equals(param) ) {
			qna_no = Integer.parseInt(param);
		}
		
		//게시글 번호를 DTO에 넣기
		QnA qna = new QnA();
		qna.setQna_no(qna_no);
		
		return qna;
	}

	@Override
	public QnA view(QnA viewQna) {
	
		//게시글 조회 반환
		return qnaDAO.selectQnaByQna_no(viewQna);
	}

	@Override
	public void write(HttpServletRequest req) {
		
		QnA qna = null;
//		QnAFile qnaFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			System.out.println("[ERROR multipart/form-fata 형식이 아님]");
			return;
		}
		
	}

//	@Override
//	public BoardFile viewFile(QnA qna) {
//		return qnaDAO.selectFile(qna);
//	}



	@Override
	public void update(HttpServletRequest req) {
		
	}

	@Override
	public String getNick(QnA qna) {
		return qnaDAO.selectAccount_nickByAccount_Email(qna);
	}

	@Override
	public void delete(QnA qna) {
		
		qnaDAO.deleteFile(qna);

		qnaDAO.delete(qna);
	}





}
