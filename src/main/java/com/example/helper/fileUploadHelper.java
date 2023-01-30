package com.example.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploadHelper {

	private Path path;
    String rootJson;
	
	@Override
	public String toString() {
		return "fieldConstant [rootJson=" + rootJson + "]";
	}
	public String getRootJson() {
		return rootJson;
	}

	public void setRootJson(String rootJson) {
		this.rootJson = rootJson;
	}
	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	// public final String
	// UPLOAD_DIR_URL="E:\\hello-world\\src\\main\\resources\\static\\files";
	public final String UPLOAD_DIR = new ClassPathResource("static\\files\\").getFile().getAbsolutePath();

	public fileUploadHelper() throws IOException {
	}

	public boolean uploadFile(MultipartFile multipartfile) {
		boolean flag = false;
		try {
			long copy = Files.copy(multipartfile.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multipartfile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			setPath(Paths.get(UPLOAD_DIR + File.separator + multipartfile.getOriginalFilename()));
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
