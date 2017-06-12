package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{C10389DD-70AC-48F5-BCF0-9A1CBA5FCAD9}")
public abstract interface ICustomizationUser
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String address();
  
  @DISPID(1)
  @VTID(8)
  public abstract void address(String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract String email();
  
  @DISPID(2)
  @VTID(10)
  public abstract void email(String paramString);
  
  @DISPID(3)
  @VTID(11)
  public abstract String fullName();
  
  @DISPID(3)
  @VTID(12)
  public abstract void fullName(String paramString);
  
  @DISPID(4)
  @VTID(13)
  public abstract String phone();
  
  @DISPID(4)
  @VTID(14)
  public abstract void phone(String paramString);
  
  @DISPID(5)
  @VTID(15)
  public abstract String name();
  
  @DISPID(6)
  @VTID(16)
  public abstract boolean updated();
  
  @DISPID(6)
  @VTID(17)
  public abstract void updated(boolean paramBoolean);
  
  @DISPID(7)
  @VTID(18)
  public abstract void removeFromGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(8)
  @VTID(19)
  public abstract void addToGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(9)
  @VTID(20)
  public abstract boolean in_Group(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(9)
  @VTID(21)
  public abstract void in_Group(@MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(10)
  @VTID(22)
  public abstract boolean deleted();
  
  @DISPID(10)
  @VTID(23)
  public abstract void deleted(boolean paramBoolean);
  
  @DISPID(11)
  @VTID(24)
  public abstract IList groupsList();
  
  @VTID(24)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object groupsList(int paramInt);
  
  @DISPID(12)
  @VTID(25)
  public abstract void password(String paramString);
  
  @DISPID(13)
  @VTID(26)
  public abstract boolean inGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(13)
  @VTID(27)
  public abstract void inGroup(@MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(14)
  @VTID(28)
  public abstract String domainAuthentication();
  
  @DISPID(14)
  @VTID(29)
  public abstract void domainAuthentication(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationUser
 * JD-Core Version:    0.7.0.1
 */