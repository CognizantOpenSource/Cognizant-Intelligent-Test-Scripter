package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{93FF8BA2-20E4-40C0-BB37-638B5BFD8DAC}")
public abstract interface ICustomizationTransitionRule
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String sourceValue();
  
  @DISPID(1)
  @VTID(8)
  public abstract void sourceValue(String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract String destinationValue();
  
  @DISPID(2)
  @VTID(10)
  public abstract void destinationValue(String paramString);
  
  @DISPID(3)
  @VTID(11)
  public abstract boolean isAllowed();
  
  @DISPID(3)
  @VTID(12)
  public abstract void isAllowed(boolean paramBoolean);
  
  @DISPID(4)
  @VTID(13)
  public abstract boolean updated();
  
  @DISPID(4)
  @VTID(14)
  public abstract void updated(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationTransitionRule
 * JD-Core Version:    0.7.0.1
 */