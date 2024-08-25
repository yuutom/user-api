package com.yuutom.userapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Error Response
 */

@Schema(name = "ErrorResponse", description = "Error Response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-25T15:51:00.332554+09:00[Asia/Tokyo]", comments = "Generator version: 7.7.0")
public class ErrorResponse {

  private String message;

  private String cause;

  public ErrorResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorResponse(String message, String cause) {
    this.message = message;
    this.cause = cause;
  }

  public ErrorResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * error title
   * @return message
   */
  @NotNull 
  @Schema(name = "message", description = "error title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorResponse cause(String cause) {
    this.cause = cause;
    return this;
  }

  /**
   * error detail
   * @return cause
   */
  @NotNull 
  @Schema(name = "cause", description = "error detail", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cause")
  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.message, errorResponse.message) &&
        Objects.equals(this.cause, errorResponse.cause);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, cause);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
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

