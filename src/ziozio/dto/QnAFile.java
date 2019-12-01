package ziozio.dto;

import java.util.Date;

public class QnAFile {

	private int qnafile_no;
	private int qna_no;
	private String originName;
	private String storedName;
	private long filesize;
	private Date writeDate;
	@Override
	public String toString() {
		return "QnAFile [qnafile_no=" + qnafile_no + ", qna_no=" + qna_no + ", originName=" + originName
				+ ", storedName=" + storedName + ", filesize=" + filesize + ", writeDate=" + writeDate + "]";
	}
	public int getQnafile_no() {
		return qnafile_no;
	}
	public void setQnafile_no(int qnafile_no) {
		this.qnafile_no = qnafile_no;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getStoredName() {
		return storedName;
	}
	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
}
