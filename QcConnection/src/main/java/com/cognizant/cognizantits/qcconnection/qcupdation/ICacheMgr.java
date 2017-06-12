package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{30300941-F52E-4FFD-8314-3EA232206EB0}")
public abstract interface ICacheMgr
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void run();
  
  @DISPID(2)
  @VTID(8)
  public abstract int isRunning();
  
  @DISPID(3)
  @VTID(9)
  public abstract void setFileTime(String paramString);
  
  @DISPID(4)
  @VTID(10)
  public abstract void setUpdateRegistry(int paramInt);
  
  @DISPID(5)
  @VTID(11)
  public abstract void setCurrentTest(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICacheMgr
 * JD-Core Version:    0.7.0.1
 */