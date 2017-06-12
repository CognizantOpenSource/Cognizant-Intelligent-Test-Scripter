package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{F14FB85C-6419-442F-B1DF-5CC4969695D9}")
public abstract interface IReleaseManagementInfo
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int duration();
  
  @DISPID(2)
  @VTID(8)
  public abstract int daysLeft();
  
  @DISPID(3)
  @VTID(9)
  public abstract int totalTestInstances();
  
  @DISPID(4)
  @VTID(10)
  public abstract int unexecutedTestInstances();
  
  @DISPID(5)
  @VTID(11)
  public abstract boolean started();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReleaseManagementInfo
 * JD-Core Version:    0.7.0.1
 */