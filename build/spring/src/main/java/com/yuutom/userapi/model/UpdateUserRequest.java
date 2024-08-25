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
 * UpdateUserRequest
 */

@JsonTypeName("updateUser_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-25T13:59:23.896535+09:00[Asia/Tokyo]", comments = "Generator version: 7.7.0")
public class UpdateUserRequest {

  private String nickname;

  private String comment;

  public UpdateUserRequest nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  /**
   * 30文字以内の制御文字以外
   * @return nickname
   */
  @Size(max = 30) 
  @Schema(name = "nickname", description = "30文字以内の制御文字以外", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nickname")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public UpdateUserRequest comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * 100文字以内の制御文字以外
   * @return comment
   */
  @Size(max = 100) 
  @Schema(name = "comment", description = "100文字以内の制御文字以外", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUserRequest updateUserRequest = (UpdateUserRequest) o;
    return Objects.equals(this.nickname, updateUserRequest.nickname) &&
        Objects.equals(this.comment, updateUserRequest.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nickname, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUserRequest {\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
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

