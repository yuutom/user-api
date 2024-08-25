package com.yuutom.userapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.yuutom.userapi.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UsersUserIdPatch200Response
 */

@JsonTypeName("_users__user_id__patch_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-25T13:39:45.616279+09:00[Asia/Tokyo]", comments = "Generator version: 7.7.0")
public class UsersUserIdPatch200Response {

  private String message;

  @Valid
  private List<@Valid User> recipe = new ArrayList<>();

  public UsersUserIdPatch200Response message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  
  @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public UsersUserIdPatch200Response recipe(List<@Valid User> recipe) {
    this.recipe = recipe;
    return this;
  }

  public UsersUserIdPatch200Response addRecipeItem(User recipeItem) {
    if (this.recipe == null) {
      this.recipe = new ArrayList<>();
    }
    this.recipe.add(recipeItem);
    return this;
  }

  /**
   * Get recipe
   * @return recipe
   */
  @Valid 
  @Schema(name = "recipe", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recipe")
  public List<@Valid User> getRecipe() {
    return recipe;
  }

  public void setRecipe(List<@Valid User> recipe) {
    this.recipe = recipe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersUserIdPatch200Response usersUserIdPatch200Response = (UsersUserIdPatch200Response) o;
    return Objects.equals(this.message, usersUserIdPatch200Response.message) &&
        Objects.equals(this.recipe, usersUserIdPatch200Response.recipe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, recipe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsersUserIdPatch200Response {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    recipe: ").append(toIndentedString(recipe)).append("\n");
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

