package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{33CCFC63-CE02-47AB-9A11-BB2E0C324723}")
public abstract interface IGroupingManager
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject filter();
  
  @DISPID(1)
  @VTID(8)
  public abstract void filter(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(2)
  @VTID(9)
  public abstract int group(String paramString);
  
  @DISPID(2)
  @VTID(10)
  public abstract void group(String paramString, int paramInt);
  
  @DISPID(3)
  @VTID(11)
  public abstract IList groupList();
  
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object groupList(int paramInt);
  
  @DISPID(4)
  @VTID(12)
  public abstract IList itemList();
  
  @VTID(12)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object itemList(int paramInt);
  
  @DISPID(5)
  @VTID(13)
  public abstract void refresh();
  
  @DISPID(6)
  @VTID(14)
  public abstract void clear();
  
  @DISPID(7)
  @VTID(15)
  public abstract boolean isClear();
  
  @DISPID(8)
  @VTID(16)
  public abstract String text();
  
  @DISPID(8)
  @VTID(17)
  public abstract void text(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IGroupingManager
 * JD-Core Version:    0.7.0.1
 */