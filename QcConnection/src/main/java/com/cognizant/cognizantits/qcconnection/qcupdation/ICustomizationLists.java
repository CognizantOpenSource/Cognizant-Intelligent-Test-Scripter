package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{4EA26B82-65DC-4315-AD7F-D963A1C4EB2F}")
public abstract interface ICustomizationLists
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addList(String paramString);
  
  @DISPID(2)
  @VTID(8)
  public abstract void removeList(String paramString);
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject list(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(10)
  public abstract int count();
  
  @DISPID(5)
  @VTID(11)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject listByCount(int paramInt);
  
  @DISPID(6)
  @VTID(12)
  public abstract boolean isListExist(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationLists
 * JD-Core Version:    0.7.0.1
 */