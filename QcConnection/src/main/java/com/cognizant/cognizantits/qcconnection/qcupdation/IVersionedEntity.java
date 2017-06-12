package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{5F63414F-E5F4-44D6-A0D0-42D704BC6E92}")
public abstract interface IVersionedEntity
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int versionNumber();
  
  @DISPID(2)
  @VTID(8)
  public abstract boolean isViewOnly();
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject vc();
  
  @DISPID(4)
  @VTID(10)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject versionData();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IVersionedEntity
 * JD-Core Version:    0.7.0.1
 */