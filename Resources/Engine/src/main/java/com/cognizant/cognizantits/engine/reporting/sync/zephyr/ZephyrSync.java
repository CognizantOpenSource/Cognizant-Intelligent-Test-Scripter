/*
 * Copyright 2014 - 2017 Cognizant Technology Solutions
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
package com.cognizant.cognizantits.engine.reporting.sync.zephyr;

import com.cognizant.cognizantits.engine.core.RunManager;
import com.cognizant.cognizantits.engine.reporting.sync.Sync;
import com.cognizant.cognizantits.engine.reporting.util.TestInfo;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

/**
 *
 * 
 */
public class ZephyrSync implements Sync {

	private ZephyrClient conn;
	private String project = "";
	private String token;

	public ZephyrSync(String url, String username, String password, String project, String phase, Map options) {
		conn = new ZephyrClient(url, username, password, phase, options);
		this.project = project;
	}

	/**
	 * 
	 * @param options
	 */
	public ZephyrSync(Properties options) {
		this(options.getProperty("ZephyrUrl"), options.getProperty("ZephyrUserName"),
				options.getProperty("ZephyrPassword"), options.getProperty("ZephyrProject"),
				options.getProperty("ZephyrTestPhase"), options);
	}

	@Override
	public String getModule() {
		return "Zephyr";
	}

	@Override
	public boolean isConnected() {
		try {
			// token = login();
			ZephyrHttpClient jc = new ZephyrHttpClient(conn.url, conn.userName, conn.password, conn.config);
			return conn.containsProject(project, jc);
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, null, ex);
			return false;
		}
	}

	private static final Logger LOG = Logger.getLogger(ZephyrSync.class.getName());

	@Override
	public boolean updateResults(TestInfo ti, String status, List<File> list) {
		ZephyrHttpClient jc = new ZephyrHttpClient(conn.url, conn.userName, conn.password, conn.config);
		String rls = RunManager.getGlobalSettings().getRelease();
		String tset = RunManager.getGlobalSettings().getTestSet();
		try {
			// Release and testset needs to be passed from Run Manager
			int eid = conn.updateResult(ti.testCase, tset, rls, project, jc, getStatus(status),list);
			return (eid > 0);
		} catch (Exception ex) {
			Logger.getLogger(ZephyrSync.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public String createIssue(JSONObject jsono, List<File> list) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void disConnect() {
		conn = null;
	}

	private int getStatus(String status) {
		switch (status.toUpperCase()) {
		case "PASSED":
			return 1;
		case "FAILED":
			return 2;
		case "WIP":
			return 3;
		default:
			return -1;

		}
	}
}
