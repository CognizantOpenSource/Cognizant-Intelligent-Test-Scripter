package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{3E46BE58-4943-48AA-BA08-38EEBA837A04}")
public abstract interface IBaseFactory2
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject groupingManager();
  
  @DISPID(2)
  @VTID(8)
  public abstract boolean groupingSupported();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseFactory2
 * JD-Core Version:    0.7.0.1
 */