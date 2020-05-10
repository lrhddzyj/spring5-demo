package com.lrh.spring.dependency.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
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
public class EncodeFileSystemResourceLoaderDemo {

	public static void main(String[] args) throws IOException {
		String currentJavaFilePath = "/" + System.getProperty("user.dir") + "/resource/com/lrh/spring/dependency/resource/EncodeFileSystemResourceDemo.java";
//		File currentFile = new File(currentJavaFilePath);
		FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
		Resource resource = fileSystemResourceLoader.getResource(currentJavaFilePath);
		EncodedResource encodedResource = new EncodedResource(resource);
		//字符输入流
		try (Reader reader = encodedResource.getReader()) {
			System.out.println(IOUtils.toString(reader));
		}


	}
}
