var DATA={"axeReport":false,"releaseName":null,"noTests":1,"perfReport":false,"EXECUTIONS":[{"noTests":6,"iterationType":"Single","description":"Test Run","platform":"WIN10","exeTime":"00:00:00","iterations":1,"testcaseName":"POST","browser":"No Browser","nopassTests":"5","startTime":"07-Apr-2023 16:53:56.056","endTime":"07-Apr-2023 16:53:56.056","scenarioName":"Rest","bversion":"default","nofailTests":"0","STEPS":[{"data":[{"data":{"stepno":1,"stepName":"setEndPoint","tStamp":"07-Apr-2023 16:53:56.056","action":"setEndPoint","description":"End point set : https:\/\/json-server.azurewebsites.net\/users\/","status":"DONE"},"name":"Set End Point ","type":"step"},{"data":{"stepno":2,"stepName":"postRestRequest","tStamp":"07-Apr-2023 16:53:56.056","link":"\\webservice","action":"postRestRequest","description":"Response received in : [345ms] with Status code  : 201","status":"COMPLETE"},"name":"POST Rest Request ","type":"step"},{"data":{"stepno":3,"stepName":"storeResponseBodyInDataSheet","tStamp":"07-Apr-2023 16:53:56.056","action":"storeResponseBodyInDataSheet","description":"Response body is stored in RestData:Response","status":"DONE"},"name":"Store Response Message In DataSheet ","type":"step"},{"data":{"stepno":4,"stepName":"assertResponseCode","tStamp":"07-Apr-2023 16:53:56.056","action":"assertResponseCode","description":"Status code is : 201","status":"PASS"},"name":"Assert Response Code ","type":"step"},{"data":{"stepno":5,"stepName":"storeJSONelementInDataSheet","tStamp":"07-Apr-2023 16:53:56.056","action":"storeJSONelementInDataSheet","description":"Element text [390] is stored in RestData:ID","status":"DONE"},"name":"Store Response Message In DataSheet ","type":"step"},{"data":{"stepno":6,"stepName":"closeConnection","tStamp":"07-Apr-2023 16:53:56.056","action":"closeConnection","description":"Connection is closed","status":"DONE"},"name":"Close the connection ","type":"step"}],"name":"Iteration_1","type":"iteration","status":"PASS"}],"status":"PASS"}],"iterationMode":"ContinueOnError","exeTime":"00:00:00","testRun":true,"runConfiguration":"Local","themes":["Amethyst","Coral","Pearl","Sapphire"],"testsetName":null,"nopassTests":"1","theme":"Sapphire","startTime":"07-Apr-2023 16:53:56.056","endTime":"07-Apr-2023 16:53:57.057","projectName":"WebserviceDemoProject","maxThreads":1,"bddReport":false,"nofailTests":"0"};