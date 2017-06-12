package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{FD53A549-A095-469F-AD8E-95F9F034D2DF}")
public abstract interface ITestSetTreeManager
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject root();
  
  @DISPID(1)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject nodeByPath(String paramString);
  
  @DISPID(2)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject nodeById(int paramInt);
  
  @DISPID(3)
  @VTID(10)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject unattached();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestSetTreeManager
 * JD-Core Version:    0.7.0.1
 */