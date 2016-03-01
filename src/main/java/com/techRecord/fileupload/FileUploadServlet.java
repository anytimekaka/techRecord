package com.techRecord.fileupload;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * TODO
 * @author wang.guisheng@sfit.shfe.com.cn
 * @date 2016年2月16日 下午4:18:36
 * @version V1.0
 */
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = -2797515312087051904L;

	public void doPost( HttpServletRequest request, HttpServletResponse response ) {
		FileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
	     //  允许文件最大长度
		servletFileUpload.setSizeMax( 100*1024*1024 );
	     //  设置内存缓冲大小
//		servletFileUpload.setSizeThreshold( 4096 );
	     //  设置临时目录
//		servletFileUpload.setRepositoryPath( "C:/Users/wang.guisheng/Desktop/Temp/temp" );
	 
	     List<FileItem> fileItems = null;
		try {
			fileItems = servletFileUpload.parseRequest(new ServletRequestContext(request));
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     Iterator<FileItem> iter = fileItems.iterator();
	     for( ; iter.hasNext(); ) {
	         FileItem fileItem = (FileItem) iter.next();
	         if( fileItem.isFormField() ) {
	             //  当前是一个表单项
	             System.out.println( "form field : " + fileItem.getFieldName() + ", " + fileItem.getString() );
	         } else {
	             //  当前是一个上传的文件
	             String fileName = fileItem.getName();
	             try {
					fileItem.write( new File("C:/Users/wang.guisheng/Desktop/Temp/temp/"+fileName));
				} catch (Exception e) {
					e.printStackTrace();
				}
	         }
	     }
	}
}
