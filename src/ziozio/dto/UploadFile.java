package ziozio.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import ziozio.dto.face.DTO;
import ziozio.dto.face.Selectable;

public class UploadFile implements DTO<UploadFile>, Selectable<UploadFile> {
	
	int fileno;
	long filesize;
	String filename;
	String storedFileName;
	String uploaderIp;
	int year;
	int month;
	int day;
	@Override
	public String toString() {
		return "UploadFile [fileno=" + fileno + ", filesize=" + filesize + ", filename=" + filename
				+ ", storedFileName=" + storedFileName + ", author=" + uploaderIp + ", year=" + year + ", month=" + month
				+ ", day=" + day + "]";
	}
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public String getuploaderIp() {
		return uploaderIp;
	}
	public void setuploaderIp(String author) {
		this.uploaderIp = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	@Override
	public UploadFile setFieldFromResultSet(ResultSet rs) throws SQLException {
		this.fileno = rs.getInt("fileno");
		this.filename = rs.getString("filename");
		this.storedFileName = rs.getString("storedname");
		this.filesize = rs.getLong("size");
		this.uploaderIp = rs.getString("uploader_ip");
		this.year = rs.getInt("year");
		this.month = rs.getInt("month");
		this.day = rs.getInt("day");

		return this;
	}
}
