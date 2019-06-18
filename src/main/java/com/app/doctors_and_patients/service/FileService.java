package com.app.doctors_and_patients.service;

import com.app.doctors_and_patients.exception.AppException;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public interface FileService {

    static String getRootImagePath() {
        return FileService.class.getResource("").getPath().substring(1).split("target")[0] + "src/main/resources/static/img/";
    }

    static String getImageName(MultipartFile file) {
        String[] filenameElements = file.getOriginalFilename().split("\\.");
        return UUID.randomUUID().toString() + "." + filenameElements[1];
    }

    static String save(MultipartFile file) {

        try {

            if (file == null) {
                throw new AppException("Save file - file object is null");
            }

            if (file.getBytes().length == 0) {
                throw new AppException("Save file - file is not correct");
            }

            final String imgPath = getRootImagePath();
            final String imgName = getImageName(file);
            FileCopyUtils.copy(file.getBytes(), new File(imgPath + imgName));
            return imgName;

        } catch (Exception e) {
            throw new AppException("Save file exception");
        }

    }

    static boolean update(MultipartFile file, String filename) {

        try {
            if (file == null) {
                throw new AppException("Save file - file object is null");
            }

            if (file.getBytes().length == 0) {
                throw new AppException("Save file - file is not correct");
            }

            if (filename == null) {
                throw new AppException("Filename is null");
            }

            final String imgRoot = getRootImagePath();
            FileCopyUtils.copy(file.getBytes(), new File(imgRoot + filename));
            return true;

        } catch (Exception e) {
            throw new AppException("Update file exception");
        }

    }

    static boolean remove(String filename) {
        try {

            if (filename == null) {
                throw new AppException("Filename is null");
            }

            final String imgRoot = getRootImagePath();
            return new File(imgRoot + filename).delete();

        } catch (Exception e) {
            throw new AppException("Delete file exception");
        }
    }

}
