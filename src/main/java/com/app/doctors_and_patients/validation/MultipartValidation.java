package com.app.doctors_and_patients.validation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultipartValidation implements ConstraintValidator<MultipartValidator, MultipartFile> {

   private int maxSize;
   private String extension;

   // pozwala przechwycic wartosci atrybutow z adnotacji
   public void initialize(MultipartValidator constraint) {
      maxSize = constraint.maxSize();
      extension = constraint.extension();
   }

   public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {

      if (file == null) {
         return false;
      }

      if (file.getSize() > maxSize) {
         return false;
      }

      if (!file.getOriginalFilename().split("\\.")[1].equals(extension)) {
         return false;
      }

      return true;

   }
}
