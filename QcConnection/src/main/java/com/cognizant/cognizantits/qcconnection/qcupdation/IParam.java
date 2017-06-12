package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{AE1410CC-D940-4356-A926-6DF6C1F45AED}")
public abstract interface IParam
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int count();
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object paramValue(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(9)
  public abstract void paramValue(@MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2);
  
  @DISPID(3)
  @VTID(10)
  public abstract String paramName(int paramInt);
  
  @DISPID(4)
  @VTID(11)
  public abstract int paramIndex(String paramString);
  
  @DISPID(5)
  @VTID(12)
  public abstract void addParam(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(6)
  @VTID(13)
  public abstract void deleteParam(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(7)
  @VTID(14)
  public abstract void deleteParams();
  
  @DISPID(8)
  @VTID(15)
  public abstract int paramType(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IParam
 * JD-Core Version:    0.7.0.1
 */