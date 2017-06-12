package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{F488163A-8369-4879-8F57-FB3C534D56C8}")
public abstract interface IBaselineRoot
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
  public abstract String entityType();
  
  @DISPID(15)
  @VTID(23)
  public abstract void entityType(String paramString);
  
  @DISPID(16)
  @VTID(24)
  public abstract String entityKey();
  
  @DISPID(16)
  @VTID(25)
  public abstract void entityKey(String paramString);
  
  @DISPID(17)
  @VTID(26)
  public abstract String entityExpFilter();
  
  @DISPID(17)
  @VTID(27)
  public abstract void entityExpFilter(String paramString);
  
  @DISPID(18)
  @VTID(28)
  public abstract boolean isObsolete();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaselineRoot
 * JD-Core Version:    0.7.0.1
 */