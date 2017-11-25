package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;

public class Tools {
	/**
	 * 传入一个文件名,将其加工为不重复的uuid
	 * @param name
	 * @return
	 */
			
	public String renameFile(String fliename){
		int beginIndex =fliename.lastIndexOf("."); 
		String lastname = fliename.substring(beginIndex, fliename.length());
		String uuidname = UUID.randomUUID().toString()+lastname;
		return uuidname;
	}
	
	
	public boolean Upload(String path,FormFile file){
		
		InputStream is = null;
		OutputStream os = null;
		boolean flag = true;
		try {
			//得到输入流文件
			is = file.getInputStream();
			
			//得到输出流文件
			os = new FileOutputStream(path);
			//缓存
			int len = 0;
			byte[] bytes = new byte[1024] ;
			
			while ((len = is.read(bytes))>0){
				os.write(bytes, 0, len);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}finally{
			try {
				is.close();
				os.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return flag;
	}
	public boolean Download(String path,HttpServletResponse response){
		
		InputStream is = null;
		OutputStream os = null;
		boolean flag = true;
		try {
			//创建流文件
			is = new FileInputStream(path);

			//得到输出流文件
			os = response.getOutputStream();
			//缓存
			int len = 0;
			byte[] bytes = new byte[1024] ;
			
			while ((len = is.read(bytes))>0){
				os.write(bytes, 0, len);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}finally{
			try {
				is.close();
				os.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		
		
		
		return flag;	
	}
}
