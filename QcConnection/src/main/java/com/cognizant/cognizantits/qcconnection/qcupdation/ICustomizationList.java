package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{1E1C07CA-7339-4741-A41D-DEC5A065B1F1}")
public abstract interface ICustomizationList
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject rootNode();
  
  @DISPID(2)
  @VTID(8)
  public abstract String name();
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject find(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(10)
  public abstract boolean deleted();
  
  @DISPID(4)
  @VTID(11)
  public abstract void deleted(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationList
 * JD-Core Version:    0.7.0.1
 */