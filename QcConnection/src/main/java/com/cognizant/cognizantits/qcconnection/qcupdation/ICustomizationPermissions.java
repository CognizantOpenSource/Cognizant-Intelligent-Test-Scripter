package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{7EE7D348-AED6-4B3C-8FC7-5D9D8EA8E4C9}")
public abstract interface ICustomizationPermissions
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract boolean canAddItem(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(1)
  @VTID(8)
  public abstract void canAddItem(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(2)
  @VTID(9)
  public abstract int canRemoveItem(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(10)
  public abstract void canRemoveItem(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject, int paramInt);
  
  @DISPID(3)
  @VTID(11)
  public abstract int canModifyField(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2);
  
  @DISPID(3)
  @VTID(12)
  public abstract void canModifyField(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2, int paramInt);
  
  @DISPID(4)
  @VTID(13)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject transitionRules(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2);
  
  @DISPID(5)
  @VTID(14)
  public abstract int canAllowAttachment(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(5)
  @VTID(15)
  public abstract void canAllowAttachment(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject, int paramInt);
  
  @DISPID(6)
  @VTID(16)
  public abstract boolean canUseOwnerSensible(String paramString);
  
  @DISPID(7)
  @VTID(17)
  public abstract boolean hasAttachmentField(String paramString);
  
  @DISPID(8)
  @VTID(18)
  public abstract void isVisibleInNewBug(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2, boolean paramBoolean);
  
  @DISPID(8)
  @VTID(19)
  public abstract boolean isVisibleInNewBug(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2);
  
  @DISPID(9)
  @VTID(20)
  public abstract void canModifyItem(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(9)
  @VTID(21)
  public abstract boolean canModifyItem(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(10)
  @VTID(22)
  public abstract boolean auditAddItem(String paramString);
  
  @DISPID(10)
  @VTID(23)
  public abstract void auditAddItem(String paramString, boolean paramBoolean);
  
  @DISPID(11)
  @VTID(24)
  public abstract boolean auditRemoveItem(String paramString);
  
  @DISPID(11)
  @VTID(25)
  public abstract void auditRemoveItem(String paramString, boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationPermissions
 * JD-Core Version:    0.7.0.1
 */