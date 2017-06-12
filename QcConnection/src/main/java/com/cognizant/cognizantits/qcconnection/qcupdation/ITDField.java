package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{3D416474-2373-446E-9090-DBC083B6C382}")
public abstract interface ITDField
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  public abstract String name();
  
  @DISPID(1)
  @VTID(8)
  public abstract int type();
  
  @DISPID(2)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject property();
  
  @DISPID(3)
  @VTID(10)
  public abstract void isValidValue(@MarshalAs(NativeType.VARIANT) Object paramObject, @MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDField
 * JD-Core Version:    0.7.0.1
 */