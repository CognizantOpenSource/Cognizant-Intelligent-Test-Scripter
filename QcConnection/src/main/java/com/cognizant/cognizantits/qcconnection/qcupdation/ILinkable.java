package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{9B1CCF47-8DC6-4B9D-AC24-35DD3361A175}")
public abstract interface ILinkable
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject bugLinkFactory();
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject linkFactory();
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean hasLinkage();
  
  @DISPID(4)
  @VTID(10)
  public abstract boolean hasOthersLinkage();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILinkable
 * JD-Core Version:    0.7.0.1
 */