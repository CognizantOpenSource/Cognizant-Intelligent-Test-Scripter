package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E2F29752-72F0-42DB-995C-3DB385F4CCE5}")
public abstract interface IBaseField
  extends IObjectLockingSupport
{
  @DISPID(0)
  @VTID(10)
  @DefaultMethod
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object field(String paramString);
  
  @DISPID(0)
  @VTID(11)
  @DefaultMethod
  public abstract void field(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(4)
  @VTID(12)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object id();
  
  @DISPID(5)
  @VTID(13)
  public abstract boolean autoPost();
  
  @DISPID(5)
  @VTID(14)
  public abstract void autoPost(boolean paramBoolean);
  
  @DISPID(6)
  @VTID(15)
  public abstract void post();
  
  @DISPID(7)
  @VTID(16)
  public abstract void refresh();
  
  @DISPID(8)
  @VTID(17)
  public abstract void undo();
  
  @DISPID(9)
  @VTID(18)
  public abstract boolean modified();
  
  @DISPID(10)
  @VTID(19)
  public abstract boolean virtual();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseField
 * JD-Core Version:    0.7.0.1
 */