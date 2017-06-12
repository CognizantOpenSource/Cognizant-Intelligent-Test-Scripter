package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{2444C43F-5371-4B4A-B6B6-34D205644C35}")
public abstract interface ISearchOptions
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object property(int paramInt);
  
  @DISPID(1)
  @VTID(8)
  public abstract void property(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject filter();
  
  @DISPID(2)
  @VTID(10)
  public abstract void filter(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(3)
  @VTID(11)
  public abstract String text();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISearchOptions
 * JD-Core Version:    0.7.0.1
 */