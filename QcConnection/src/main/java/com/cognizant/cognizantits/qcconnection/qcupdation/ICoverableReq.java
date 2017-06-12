package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{F061ABB7-A65F-4146-8621-5A8B04C87B8D}")
public abstract interface ICoverableReq
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject requirementCoverageFactory();
  
  @DISPID(2)
  @VTID(8)
  public abstract void addTestInstanceToCoverage(int paramInt);
  
  @DISPID(3)
  @VTID(9)
  public abstract void addTestToCoverage(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  public abstract void addTestsFromTestSetToCoverage(int paramInt, String paramString);
  
  @DISPID(5)
  @VTID(11)
  public abstract void addSubjectToCoverage(int paramInt, String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICoverableReq
 * JD-Core Version:    0.7.0.1
 */