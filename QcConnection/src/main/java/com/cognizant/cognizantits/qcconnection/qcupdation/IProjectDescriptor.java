package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{F75A5EA6-BB0D-419F-9B39-EF024E835AFC}")
public abstract interface IProjectDescriptor
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String uId();
  
  @DISPID(2)
  @VTID(8)
  public abstract String domainName();
  
  @DISPID(3)
  @VTID(9)
  public abstract String name();
  
  @DISPID(4)
  @VTID(10)
  public abstract String type();
  
  @DISPID(5)
  @VTID(11)
  public abstract boolean isTemplate();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IProjectDescriptor
 * JD-Core Version:    0.7.0.1
 */