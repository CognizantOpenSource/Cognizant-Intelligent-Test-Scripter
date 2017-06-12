package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.IID;
import com4j.VTID;

@IID("{DC091A33-E1E8-4A17-8C55-529C09B0670B}")
public abstract interface IBaseParam
  extends IBaseField
{
  @VTID(20)
  public abstract String name();
  
  @VTID(21)
  public abstract void name(String paramString);
  
  @VTID(22)
  public abstract String value();
  
  @VTID(23)
  public abstract void value(String paramString);
  
  @VTID(24)
  public abstract String desc();
  
  @VTID(25)
  public abstract void desc(String paramString);
  
  @VTID(26)
  public abstract String valueType();
  
  @VTID(27)
  public abstract void valueType(String paramString);
  
  @VTID(28)
  public abstract int order();
  
  @VTID(29)
  public abstract void order(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseParam
 * JD-Core Version:    0.7.0.1
 */