# Database Testing Actions
------------------------------

## **initDBConnection**

**Description**: This function will initialize the database connection

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Database   |*initDBConnection*     |           |         |  |

**Corresponding Code:**

```java
@Action(object = ObjectType.DATABASE, desc = "Initiate the DB transaction")
    public void initDBConnection() {
        try {
            if (verifyDbConnection()) {
                DatabaseMetaData metaData = dbconnection.getMetaData();
                Report.updateTestLog(Action, " Connected with " + metaData.getDriverName() + "\n"
                        + "Driver version " + metaData.getDriverVersion() + " \n"
                        + "Database product name " + metaData.getDatabaseProductName() + "\n"
                        + "Database product version " + metaData.getDatabaseProductVersion(),
                        Status.PASSNS);
            } else {
                Report.updateTestLog(Action, "Could not able to make DB connection ", Status.FAILNS);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Report.updateTestLog(Action, "Error connecting Database: " + ex.getMessage(),
                    Status.FAILNS);
        }
    }
```

**Internally uses the following** `Java` **logic :**

```java
Class.forName(getDriver());
DriverManager.getConnection(getDataBaseData(DB_CONN_STR), getDataBaseData(DB_USER),getDataBaseData(DB_PWD));
/**OR**/
DriverManager.getConnection(getDataBaseData(DB_CONN_STR));
```
----------------------

## **closeDBConnection**

**Description**: This function will close the database connection

**Usage:**

| ObjectName | Action | Input        | Condition |Reference|  |
|------------|--------|--------------|-----------|---------|--|
| Database   |*closeDBConnection*    |           |         |  |

**Corresponding Code:**

```java
@Action(object = ObjectType.DATABASE, desc = "Close the DB Connection")
    public void closeDBConnection() {
        try {
            if (closeConnection()) {
                Report.updateTestLog(Action, "DB Connection is closed", Status.PASSNS);
            } else {
                Report.updateTestLog(Action, "Error in closing the DB Connection ", Status.FAILNS);
            }
        } catch (SQLException ex) {
            Report.updateTestLog(Action, "Error: " + ex.getMessage(),
                    Status.FAILNS);
        }
    }

```

**Internally uses the following** `Java` **logic :**

```java
dbconnection.close();
statement.close();
result.close();
```
----------------------

## **assertDBResult**

**Description**: This function will assert if the SQL result contains a particular data in a specific column after the execution of a SQL select statement.

**Input Format** : @ExpectedValue

**Condition** : Name of the column in which result is expected

**Usage:**

| ObjectName | Action            | Input        | Condition |Reference|  |
|------------|-------------------|--------------|-----------|---------|--|
| Object     |*assertDBResult*   | @value       | nameOfDBColumn | PageName|<span style="color:Green"><< *Hardcoded Input*</span> 
| Object     |*assertDBResult*   | Sheet:Column | nameOfDBColumn | PageName|<span style="color:Blue"><< *Input from Datasheet*</span>
| Object     |*assertDBResult*   | %dynamicVar% | nameOfDBColumn | PageName|<span style="color:Brown"><<*Input from variable*</span>

**Corresponding Code:**

```java
@Action(object = ObjectType.DATABASE, desc = "Assert the value [<Input>] exist in the column [<Condition>] ", input = InputType.YES, condition = InputType.YES)
    public void assertDBResult() {
        if (assertDB(Condition, Data)) {
            Report.updateTestLog(Action, "Value " + Data + " exist in the Database", Status.PASSNS);
        } else {
            Report.updateTestLog(Action, "Value " + Data + " doesn't exist in the Database", Status.FAILNS);
        }
    }

public boolean assertDB(String columnName, String condition) {
        boolean isExist = false;
        try {
            result.beforeFirst();
            if (getColumnIndex(columnName) != -1) {
                while (result.next()) {
                    if (Objects.equal(result.getString(columnName), condition)) {
                        isExist = true;
                        break;
                    }
                }
            } else {
                Report.updateTestLog(Action, "Column " + columnName + " doesn't exist", Status.FAIL);
            }
        } catch (SQLException ex) {
            Report.updateTestLog(Action, "Error asserting the value in DB " + ex.getMessage(), Status.FAIL);
            return false;
        }
        return isExist;
    }

```

## **executeSelectQuery**

**Description**: This function will execute the given select query on the database

**Input Format** : @`SQL Query`

**Example:**

| ObjectName | Action | Input                            | Condition |
|------------|--------|-----------|-------|
| Database   | *executeSelectQuery* | @select * from tableName       |           |

**Corresponding Code:**

```java
@Action(object = ObjectType.DATABASE, desc = "Execute the Query in [<Input>]", input = InputType.YES)
    public void executeSelectQuery() {
        try {
            executeSelect();
            Report.updateTestLog(Action, "Executed Select Query", Status.DONE);
        } catch (SQLException ex) {
            Report.updateTestLog(Action, "Error executing the SQL Query: " + ex.getMessage(),
                    Status.FAILNS);
        }
    }

public void executeSelect() throws SQLException {
        initialize();
        result = statement.executeQuery(Data);
        resultData = result.getMetaData();
        populateColumnNames();
    }    

```

## **executeDMLQuery**

**Description**:  This query will execute an SQL DML statement on the database and will commit the results back to the database

**Input Format** : @`SQL Query`

**Example:**

| ObjectName | Action | Input                                                     | Condition    |
|------------|-----------------------------------------------------------|--------------|---|
| Database   | *executeDMLQuery* |@UPDATE public."Employee" SET "Age"=27 WHERE id = 123456; |              |
| Database	 | *executeDMLQuery* |Sheet:Column                                              |          	|  
| Database   | *executeDMLQuery* |%dynamicVar%                                              |              |

**Corresponding Code:**

```java
@Action(object = ObjectType.DATABASE, desc = "Execute the Query in [<Input>]", input = InputType.YES)
    public void executeDMLQuery() {
        try {
            if (executeDML()) {
                Report.updateTestLog(Action, " Table updated by using " + Data, Status.PASSNS);
            } else {
                Report.updateTestLog(Action, " Table not updated by using " + Data, Status.FAILNS);
            }
        } catch (SQLException ex) {
            Report.updateTestLog(Action, "Error executing the SQL Query: " + ex.getMessage(),
                    Status.FAILNS);
        }
    }   

```

## **storeDBValueinDataSheet**

**Description**: This action will store the value of a specific cell(from specific row and column) from the result of an SQL select statement in the data sheet

**Input Format** : @SheetName:ColumnName , Condition : DatabaseColumnName, ResultSetRowNumber

**Example:**

| ObjectName | Action | Input          | Condition        |
|------------|----------------|------------------|---|
| Database   | *storeDBValueinDataSheet* | Sheet:Column  | productName, 1   |

**Corresponding Code:**

```java
@Action(object = ObjectType.DATABASE, desc = "Save DB value in Test Data Sheet", input = InputType.YES, condition = InputType.YES)
    public void storeDBValueinDataSheet() {
        try {
            if (Condition != null && Input != null) {
                int rowIndex = 1;
                result.first();
                String[] sheetDetail = Input.split(":");
                String sheetName = sheetDetail[0];
                String columnName = sheetDetail[1];
                String value;
                String[] split = Condition.split(",");
                if (split.length > 1) {
                    rowIndex = Integer.parseInt(split[1]);
                }
                if (!result.absolute(rowIndex)) {
                    Report.updateTestLog(Action, "Row : " + rowIndex + " doesn't exist ", Status.FAILNS);
                } else if (getColumnIndex(split[0]) != -1) {
                    value = result.getString(split[0]);
                    userData.putData(sheetName, columnName, value);
                    Report.updateTestLog(Action, "Value from DB " + value + "  stored into " + "the data sheet", Status.DONE);
                } else {
                    Report.updateTestLog(Action, "Column : " + split[0] + " doesn't exist", Status.FAILNS);
                }
            } else {
                Report.updateTestLog(Action, "Incorrect Input or Condition format", Status.FAILNS);
            }
        } catch (SQLException ex) {
            Report.updateTestLog(Action, "Error: " + ex.getMessage(), Status.FAILNS);
            System.out.println("Invalid Data " + Condition);
        }
    }

```

## **storeValueInVariable**

**Description**: This action will store the value of a specific cell(from specific row and column) from the result of an SQL select statement in a user defined variable

**Input Format** : %variableName% , Condition : DatabaseColumnName,
ResultSetRowNumber

**Example:**

| ObjectName | Action |Input        | Condition          |
|------------|--------------|--------------------|---|
| Database   | *storeValueInVariable* | %var%        | productName, 1     |

**Corresponding Code:**

```java

@Action(object = ObjectType.DATABASE, desc = "Store it in the variable from the DB column [<Condition>] ", input = InputType.YES, condition = InputType.YES)
    public void storeValueInVariable() {
        storeValue(Input, Condition, false);
        if (getVar(Input) != null && !getVar(Input).equals("")) {
            Report.updateTestLog(Action, "Stored in the variable", Status.PASSNS);
        } else {
            Report.updateTestLog(Action, "Value doesn't stored in Global variable", Status.FAILNS);
        }
    }

```

## **storeValueInGlobalVariable**

**Description**: This action will store the value of a specific cell(from specific row and column) from the result of an SQL select statement in global variable

**Input Format** : %variableName% , Condition : DatabaseColumnName,
ResultSetRowNumber

**Example:**

| ObjectName | Action | Input        | Condition       |
|------------|--------------|-----------------|----|
| Database   | *storeValueInGlobalVariable* | %var%        | productName, 1  |

**Corresponding Code:**

```java

@Action(object = ObjectType.DATABASE, desc = "Store it in Global variable from the DB column [<Condition>] ", input = InputType.YES, condition = InputType.YES)
    public void storeValueInGlobalVariable() {
        storeValue(Input, Condition, true);
        if (getVar(Input) != null && !getVar(Input).equals("")) {
            Report.updateTestLog(Action, "Stored in Global variable", Status.PASSNS);
        } else {
            Report.updateTestLog(Action, "Value doesn't stored in Global variable", Status.FAILNS);
        }
    }

```

## **storeResultInDataSheet**

**Description**:  This action will store the result of an SQL select statement in the test data sheet

**Input Format** : @`SQL Query` , Condition : DatasheetName

**Example:**

| ObjectName | Action | Input                            | Condition |
|------------|----------------------------------|-----------|----|
| Database   | *storeResultInDataSheet* | select * from public."Employee"  | Sheet:Column |

**Corresponding Code:**

```java
@Action(object = ObjectType.DATABASE, desc = "Query and save the result in Datasheet ", input = InputType.YES, condition = InputType.YES)
    public void storeResultInDataSheet() {
        try {
            executeSelect();
            result.last();
            int totalRows = result.getRow();
            result.beforeFirst();
            int totalCols = resultData.getColumnCount();
            for (int colIndex = 0; colIndex < totalCols; colIndex++) {
                result.beforeFirst();
                for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
                    if (result.absolute(rowIndex)) {
                        userData.putData(Condition, colNames.get(colIndex), result.getString(colIndex + 1), userData.getIteration(), Integer.toString(rowIndex));
                    } else {
                        Report.updateTestLog(Action, "Row " + rowIndex + " doesn't exist",
                                Status.FAILNS);
                        return;
                    }
                }
            }
            Report.updateTestLog(Action, " SQL Query Result has been saved in DataSheet: ",
                    Status.PASSNS);
        } catch (SQLException ex) {
            Report.updateTestLog(Action, "Error executing the SQL Query: " + ex.getMessage(),
                    Status.FAILNS);
        }
    }

```

## **storeResultInVariable**

**Description**: This action will store the result of an SQL select statement in a user defined variable. The select query in this case should return a single column, the query may return multiple rows. In case the query returns a single value, the value will be stored in the variable name given (for eg:- var), In case if the select query returns multiple rows, multiple variables will be created by adding indexes to the variable name given and the value will be stored in these variables(for eg:- var1, var2, var3.....)

**Input Format** : @`SQL Query` , Condition : %VariableName% 

**Example:**

| ObjectName | Action | Input                             | Condition |
|------------|-----------------------------------|-----------|----|
| Database   | *storeResultInVariable* | select * from public."Employee"   | %var%     |

**Corresponding Code:**

```java
@Action(object = ObjectType.DATABASE, desc = "Query and save the result in variable(s) ", input = InputType.YES, condition = InputType.YES)
    public void storeResultInVariable() {
        String variableName = Condition;
        try {
            executeSelect();
            result.last();
            int totalRows = result.getRow();
            result.beforeFirst();
            for (int index = 1; index <= totalRows; index++) {
                if (result.absolute(index)) {
                    if (index == 1) {
                        addVar(variableName, result.getString(1));
                    } else {
                        String temp = variableName.replaceAll("[%]$", index + "%");
                        addVar(temp, result.getString(1));
                    }
                } else {
                    Report.updateTestLog(Action, "Row " + index + " doesn't exist",
                            Status.FAILNS);
                    return;
                }
            }
            Report.updateTestLog(Action, " SQL Query Result has been saved in the run time variable(s) ",
                    Status.PASSNS);
        } catch (SQLException ex) {
            Report.updateTestLog(Action, "Error executing the SQL Query: " + ex.getMessage(),
                    Status.FAILNS);
        }
    }
```
## **verifyWithDataSheet**

**Description**: Verify Table values with the Test Data sheet

**Input Format** : 

**Example:**

| ObjectName | Action | Input                             | Condition |
|------------|-----------------------------------|-----------|----|
| Database   | *verifyWithDataSheet* | select * from public."Employee"   | %var%     |

**Corresponding Code:**

```java
@Action(object = ObjectType.DATABASE, desc = "Verify Table values with the Test Data sheet ", input = InputType.YES)
    public void verifyWithDataSheet() {
        String sheetName = Data;
        TestDataView dataView;
        if (!sheetName.isEmpty() && (dataView = userData.getTestData(sheetName)) != null) {
            List<String> columns = dataView.columns();
            boolean isFailed = false;
            StringBuilder desc = new StringBuilder();
            for (String column : columns.subList(4, columns.size())) {
                if (assertDB(column, dataView.getField(column))) {
                    desc.append("Value ").append(userData.getData(sheetName, column)).append(" exist in the Database").append("\n");
                } else {
                    isFailed = true;
                    desc.append("Value ").append(userData.getData(sheetName, column)).append(" doesn't exist in the Database").append("\n");
                }
            }
            Report.updateTestLog(Action, desc.toString(), isFailed ? Status.FAILNS : Status.PASSNS);
        } else {
            Report.updateTestLog(Action, "Incorrect Sheet Name", Status.FAILNS);
        }
    }
```
