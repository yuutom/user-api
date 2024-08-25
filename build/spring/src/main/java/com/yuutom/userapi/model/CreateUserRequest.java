package com.yuutom.userapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateUserRequest
 */

@JsonTypeName("createUser_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-25T15:51:00.332554+09:00[Asia/Tokyo]", comments = "Generator version: 7.7.0")
public class CreateUserRequest {

  private String userId;

  private String password;

  public CreateUserRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateUserRequest(String userId, String password) {
    this.userId = userId;
    this.password = password;
  }

  public CreateUserRequest userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * 6文字以上20文字以内の半角英数字
   * @return userId
   */
  @NotNull @Size(min = 6, max = 20) 
  @Schema(name = "user_id", description = "6文字以上20文字以内の半角英数字", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("user_id")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public CreateUserRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * 8文字以上20文字以内の半角英数字記号（空白と制御コードを除く）
   * @return password
   */
  @NotNull @Size(min = 8, max = 20) 
  @Schema(name = "password", description = "8文字以上20文字以内の半角英数字記号（空白と制御コードを除く）", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUserRequest createUserRequest = (CreateUserRequest) o;
    return Objects.equals(this.userId, createUserRequest.userId) &&
        Objects.equals(this.password, createUserRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

