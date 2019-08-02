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

import com.cognizant.cognizantits.engine.core.RunManager;
import com.cognizant.cognizantits.engine.reporting.sync.Sync;
import com.cognizant.cognizantits.engine.reporting.util.TestInfo;
import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class QTestSync implements Sync {

	private static final Logger LOG = Logger.getLogger(QTestSync.class.getName());
	private QTestClient conn;

	public QTestSync(String hostURL, String username, String password, String site, String cycle) {
		conn = new QTestClient(hostURL, username, password, site, cycle);
	}

	public QTestSync(Properties options) {
		this(options.getProperty("qTestUrl"), options.getProperty("qTestUserName"),
				options.getProperty("qTestPassword"), options.getProperty("qTestSiteName"),
				options.getProperty("qTestCycleName"));
	}

	@Override
	public String getModule() {
		return "qTestManager";
	}

	@Override
	public boolean isConnected() {
		if (conn.getHTTPClient().getAuthHeader().contains("bearer")) {
			return true;
		}
		return conn.isLoggedIn();
	}

	@Override
	public boolean updateResults(TestInfo TestCase, String status, List<File> attach) {
		if (!conn.getHTTPClient().getAuthHeader().contains("bearer")) {
			return false;
		}
		String project = RunManager.getGlobalSettings().getProjectName();
		String release = RunManager.getGlobalSettings().getRelease();
		int projectID = conn.getProjectID(project);
		if (projectID != -1) {
			int releaseID = conn.getReleaseID(projectID, release);
			if (releaseID != -1) {
				int cycleID = conn.getCycleID(projectID, releaseID);
				if (cycleID != -1) {
					String testSet = RunManager.getGlobalSettings().getTestSet();
					int suiteID = conn.getSuiteID(projectID, cycleID, testSet);
					if (suiteID != -1) {
						List<Integer> ids = conn.getTestRunID(projectID, suiteID, TestCase.testCase);
						if (ids.size() > 1) {
							return conn.uploadfile(projectID, ids, TestCase, status, attach);
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public String createIssue(JSONObject issue, List<File> attach) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void disConnect() {
	}
}
