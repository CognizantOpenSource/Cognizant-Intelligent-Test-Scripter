package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{C5F2DD90-484A-48B3-874F-9BFF5C14AC67}")
public abstract interface ICustomizationPermissionService
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void verifyAddItem(String paramString);
  
  @DISPID(2)
  @VTID(8)
  public abstract void verifyRemoveItem(IBaseField paramIBaseField, String paramString);
  
  @DISPID(3)
  @VTID(9)
  public abstract String fieldOwner(IBaseField paramIBaseField);
  
  @DISPID(4)
  @VTID(10)
  public abstract int canModifyField(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2, boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationPermissionService
 * JD-Core Version:    0.7.0.1
 */