package com.lrh.spring.dependency.resource;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.PathMatcher;

/**
 * 自定义 ${@link ResourcePatternResolver} 实现
 *
 * @author lirh
 * @version 2021年03月07日 6:27 下午
 * @see ResourcePatternResolver
 * @see org.springframework.core.io.support.PathMatchingResourcePatternResolver
 */
public class CustomizedResourcePatternResolverDemo {

  public static void main(String[] args) throws IOException {
    String path = "/" + System.getProperty("user.dir")
        + "/leaning-in-spring/resource/src/main/java/com/lrh/spring/dependency/resource/";
    String pattern = path + "*.java";
    PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(
        new FileSystemResourceLoader());

    resourcePatternResolver.setPathMatcher(new JavaFilePathMatcher());
    Resource[] resources = resourcePatternResolver.getResources(pattern);
    Stream.of(resources).map(s -> {
      try {
        EncodedResource encodedResource = new EncodedResource(s, StandardCharsets.UTF_8);

        try (Reader reader = encodedResource.getReader()) {
          return IOUtils.toString(reader);
        }

      } catch (IOException e) {
        e.printStackTrace();
      }
      return "";

    }).forEach(System.out::println);


  }

  static class JavaFilePathMatcher implements PathMatcher {

    @Override
    public boolean isPattern(String path) {
      return path.endsWith(".java");
    }

    @Override
    public boolean match(String pattern, String path) {
      return path.endsWith(".java");
    }

    @Override
    public boolean matchStart(String pattern, String path) {
      return false;
    }

    @Override
    public String extractPathWithinPattern(String pattern, String path) {
      return null;
    }

    @Override
    public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
      return null;
    }

    @Override
    public Comparator<String> getPatternComparator(String path) {
      return null;
    }

    @Override
    public String combine(String pattern1, String pattern2) {
      return null;
    }
  }



}
