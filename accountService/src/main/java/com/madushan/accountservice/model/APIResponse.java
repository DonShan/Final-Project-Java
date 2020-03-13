package com.madushan.accountservice.model;

public class APIResponse {

  private int status;
  private String message;
  private AccessToken accessTokens;

  public APIResponse() {
  }

  public APIResponse(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public APIResponse(int status, String message, AccessToken accessTokens) {
    this.status = status;
    this.message = message;
    this.accessTokens = accessTokens;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public AccessToken getAccessTokens() {
    return accessTokens;
  }

  public void setAccessTokens(AccessToken accessTokens) {
    this.accessTokens = accessTokens;
  }
}
