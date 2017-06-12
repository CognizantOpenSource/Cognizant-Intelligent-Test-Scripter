package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{FD6F1981-CB3C-4109-AB10-D4A23B8F6937}")
public abstract interface ITestSetFolder4
  extends ITestSetFolder3
{
  @DISPID(30)
  @VTID(41)
  public abstract String testSetFilter();
  
  @DISPID(30)
  @VTID(42)
  public abstract void testSetFilter(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestSetFolder4
 * JD-Core Version:    0.7.0.1
 */