package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.VTID;

@IID("{1EE78B77-A68F-49D8-9707-9A7C8CEA10D2}")
public abstract interface IActionPermission
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract boolean actionEnabled(@MarshalAs(NativeType.VARIANT) Object paramObject1, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IActionPermission
 * JD-Core Version:    0.7.0.1
 */