package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.GUID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{200779C9-C694-4097-9286-FF7F3734E0A3}")
public abstract interface IFactoryProvider
  extends Com4jObject
{
  @DISPID(24)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getFactory(GUID paramGUID);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFactoryProvider
 * JD-Core Version:    0.7.0.1
 */