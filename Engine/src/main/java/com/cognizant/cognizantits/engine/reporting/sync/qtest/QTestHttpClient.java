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
package com.cognizant.cognizantits.engine.reporting.sync.qtest;

import com.cognizant.cognizantits.engine.reporting.sync.BasicHttpClient;
import java.net.URL;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;

class QTestHttpClient extends BasicHttpClient {

	private final String site;

	private String authHeader;

	public QTestHttpClient(URL url, String userName, String password, String site) {
		super(url, userName, password);
		this.site = site;
		setAuthHeader("Basic " + java.util.Base64.getEncoder().encodeToString((this.site + ":").getBytes()));
	}

	@Override
	public void auth(HttpRequest req) throws AuthenticationException {
		req.addHeader("Authorization", authHeader);
	}

	public void setAuthHeader(String authHeader) {
		this.authHeader = authHeader;
	}

	public String getAuthHeader() {
		return this.authHeader;
	}
}
