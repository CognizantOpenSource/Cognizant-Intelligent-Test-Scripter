package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{509C8491-47BF-454B-B899-852A55A17F46}")
public abstract interface ICustomizationMailCondition
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String name();
  
  @DISPID(2)
  @VTID(8)
  public abstract String conditionText();
  
  @DISPID(2)
  @VTID(9)
  public abstract void conditionText(String paramString);
  
  @DISPID(3)
  @VTID(10)
  public abstract boolean updated();
  
  @DISPID(3)
  @VTID(11)
  public abstract void updated(boolean paramBoolean);
  
  @DISPID(4)
  @VTID(12)
  public abstract boolean deleted();
  
  @DISPID(4)
  @VTID(13)
  public abstract void deleted(boolean paramBoolean);
  
  @DISPID(5)
  @VTID(14)
  public abstract int conditionType();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationMailCondition
 * JD-Core Version:    0.7.0.1
 */