package com.clickup.requests;

import com.clickup.properties.ClickupProperties;
import com.clickup.url.ClickupUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
    private static RequestSpecBuilder requestBuilder;

    public static RequestSpecification requestSpec() {
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri(ClickupUrl.getBaseUrl());
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.addHeader("Authorization", ClickupProperties.getToken());

        return requestBuilder.build();
    }

    public static RequestSpecification requestSpecWithLogs() {
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri(ClickupUrl.getBaseUrl());
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.addHeader("Authorization", ClickupProperties.getToken());
        requestBuilder.addFilter(new RequestLoggingFilter());
        requestBuilder.addFilter(new ResponseLoggingFilter());

        return requestBuilder.build();
    }
}
