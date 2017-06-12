package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{9D4F53EF-41A2-4059-8AB3-13BBCA8333E8}")
public abstract interface ICustomization
  extends IObjectLockingSupport
{
  @DISPID(4)
  @VTID(10)
  public abstract void load();
  
  @DISPID(5)
  @VTID(11)
  public abstract void commit();
  
  @DISPID(6)
  @VTID(12)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject fields();
  
  @DISPID(7)
  @VTID(13)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject lists();
  
  @DISPID(8)
  @VTID(14)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject permissions();
  
  @DISPID(9)
  @VTID(15)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject users();
  
  @DISPID(10)
  @VTID(16)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject usersGroups();
  
  @DISPID(11)
  @VTID(17)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject actions();
  
  @DISPID(12)
  @VTID(18)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject modules();
  
  @DISPID(13)
  @VTID(19)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject mailConditions();
  
  @DISPID(14)
  @VTID(20)
  public abstract int extendedUDFSupport();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomization
 * JD-Core Version:    0.7.0.1
 */