package com.javalec.tea_pjt.controller.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javalec.tea_pjt.controller.member.MemberController;

@Controller
public class ImageUploadController {
	
	private static final Logger logger
	=LoggerFactory.getLogger(ImageUploadController.class);
	
	@RequestMapping("imageUpload.do")
	public void imageUpload(HttpServletRequest request
			,HttpServletResponse response,
			@RequestParam MultipartFile upload) 
					throws Exception {
		//http header의 인코딩 설정
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");
		//http body
		OutputStream out=null;
		PrintWriter printWriter=null;
		//업로드한 파일 이름
		String fileName=upload.getOriginalFilename();
		//파일내용을 바이트 배열로 변환
		byte[] bytes=upload.getBytes();
//개발디렉토리가 아닌 배포디렉토리로		
		String path = request.getRealPath("/");
		path = path + "WEB-INF\\views\\images\\";
		//OutputStream 생성
		out=new FileOutputStream(new File(
				path+fileName));
		out.write(bytes); //서버에 파일 저장
		//클라이언트에 업로드 결과를 표시
		String callback
			=request.getParameter("CKEditorFuncNum");
		printWriter = response.getWriter();
		String fileUrl = request.getContextPath()
				+"/images/"+fileName;
		printWriter.println(
"<script>window.parent.CKEDITOR.tools.callFunction("
+callback+",'"+fileUrl+"','이미지가 업로드되었습니다.')"
+"</script>");
		printWriter.flush();
		out.close();
	}
}





