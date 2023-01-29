package com.msoft.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ManhKM on 1/12/2023
 * @project cicd-tutorial
 */
@Getter
@AllArgsConstructor
public class AppException extends RuntimeException{

  private int code;
  private String message;
}
