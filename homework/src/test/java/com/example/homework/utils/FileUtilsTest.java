package com.example.homework.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;

@SpringBootTest
public class FileUtilsTest {

    @Test
    public void test_file1() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            FileUtils.getSize(Path.of("E:/课件/java/Lecture1.pptx"));
        });
    }

    @Test
    public void test_file2() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            FileUtils.getSize(Path.of("E:/课件/java/Lecture01.pptx"));
        });
    }

    @Test
    public void test_file3() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            FileUtils.getSize(Path.of("E:/课件/java/ajdk.docx"));
        });
    }
}
