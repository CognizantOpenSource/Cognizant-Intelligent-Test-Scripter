package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{87B013CA-DE17-495F-B9D5-D8B7901FCB4D}")
public abstract interface IVersionedEntitiesFactory
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject viewVersion(@MarshalAs(NativeType.VARIANT) Object paramObject, int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract int checkedOutEntitiesCount();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IVersionedEntitiesFactory
 * JD-Core Version:    0.7.0.1
 */