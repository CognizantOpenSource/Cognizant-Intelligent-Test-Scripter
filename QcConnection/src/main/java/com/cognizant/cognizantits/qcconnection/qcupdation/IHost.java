package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{F90E8FE5-EC4E-4EBA-8A81-32BCCEE3AB94}")
public abstract interface IHost
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  public abstract String description();
  
  @DISPID(11)
  @VTID(21)
  public abstract void description(String paramString);
  
  @DISPID(12)
  @VTID(22)
  public abstract String rexServer();
  
  @DISPID(13)
  @VTID(23)
  public abstract String name();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IHost
 * JD-Core Version:    0.7.0.1
 */