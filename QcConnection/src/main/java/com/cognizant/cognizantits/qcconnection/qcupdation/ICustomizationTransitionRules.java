package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{365FA56C-AE1E-46EB-A776-6EDDB82BF290}")
public abstract interface ICustomizationTransitionRules
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int count();
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject transitionRule(int paramInt);
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addTransitionRule();
  
  @DISPID(4)
  @VTID(10)
  public abstract void removeTransitionRule(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(5)
  @VTID(11)
  public abstract boolean updated();
  
  @DISPID(5)
  @VTID(12)
  public abstract void updated(boolean paramBoolean);
  
  @DISPID(6)
  @VTID(13)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject field();
  
  @DISPID(7)
  @VTID(14)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject group();
  
  @DISPID(8)
  @VTID(15)
  public abstract String entityName();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationTransitionRules
 * JD-Core Version:    0.7.0.1
 */