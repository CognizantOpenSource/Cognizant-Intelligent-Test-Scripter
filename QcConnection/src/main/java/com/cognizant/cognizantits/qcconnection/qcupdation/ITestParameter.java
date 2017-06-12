package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{242048FE-29EA-4D57-A878-15614CFE355C}")
public abstract interface ITestParameter
  extends IBaseField
{
  @DISPID(15)
  @VTID(20)
  public abstract String name();
  
  @DISPID(15)
  @VTID(21)
  public abstract void name(String paramString);
  
  @DISPID(16)
  @VTID(22)
  public abstract String description();
  
  @DISPID(16)
  @VTID(23)
  public abstract void description(String paramString);
  
  @DISPID(17)
  @VTID(24)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject ownerTest();
  
  @DISPID(18)
  @VTID(25)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object defaultValue();
  
  @DISPID(18)
  @VTID(26)
  public abstract void defaultValue(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(19)
  @VTID(27)
  public abstract boolean isUsed();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITestParameter
 * JD-Core Version:    0.7.0.1
 */