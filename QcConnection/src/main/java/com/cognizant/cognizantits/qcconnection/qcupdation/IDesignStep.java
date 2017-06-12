package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E04B8E16-1118-4D05-90CE-3DCC39633158}")
public abstract interface IDesignStep
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract String stepName();
  
  @DISPID(14)
  @VTID(24)
  public abstract void stepName(String paramString);
  
  @DISPID(15)
  @VTID(25)
  public abstract String stepDescription();
  
  @DISPID(15)
  @VTID(26)
  public abstract void stepDescription(String paramString);
  
  @DISPID(16)
  @VTID(27)
  public abstract String stepExpectedResult();
  
  @DISPID(16)
  @VTID(28)
  public abstract void stepExpectedResult(String paramString);
  
  @DISPID(17)
  @VTID(29)
  public abstract int order();
  
  @DISPID(17)
  @VTID(30)
  public abstract void order(int paramInt);
  
  @DISPID(18)
  @VTID(31)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object linkTest();
  
  @DISPID(18)
  @VTID(32)
  public abstract void linkTest(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(19)
  @VTID(33)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject linkedParams();
  
  @DISPID(20)
  @VTID(34)
  public abstract int linkTestID();
  
  @DISPID(21)
  @VTID(35)
  public abstract String evaluatedStepDescription();
  
  @DISPID(22)
  @VTID(36)
  public abstract String evaluatedStepExpectedResult();
  
  @DISPID(23)
  @VTID(37)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject parentTest();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IDesignStep
 * JD-Core Version:    0.7.0.1
 */