package com.jakartalabsassignment.baseapi;
import com.google.gson.Gson;
import com.jakartalabsassignment.utils.DataUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPITest {

	protected RequestSpecification commonRequestSpec = new RequestSpecBuilder()
			.setBaseUri(DataUtils.getDataFromExcel("Config", "BaseUrlAPI")).setContentType("application/json").build()
			.log().all();

	protected Gson gson = new Gson();

}