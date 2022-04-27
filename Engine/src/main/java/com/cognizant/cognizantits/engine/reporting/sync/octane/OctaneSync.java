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

import com.cognizant.cognizantits.engine.reporting.sync.Sync;
import com.cognizant.cognizantits.engine.reporting.util.TestInfo;
import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class OctaneSync implements Sync {

	private static final Logger LOG = Logger.getLogger(OctaneSync.class.getName());
	private OctaneClient client;
	private String project;

	public OctaneSync(Properties options) {
		client = new OctaneClient(options.getProperty("octaneURL"), options.getProperty("Username"),
				options.getProperty("Password"), options.getProperty("WorkSpaceName"),
				options.getProperty("SharedSpaceID"), options);
		this.project = options.getProperty("WorkSpaceName");

	}

	@Override
	public boolean isConnected() {
		try {

			return client.isConnected() && client.containsProject(project);
		} catch (Exception ex) {
			LOG.log(Level.SEVERE, ex.getMessage(), ex);
			return false;
		}
	}

	@Override
	public String createIssue(JSONObject issue, List<File> attach) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void disConnect() {

	}

	@Override
	public boolean updateResults(TestInfo TestCase, String status, List<File> attach) {
		// TODO Auto-generated method stub

		try {

			return client.updateResult(TestCase, status, attach);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public String getModule() {
		// TODO Auto-generated method stub
		return "Octane";
	}
}
