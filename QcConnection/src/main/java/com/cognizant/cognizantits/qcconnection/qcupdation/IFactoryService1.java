package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.GUID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{9A5EE173-31D4-4C90-9900-D671FF960BF3}")
public abstract interface IFactoryService1
  extends IFactoryService
{
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject createGenericFactory(GUID paramGUID, int paramInt, @MarshalAs(NativeType.VARIANT) Object paramObject, boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFactoryService1
 * JD-Core Version:    0.7.0.1
 */