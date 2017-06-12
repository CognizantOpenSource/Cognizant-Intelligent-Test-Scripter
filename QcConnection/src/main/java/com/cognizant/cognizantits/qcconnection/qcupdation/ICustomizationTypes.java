package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{30873CCD-888B-4383-AECD-6C4D9EFF553F}")
public abstract interface ICustomizationTypes
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addCustomizationType(int paramInt1, String paramString, int paramInt2);
  
  @DISPID(2)
  @VTID(8)
  public abstract void removeCustomizationType(int paramInt1, int paramInt2);
  
  @DISPID(3)
  @VTID(9)
  public abstract IList getEntityCustomizationTypes(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getEntityCustomizationType(int paramInt1, int paramInt2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationTypes
 * JD-Core Version:    0.7.0.1
 */