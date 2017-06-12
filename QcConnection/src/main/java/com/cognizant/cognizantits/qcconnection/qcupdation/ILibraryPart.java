package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{E746272C-4CB9-4691-AF22-F857580DAA44}")
public abstract interface ILibraryPart
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
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILibraryPart
 * JD-Core Version:    0.7.0.1
 */