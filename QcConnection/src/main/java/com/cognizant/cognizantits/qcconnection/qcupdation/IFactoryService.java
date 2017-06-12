package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{6332415A-E7DB-4287-95E5-5BD206F6AA8A}")
public abstract interface IFactoryService
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject createReqCoverageFactory(int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFactoryService
 * JD-Core Version:    0.7.0.1
 */