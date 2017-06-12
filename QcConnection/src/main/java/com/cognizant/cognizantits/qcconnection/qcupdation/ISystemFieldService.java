package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{B721DBBD-D7C2-4765-A4B9-164AD6604BD3}")
public abstract interface ISystemFieldService
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String fieldProperty(String paramString1, String paramString2);
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject fieldRoot(String paramString);
  
  @DISPID(3)
  @VTID(9)
  public abstract String fieldList(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISystemFieldService
 * JD-Core Version:    0.7.0.1
 */