package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{F13E4E0F-2BF2-41A2-97B1-06AD03204518}")
public abstract interface IBaseFactory
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject item(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(1)
  @VTID(8)
  public abstract IList newList(String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract IList fields();
  
  @VTID(9)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object fields(int paramInt);
  
  @DISPID(3)
  @VTID(10)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addItem(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(11)
  public abstract void removeItem(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(5)
  @VTID(12)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject filter();
  
  @DISPID(6)
  @VTID(13)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject history();
  
  @DISPID(7)
  @VTID(14)
  public abstract short fetchLevel(String paramString);
  
  @DISPID(7)
  @VTID(15)
  public abstract void fetchLevel(String paramString, short paramShort);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseFactory
 * JD-Core Version:    0.7.0.1
 */