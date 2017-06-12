package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{7236494B-BBE3-40D2-8176-E26F65D0F995}")
public abstract interface ICustomizationUsers3
  extends ICustomizationUsers2
{
  @DISPID(12)
  @VTID(16)
  public abstract String getUsersIdsInSite(String paramString, boolean paramBoolean);
  
  @DISPID(13)
  @VTID(17)
  public abstract String getUsersPropertiesInSite(@MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationUsers3
 * JD-Core Version:    0.7.0.1
 */