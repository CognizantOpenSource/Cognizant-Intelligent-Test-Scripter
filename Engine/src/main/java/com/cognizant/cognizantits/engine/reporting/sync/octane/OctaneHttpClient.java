/*
 * Copyright 2014 - 2019 Cognizant Technology Solutions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognizant.cognizantits.engine.reporting.sync.octane;

import com.cognizant.cognizantits.engine.reporting.sync.BasicHttpClient;
import com.cognizant.cognizantits.engine.support.DLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class OctaneHttpClient extends BasicHttpClient {

	final String encodedToken;

	public OctaneHttpClient(URL url, String userName, String password, Map config) {
		super(url, userName, password, config);
		System.out.println("initialised");
		encodedToken = java.util.Base64.getEncoder().encodeToString((userName + ":" + password).getBytes());
	}

	@Override
	public void setHeader(HttpGet httpget) {
		httpget.addHeader("Authorization", "Basic " + encodedToken);
		httpget.addHeader("Content-Type", "application/json");

	}

	@Override
	public void setHeader(HttpPut HttpPut) {
		HttpPut.addHeader("Authorization", "Basic " + encodedToken);
		HttpPut.addHeader("Content-Type", "application/json");

	}

	@Override
	public void setHeader(HttpPost HttpPost) {
		HttpPost.addHeader("Authorization", "Basic " + encodedToken);

	}

	public void setAuthHeader(String authHeader) {

	}

	@Override
	public JSONObject Get(URL targetUrl) throws Exception {
		HttpGet httpGet = new HttpGet(targetUrl.toURI());
		setHeader(httpGet);

		return parseoctaneResponse(doGet(httpGet));

	}

	@Override
	public JSONObject put(URL targetUrl, String putentity) throws Exception {
		HttpPut httpPut = new HttpPut(targetUrl.toURI());

		setHeader(httpPut);
		setPutEntity(putentity, httpPut);

		return parseoctaneResponse(doPut(httpPut));

	}

	@Override
	public JSONObject post(URL targetUrl, String postentity) throws Exception {
		HttpPost httpPost = new HttpPost(targetUrl.toURI());

		setHeader(httpPost);

		setPostEntity(postentity, httpPost);

		return parseoctaneResponse(execute(httpPost));

	}

	public JSONObject post(URL targetUrl, String data, File toUplod) throws Exception {
		HttpPost httppost = new HttpPost(targetUrl.toURI());
		setHeader(httppost);
		setPostEntity(data, toUplod, httppost);
		return parseResponse(execute(httppost));
	}

	public void setPostEntity(String data, File file, HttpPost httppost) {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();

		builder.addTextBody("entity", data, ContentType.APPLICATION_JSON);

		String filename = file.getName();

		try {
			builder.addBinaryBody("content", new FileInputStream(file), ContentType.create("text/html"), filename);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		HttpEntity multipart = builder.build();
		httppost.setEntity(multipart);
	}

	public JSONObject parseoctaneResponse(HttpResponse response) throws Exception {
		HttpEntity entity = response.getEntity();
		//StringBuffer resp = new StringBuffer();
                String resp = "";
		//String line = "";

		try {

			if (entity != null) {
				//BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

				//while ((line = rd.readLine()) != null) {
				//	resp.append(line);
				//}
				// System.out.println("response " + resp);
                                resp = EntityUtils.toString(entity);
				JSONParser parser = new JSONParser();
				Object data = parser.parse(resp.toString());
				JSONObject jobj;
				if (data instanceof JSONObject) {
					jobj = (JSONObject) data;
				} else {
					jobj = new JSONObject();
					jobj.put("array", (JSONArray) data);
				}
				EntityUtils.consume(entity);
				return jobj;
			} else {
				return null;
			}
		} catch (Exception ex) {
			DLogger.Log("Unknown Response : ", resp);

			return null;
		}

	}
}
