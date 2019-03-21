package edu.autocar.cmmn.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileInfo {
	private String path;
	private String originalName;
	private String mimeType;
	private int size;
	
	public FileInfo(String path, String originalName, String mimeType) throws IOException{
		super();
		this.path = path;
		this.originalName = originalName;
		this.mimeType = mimeType;
		this.size = (int)Files.size(Paths.get(path));
	}
}
