package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{47ED7949-FBFC-4C85-9AE0-32A3180D7256}")
public abstract interface ITrace
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject fromReq();
  
  @DISPID(12)
  @VTID(21)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject toReq();
  
  @DISPID(13)
  @VTID(22)
  public abstract void tracedReq(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITrace
 * JD-Core Version:    0.7.0.1
 */