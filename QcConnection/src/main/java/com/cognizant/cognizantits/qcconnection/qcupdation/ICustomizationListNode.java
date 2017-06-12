package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{18C04A97-2141-4852-8E02-0E79D3CAEAD3}")
public abstract interface ICustomizationListNode
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addChild(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(8)
  public abstract void removeChild(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject child(String paramString);
  
  @DISPID(4)
  @VTID(10)
  public abstract IList children();
  
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object children(int paramInt);
  
  @DISPID(5)
  @VTID(11)
  public abstract String name();
  
  @DISPID(5)
  @VTID(12)
  public abstract void name(String paramString);
  
  @DISPID(6)
  @VTID(13)
  public abstract int id();
  
  @DISPID(6)
  @VTID(14)
  public abstract void id(int paramInt);
  
  @DISPID(7)
  @VTID(15)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject father();
  
  @DISPID(7)
  @VTID(16)
  public abstract void father(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(8)
  @VTID(17)
  public abstract boolean canAddChild();
  
  @DISPID(9)
  @VTID(18)
  public abstract boolean readOnly();
  
  @DISPID(10)
  @VTID(19)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject list();
  
  @DISPID(11)
  @VTID(20)
  public abstract int childrenCount();
  
  @DISPID(12)
  @VTID(21)
  public abstract boolean updated();
  
  @DISPID(12)
  @VTID(22)
  public abstract void updated(boolean paramBoolean);
  
  @DISPID(13)
  @VTID(23)
  public abstract boolean deleted();
  
  @DISPID(13)
  @VTID(24)
  public abstract void deleted(boolean paramBoolean);
  
  @DISPID(14)
  @VTID(25)
  public abstract int order();
  
  @DISPID(14)
  @VTID(26)
  public abstract void order(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationListNode
 * JD-Core Version:    0.7.0.1
 */