package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{B4776982-5666-4075-99A3-0574EDA12EF2}")
public abstract interface IStepParams
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int count();
  
  @DISPID(2)
  @VTID(8)
  public abstract String paramValue(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(9)
  public abstract void paramValue(@MarshalAs(NativeType.VARIANT) Object paramObject, String paramString);
  
  @DISPID(3)
  @VTID(10)
  public abstract void clearParam(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(11)
  public abstract String paramType(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(12)
  public abstract void paramType(@MarshalAs(NativeType.VARIANT) Object paramObject, String paramString);
  
  @DISPID(5)
  @VTID(13)
  public abstract boolean paramExist(String paramString);
  
  @DISPID(6)
  @VTID(14)
  public abstract String baseValue(@MarshalAs(NativeType.VARIANT) Object paramObject, Holder<Boolean> paramHolder);
  
  @DISPID(7)
  @VTID(15)
  public abstract String paramName(int paramInt);
  
  @DISPID(8)
  @VTID(16)
  public abstract int type(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(9)
  @VTID(17)
  public abstract void save();
  
  @DISPID(10)
  @VTID(18)
  public abstract void refresh();
  
  @DISPID(11)
  @VTID(19)
  public abstract void addParam(String paramString1, String paramString2);
  
  @DISPID(12)
  @VTID(20)
  public abstract void deleteParam(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IStepParams
 * JD-Core Version:    0.7.0.1
 */