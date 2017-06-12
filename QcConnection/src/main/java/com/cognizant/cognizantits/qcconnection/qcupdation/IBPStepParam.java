package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{6BA5E493-366C-4068-B572-93D27D405DFE}")
public abstract interface IBPStepParam
  extends IBaseField
{
  @DISPID(14)
  @VTID(20)
  public abstract String name();
  
  @DISPID(14)
  @VTID(21)
  public abstract void name(String paramString);
  
  @DISPID(15)
  @VTID(22)
  public abstract String value();
  
  @DISPID(15)
  @VTID(23)
  public abstract void value(String paramString);
  
  @DISPID(16)
  @VTID(24)
  public abstract int type();
  
  @DISPID(16)
  @VTID(25)
  public abstract void type(int paramInt);
  
  @DISPID(17)
  @VTID(26)
  public abstract int referencedParamID();
  
  @DISPID(17)
  @VTID(27)
  public abstract void referencedParamID(int paramInt);
  
  @DISPID(18)
  @VTID(28)
  public abstract int stepID();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBPStepParam
 * JD-Core Version:    0.7.0.1
 */