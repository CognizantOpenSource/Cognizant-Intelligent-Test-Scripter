package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{E489B9B0-FBC5-42D6-9042-EAE139E2A093}")
public abstract interface ITaskLog
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  public abstract String taskLogType();
  
  @DISPID(11)
  @VTID(21)
  public abstract void taskLogType(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITaskLog
 * JD-Core Version:    0.7.0.1
 */