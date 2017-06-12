package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{5186B0F4-DAC2-4ABD-B248-8ED6E852C40D}")
public abstract interface IRule
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int id();
  
  @DISPID(2)
  @VTID(8)
  public abstract boolean isActive();
  
  @DISPID(2)
  @VTID(9)
  public abstract void isActive(boolean paramBoolean);
  
  @DISPID(3)
  @VTID(10)
  public abstract boolean toMail();
  
  @DISPID(3)
  @VTID(11)
  public abstract void toMail(boolean paramBoolean);
  
  @DISPID(4)
  @VTID(12)
  public abstract String description();
  
  @DISPID(5)
  @VTID(13)
  public abstract void post();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IRule
 * JD-Core Version:    0.7.0.1
 */