package ziozio.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ziozio.dao.face.QnADAO;
import ziozio.dao.impl.QnADAOImpl;
import ziozio.dto.Account;
import ziozio.dto.Paging;
import ziozio.dto.QnA;
import ziozio.dto.QnAFile;
import ziozio.service.face.QnAService;

public class QnAServiceImpl implements QnAService {

	private QnADAO qnaDAO = new QnADAOImpl();
	
	
	@Override
	public List<QnA> getListAll() {
		return qnaDAO.selectAll();
	}

	@Override
	public List<QnA> getListAll(Paging paging) {
		return qnaDAO.selectAll(paging);
	}

	@Override
	public List<QnA> getListAccount(Account account) {
		return qnaDAO.selectAccount(account);
	}

	@Override
	public List<QnA> getListAccount(Account account, Paging paging) {
		return qnaDAO.selectAccount(account, paging);
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
		Paging paging = new Paging(totalCount, curPage, 20);
		
		return paging;
	}

	@Override
	public Paging getPaging(Account account, HttpServletRequest req) {

		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}		
		
		//Board TB와 curPage 값을 이용한 Paging 객체를 생성하고 반환
		int totalCount = qnaDAO.selectCntAccount(account); // DB는 쿼리스트링형태?
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage, 20);
		
		return paging;
	}
	
	@Override
	public QnA getQna_no(HttpServletRequest req) {
	
		//요청파라미터 qna_no를 파싱한다
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
	public QnAFile viewFile(QnA qna) {
		return qnaDAO.selectFile(qna);
	}

	@Override
	public void write(HttpServletRequest req) {
		
		QnA qna = null;
		QnAFile qnaFile = null;
//		QnAFile qnaFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			System.out.println("[ERROR multipart/form-fata 형식이 아님]");
			return;
		}
		
		//파일업로드를 사용하고 있을 경우
		qna = new QnA();

		//디스크팩토리
		DiskFileItemFactory factory = new DiskFileItemFactory();

		//메모리처리 사이즈
		factory.setSizeThreshold(1 * 1024 * 1024); //1MB

		//임시 저장소
		File repository=new File(req.getServletContext().getRealPath("tmp"));
		factory.setRepository(repository);
		
		//업로드 객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//용량 제한 설정 : 10MB
		upload.setFileSizeMax(10 * 1024 * 1024);
		
		//form-data 추출 
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//파싱된 데이터 처리 반복자
		Iterator<FileItem> iter = items.iterator();
		
		//요청정보 처리
		while( iter.hasNext() ) {
			FileItem item = iter.next();
			
			// 빈 파일 처리
			if( item.getSize() <= 0 )	continue;
			
			// form data 처리
			if( item.isFormField() ) {
				
				try {
					
					//제목 처리
					if( "title".equals( item.getFieldName() ) ) {
						qna.setQna_title( item.getString("utf-8") );
					}
					
					//본문 처리
					if( "content".equals( item.getFieldName() ) ) {
						qna.setQna_content( item.getString("utf-8") );
					}
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//작성자id 처리
				qna.setAccount_nick(((Account) req.getSession().getAttribute("account")).getAccount_nick());
				
			} else { //파일 처리
				UUID uuid = UUID.randomUUID();
				String u = uuid.toString().split("-")[4];
				
				//로컬 저장소 파일
				String stored = item.getName() + "_" + u;
				File up = new File(
					req.getServletContext().getRealPath("upload")
					, stored);
				
				//첨부파일 정보 객체
				qnaFile = new QnAFile();
				qnaFile.setOriginName(item.getName());
				qnaFile.setStoredName(stored);
				qnaFile.setFilesize(item.getSize());
				
				try {
					// 실제 업로드
					item.write(up);
					
					// 임시 파일 삭제
					item.delete();
					
				} catch (Exception e) {
					e.printStackTrace();
				} // try end
			} //if end
		} //while end
		

		//게시글 번호 생성
		int qna_no = qnaDAO.selectQna_no();
		
		//게시글 정보가 없을 경우 처리
		if(qna != null) {
			qna.setQna_no(qna_no); //게시글 번호 입력
			
			//게시글 제목 없을 경우 처리
			if(qna.getQna_title()==null || "".equals(qna.getQna_title())) {
				qna.setQna_title("(제목없음)");
			}

			qnaDAO.insert(qna); //게시글 삽입
		}
		
		//첨부파일 정보가 없을 경우 처리
		if(qnaFile != null) {
			qnaFile.setQna_no(qna_no); //첨부파일에 게시글 번호 입력
			
			qnaDAO.insertFile(qnaFile); //첨부파일 정보 삽입
		}
				
		
		
	}





	@Override
	public void update(HttpServletRequest req) {
		
		QnA qna = null;
		QnAFile qnaFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			//파일 첨부가 없을 경우
			qna = new QnA();

			qna.setQna_title(req.getParameter("title"));
			qna.setAccount_nick(((Account) req.getSession().getAttribute("account")).getAccount_nick());
			qna.setQna_content(req.getParameter("content"));
			
		} else {
			//파일업로드를 사용하고 있을 경우
			qna = new QnA();

			//디스크팩토리
			DiskFileItemFactory factory = new DiskFileItemFactory();

			//메모리처리 사이즈
			factory.setSizeThreshold(1 * 1024 * 1024); //1MB

			//임시 저장소
			File repository=new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			//업로드 객체 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//용량 제한 설정 : 10MB
			upload.setFileSizeMax(10 * 1024 * 1024);
			
			//form-data 추출 
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//파싱된 데이터 처리 반복자
			Iterator<FileItem> iter = items.iterator();
			
			//요청정보 처리
			while( iter.hasNext() ) {
				FileItem item = iter.next();
				
				// 빈 파일 처리
				if( item.getSize() <= 0 )	continue;
				
				// 빈 파일이 아닐 경우
				if( item.isFormField() ) {
					try {
						if( "boardno".equals( item.getFieldName() ) ) {
							qna.setQna_no( Integer.parseInt(item.getString()) );
						}
	
						if( "title".equals( item.getFieldName() ) ) {
							qna.setQna_title( item.getString("utf-8") ); 
						}
						if( "content".equals( item.getFieldName() ) ) {
							qna.setQna_content( item.getString("utf-8") );
						}

						qna.setAccount_nick(((Account) req.getSession().getAttribute("account")).getAccount_nick());
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				} else {
					UUID uuid = UUID.randomUUID();
					String u = uuid.toString().split("-")[4];

					//로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("upload")
						, stored);
					
					qnaFile = new QnAFile();
					qnaFile.setOriginName(item.getName());
					qnaFile.setStoredName(stored);
					qnaFile.setFilesize(item.getSize());
					
					try {
						// 실제 업로드
						item.write(up);
						
						// 임시 파일 삭제
						item.delete();
						
					} catch (Exception e) {
						e.printStackTrace();
					} // try end
				} //if end
			} //while end
		} //if(!isMultipart) end
		

//		System.out.println(board);
//		System.out.println(boardFile);
		
		if(qna != null) {
			qnaDAO.update(qna);
		}
		
		if(qnaFile != null) {
			qnaFile.setQna_no(qna.getQna_no());
			qnaDAO.insertFile(qnaFile);
		}
	}

	@Override
	public String getNick(QnA qna) {
		return qnaDAO.selectAccount_nickByAccount_Nick(qna);
	}

	@Override
	public void delete(QnA qna) {
		
		qnaDAO.deleteFile(qna);

		qnaDAO.delete(qna);
	}

	@Override
	public boolean checkNick(HttpServletRequest req) {

		//로그인한 세션 ID 얻기
		String loginNick = (((Account) req.getSession().getAttribute("account")).getAccount_nick());

		//작성한 게시글 번호 얻기
		QnA qna = getQna_no(req);
		
		//게시글 얻어오기
		qna = qnaDAO.selectQnaByQna_no(qna);

		//게시글의 작성자와 로그인 아이디 비교
		if( !loginNick.equals(qna.getAccount_nick()) ) {
			return false;
		}
		
		return true;

	}



}
