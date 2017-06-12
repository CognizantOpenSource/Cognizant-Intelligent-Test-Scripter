package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{780EDB90-97D3-4146-AD5F-F2F313EDF29E}")
public abstract interface ICustomizationTypedField
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject field();
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject type();
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean isRequired();
  
  @DISPID(3)
  @VTID(10)
  public abstract void isRequired(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationTypedField
 * JD-Core Version:    0.7.0.1
 */