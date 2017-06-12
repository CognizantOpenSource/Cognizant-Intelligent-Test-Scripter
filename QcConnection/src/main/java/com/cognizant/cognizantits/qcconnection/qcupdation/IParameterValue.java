package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{B8D89E0F-5164-420B-A8A4-9C6D982487BF}")
public abstract interface IParameterValue
  extends IBaseField
{
  @DISPID(15)
  @VTID(20)
  public abstract String name();
  
  @DISPID(16)
  @VTID(21)
  public abstract String description();
  
  @DISPID(17)
  @VTID(22)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject ownerEntity();
  
  @DISPID(18)
  @VTID(23)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object defaultValue();
  
  @DISPID(19)
  @VTID(24)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object actualValue();
  
  @DISPID(19)
  @VTID(25)
  public abstract void actualValue(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(20)
  @VTID(26)
  public abstract boolean isUsed();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IParameterValue
 * JD-Core Version:    0.7.0.1
 */