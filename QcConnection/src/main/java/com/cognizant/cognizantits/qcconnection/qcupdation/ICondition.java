package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{8A01DC68-2D34-4CB2-81D7-968F37C50715}")
public abstract interface ICondition
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object value();
  
  @DISPID(0)
  @VTID(8)
  @DefaultMethod
  public abstract void value(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(1)
  @VTID(9)
  public abstract short type();
  
  @DISPID(2)
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object source();
  
  @DISPID(3)
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object target();
  
  @DISPID(4)
  @VTID(12)
  public abstract String description();
  
  @DISPID(4)
  @VTID(13)
  public abstract void description(String paramString);
  
  @DISPID(5)
  @VTID(14)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object id();
  
  @DISPID(6)
  @VTID(15)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object sourceInstance();
  
  @DISPID(7)
  @VTID(16)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object targetInstance();
  
  @DISPID(8)
  @VTID(17)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object sourceTestId();
  
  @DISPID(9)
  @VTID(18)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object targetTestId();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICondition
 * JD-Core Version:    0.7.0.1
 */