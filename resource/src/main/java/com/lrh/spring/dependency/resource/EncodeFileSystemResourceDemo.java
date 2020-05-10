package com.lrh.spring.dependency.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 *  带有字符编码的 {@link FileSystemResource} 示例
 * @description:
 * @author: lrh
 * @date: 2020/5/10 17:31
 * @see FileSystemResource
 * @see EncodedResource
 */
public class EncodeFileSystemResourceDemo {

	public static void main(String[] args) throws IOException {
		String currentJavaFilePath =  System.getProperty("user.dir") + "/resource/com/lrh/spring/dependency/resource/EncodeFileSystemResourceDemo.java";
		File currentFile = new File(currentJavaFilePath);
		FileSystemResource fileSystemResource = new FileSystemResource(currentFile);
		EncodedResource encodedResource = new EncodedResource(fileSystemResource,"UTF-8");
		//字符输入流
		try (Reader reader = encodedResource.getReader()) {
			System.out.println(IOUtils.toString(reader));
		}


	}
}
