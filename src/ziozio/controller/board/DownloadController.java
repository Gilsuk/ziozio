package ziozio.controller.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import ziozio.dao.face.BoardDao;
import ziozio.dao.impl.BoardDaoImpl;
import ziozio.dto.BoardFile;

/**
 * Servlet implementation class DownloadController
 */
@WebServlet("/file/download")
public class DownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("fileno");

		int fileno = 0;
		if( param!=null && !"".equals(param) ) {
			fileno = Integer.parseInt(param);
		}

		// 다운로드 대상 파일 정보 찾기
		BoardFile downFile = boardDao.selectByFileno(fileno);

		//다운로드 파일 찾기
		String path = getServletContext().getRealPath("upload");
		File file = new File(
				path, downFile.getStoredName() );

		// 파일이 존재할 때만 동작
		if( file.exists() && file.isFile() ) {

			//응답 정보 설정 ( Response 메시지 header 수정 )

			//응답 본문 길이
			resp.setHeader(
					"Content-Length", String.valueOf(file.length()));

			//응답 파일 저장 위치 지정
			resp.setHeader(
					"Content-Disposition", 
					"attachment;fileName=\"" + new String(downFile.getOriginName().getBytes("UTF-8"), "8859_1" ) + "\";" );

			// text/html;charset=utf-8
			//다운 받는 내용을 바이너리파일로 인식시키기
			resp.setContentType("application/octet-stream");


			//파일 입력 스트림 (서버 로컬 저장소(하드디스크))
			InputStream is = new FileInputStream(file);

			//파일 출력 스트림 (브라우저)
			OutputStream os = resp.getOutputStream();

			//파일 전송
			IOUtils.copy(is, os);
			os.flush();

			is.close();
			os.close();

		}
	}

}
