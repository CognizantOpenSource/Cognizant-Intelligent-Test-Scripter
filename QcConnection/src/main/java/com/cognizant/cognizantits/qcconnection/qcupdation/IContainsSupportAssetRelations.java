package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{E916A243-2644-4531-AD0F-09E46FE849D9}")
public abstract interface IContainsSupportAssetRelations
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract boolean containsUsedBy(@MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IContainsSupportAssetRelations
 * JD-Core Version:    0.7.0.1
 */