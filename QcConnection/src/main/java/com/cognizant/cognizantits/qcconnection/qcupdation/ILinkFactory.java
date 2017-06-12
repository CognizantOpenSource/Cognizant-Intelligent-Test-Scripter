package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{49B715FA-458E-46EA-A171-0E0BFB38B3AF}")
public abstract interface ILinkFactory
  extends IBaseFactory
{
  @DISPID(8)
  @VTID(16)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject owner();
  
  @DISPID(9)
  @VTID(17)
  public abstract boolean fullLinkage();
  
  @DISPID(9)
  @VTID(18)
  public abstract void fullLinkage(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILinkFactory
 * JD-Core Version:    0.7.0.1
 */