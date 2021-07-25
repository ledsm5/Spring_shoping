package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

public class FileDownLoad {
	public void fileDown(String path,String store,String original, HttpServletRequest request, HttpServletResponse response) { //메서드
		String RealPath =request.getServletContext().getRealPath(path);
		String originalFileName = "";
		try {
			originalFileName = URLEncoder.encode(original,"UTF-8"); //한글일때 깨지는거 때문에
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/* 우리가 html로 설정을 해줬기 때문에 이걸 바꿔줘야 한다.
		 * contentType="text/html;*/		
		response.setContentType("application/octet-stream; charset=utf-8");
		
		//original 파일네임으로 다운하기위한 설정 
		response.setHeader("Content-Disposition", "attachment;filename=\"" + originalFileName + "\";");
		response.setHeader("Content-Transefer-Encoding", "binary");
		
		
		File file = new File(RealPath + "/" + store);
		ServletOutputStream out1 = null; //웹 브라우저에서 다운로드 되기위한 객체
		//파일을 웹브라우저에 전송
		FileInputStream fis = null;
		try {
			out1 = response.getOutputStream();
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out1);
			response.flushBuffer();
			out1.flush();
			out1.close();
		} catch (IOException e) {
		}finally {
			if(fis!= null) {
				try {fis.close();} catch (IOException e) {}
			}
		}
		
	}
}
