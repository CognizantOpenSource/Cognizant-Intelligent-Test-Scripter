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
package com.cognizant.cognizantits.engine.reporting.performance;

/**
 *
 * 
 */
public class PerformanceTimings {

    public long connectEnd,
            connectStart,
            domComplete,
            domContentLoadedEventEnd,
            domContentLoadedEventStart,
            domInteractive,
            domLoading,
            domainLookupEnd,
            domainLookupStart,
            fetchStart,
            loadEventEnd,
            loadEventStart,
            navigationStart,
            redirectEnd,
            redirectStart,
            requestStart,
            responseEnd,
            responseStart,
            secureConnectionStart,
            unloadEventEnd,
            unloadEventStart;
    public String url, title;

    /**
     * convert page timings data to a resource data page request as a resource
     * entry
     *
     * @return ResourceTimings
     */
    public ResourceTimings toResourceTimings() {
        ResourceTimings rt = new ResourceTimings();
        rt.name = url;
        rt.initiatorType = "text/html";
        rt.entryType = "Page";
        rt.startTime = 0d;

        long start = this.navigationStart;
        rt.responseEnd = new Double(this.responseEnd - start);
        rt.responseStart = new Double(this.responseStart - start);
        rt.requestStart = new Double(this.requestStart - start);
        rt.connectEnd = new Double(this.connectEnd - start);
        rt.connectStart = new Double(this.connectStart - start);
        rt.secureConnectionStart = new Double(
                (this.secureConnectionStart == 0 ? 0 : this.secureConnectionStart - start));
        rt.domainLookupEnd = new Double(this.domainLookupEnd - start);
        rt.domainLookupStart = new Double(this.domainLookupStart - start);

        rt.redirectStart = new Double(
                (this.redirectStart == 0 ? 0 : this.redirectStart - start));
        rt.redirectEnd = new Double(
                (this.redirectEnd == 0 ? 0 : this.redirectEnd - start));

        rt.fetchStart = new Double(this.fetchStart - start);

        rt.duration = rt.responseEnd;

        return rt;
    }

    /**
     * java script to extract timings data.
     *
     * @return
     */
    public static String script() {
        return "  var pt=performance.timing;"
                + "var t={};"
                + "t.title=document.title;"
                + "t.url=window.location.href;"
                + "for(var k in pt){t[k]=pt[k];}"
                + "t.toJSON=undefined;"
                + "return JSON.stringify(t);";
    }
}
