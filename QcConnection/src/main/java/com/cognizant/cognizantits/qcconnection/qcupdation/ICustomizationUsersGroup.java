package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{7E12617E-3B01-42BD-A16F-13118038D0B7}")
public abstract interface ICustomizationUsersGroup
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int id();
  
  @DISPID(2)
  @VTID(8)
  public abstract String name();
  
  @DISPID(2)
  @VTID(9)
  public abstract void name(String paramString);
  
  @DISPID(3)
  @VTID(10)
  public abstract boolean is_System();
  
  @DISPID(4)
  @VTID(11)
  public abstract void addUser(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(5)
  @VTID(12)
  public abstract void removeUser(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(6)
  @VTID(13)
  public abstract IList usersList();
  
  @VTID(13)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object usersList(int paramInt);
  
  @DISPID(7)
  @VTID(14)
  public abstract boolean updated();
  
  @DISPID(7)
  @VTID(15)
  public abstract void updated(boolean paramBoolean);
  
  @DISPID(8)
  @VTID(16)
  public abstract boolean deleted();
  
  @DISPID(8)
  @VTID(17)
  public abstract void deleted(boolean paramBoolean);
  
  @DISPID(9)
  @VTID(18)
  public abstract boolean isSystem();
  
  @DISPID(10)
  @VTID(19)
  public abstract String hideFilter(String paramString);
  
  @DISPID(10)
  @VTID(20)
  public abstract void hideFilter(String paramString1, String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationUsersGroup
 * JD-Core Version:    0.7.0.1
 */