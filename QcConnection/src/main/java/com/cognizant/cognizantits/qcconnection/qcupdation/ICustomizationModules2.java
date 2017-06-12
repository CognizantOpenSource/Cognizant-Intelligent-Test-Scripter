package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{3A2F36D9-0CEF-4864-A067-7246D6615D9E}")
public abstract interface ICustomizationModules2
  extends ICustomizationModules
{
  @DISPID(5)
  @VTID(15)
  public abstract boolean isVisibleForGroup(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(5)
  @VTID(16)
  public abstract void isVisibleForGroup(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
  
  @DISPID(6)
  @VTID(17)
  public abstract IList visibleForGroups(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationModules2
 * JD-Core Version:    0.7.0.1
 */