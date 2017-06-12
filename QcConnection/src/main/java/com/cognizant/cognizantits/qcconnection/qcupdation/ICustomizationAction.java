package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{217D92D5-CD8A-4ADA-8ECC-9D13C224DCA8}")
public abstract interface ICustomizationAction
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String name();
  
  @DISPID(2)
  @VTID(8)
  public abstract IList groups();
  
  @VTID(8)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object groups(int paramInt);
  
  @DISPID(3)
  @VTID(9)
  public abstract void addGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(10)
  public abstract void removeGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(5)
  @VTID(11)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject ownerGroup();
  
  @DISPID(5)
  @VTID(12)
  public abstract void ownerGroup(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(6)
  @VTID(13)
  public abstract boolean updated();
  
  @DISPID(6)
  @VTID(14)
  public abstract void updated(boolean paramBoolean);
  
  @DISPID(7)
  @VTID(15)
  public abstract boolean isGroupPermited(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(8)
  @VTID(16)
  public abstract boolean isOwnerGroup(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(9)
  @VTID(17)
  public abstract boolean isUserPermited(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(10)
  @VTID(18)
  public abstract boolean auditAction();
  
  @DISPID(10)
  @VTID(19)
  public abstract void auditAction(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationAction
 * JD-Core Version:    0.7.0.1
 */