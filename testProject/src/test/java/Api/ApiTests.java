package Api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class ApiTests {

    public String url = "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000";

    @Test()
    public void makeAGetUsersCall(){

        given().log().uri().
                when().
                get(url + "/users").then().log().body().statusCode(200).
                assertThat().body("name", hasItem("Leanne Graham"));

    }

    @Test()
    public void makeAPostCall() {
        HashMap<String, String> input = new HashMap();
        input.put("userId", "123456789");
        input.put("id", "99996");
        input.put("title", "adding a title");
        input.put("body", "adding a body?");

        Response response =

                given().log().uri().
                        contentType(ContentType.JSON).
                        body(input).
                        when().
                        post(url + "/posts");
        response.then().log().body().assertThat().statusCode(Integer.parseInt("201"));
        String responseBody = response.getBody().asString();
    }

    @Test()
    public void makeAComment(){
        HashMap<String, String> comment = new HashMap();
        comment.put("postId", "123");
        comment.put("id", "9999");
        comment.put("email", "wer@mail.com");
        comment.put("body", "comments in the body");

        Response response =

                given().log().uri().
                        contentType(ContentType.JSON).
                        body(comment).
                        when().
                        post(url + "/comments");
        response.then().log().body().assertThat().statusCode(Integer.parseInt("201"));
        String responseBody = response.getBody().asString();

    }
}
