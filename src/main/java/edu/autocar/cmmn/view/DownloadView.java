package edu.autocar.cmmn.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import edu.autocar.post.model.FileVO;

@Component("download")
public class DownloadView extends AbstractView{
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FileVO fi = (FileVO)model.get("vo");
		
		File file = (File)model.get("file");
		
		response.setContentType("application/download; charset=utf-8");
		response.setContentLength((int)file.length());
		response.setHeader("Content-Disposition", 
				"attachment; filename=\"" + fi.getName() + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		
		OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream(file);
            
            FileCopyUtils.copy(fis, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            
            out.flush();
        }


	}
}
