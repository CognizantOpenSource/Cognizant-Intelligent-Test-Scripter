package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.Optional;
import com4j.VTID;

@IID("{18B58E14-B956-40A3-A37F-B8EF1136F238}")
public abstract interface ITestSetFolder2
  extends ITestSetFolder
{
  @DISPID(27)
  @VTID(37)
  public abstract IList findTestInstances(String paramString1, @Optional @DefaultValue("0") boolean paramBoolean, @Optional @DefaultValue("") String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestSetFolder2
 * JD-Core Version:    0.7.0.1
 */