package edu.autocar.cmmn.view;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import edu.autocar.cmmn.domain.FileInfo;

@Component("download")
public class DownloadView extends AbstractView{
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FileInfo fi = (FileInfo)model.get("fileInfo");
		
		response.setContentType(fi.getMimeType());
		response.setContentLength(fi.getSize());
		response.setHeader("Content-Disposition", 
				"attachment; filename=\"" + fi.getOriginalName() + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		Path source = Paths.get(fi.getPath());
		Files.copy(source, response.getOutputStream());	
	}
}
