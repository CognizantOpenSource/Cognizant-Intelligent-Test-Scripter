package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{6687454E-8D1A-462E-BFDE-E342BFF132D3}")
public abstract interface IComponentStep
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  public abstract String stepDescription();
  
  @DISPID(11)
  @VTID(21)
  public abstract void stepDescription(String paramString);
  
  @DISPID(12)
  @VTID(22)
  public abstract int order();
  
  @DISPID(12)
  @VTID(23)
  public abstract void order(int paramInt);
  
  @DISPID(13)
  @VTID(24)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject parent();
  
  @DISPID(14)
  @VTID(25)
  public abstract String stepName();
  
  @DISPID(14)
  @VTID(26)
  public abstract void stepName(String paramString);
  
  @DISPID(15)
  @VTID(27)
  public abstract String stepExpectedResult();
  
  @DISPID(15)
  @VTID(28)
  public abstract void stepExpectedResult(String paramString);
  
  @DISPID(16)
  @VTID(29)
  public abstract void validate();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComponentStep
 * JD-Core Version:    0.7.0.1
 */