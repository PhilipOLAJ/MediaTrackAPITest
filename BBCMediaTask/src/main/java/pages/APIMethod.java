package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIMethod {
    public Response GetMethod(){

        RestAssured.baseURI="https://testapi.io/api/ottplatform/media";
        RequestSpecification request= RestAssured.given();
        return  request.get();


    }
}
