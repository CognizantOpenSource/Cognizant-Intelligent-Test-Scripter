package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{38D402FA-9823-4D25-979E-62C377AC2E77}")
public abstract interface IVersionItem
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String comments();
  
  @DISPID(2)
  @VTID(8)
  public abstract String version();
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean isLocked();
  
  @DISPID(4)
  @VTID(10)
  public abstract String date();
  
  @DISPID(5)
  @VTID(11)
  public abstract String user();
  
  @DISPID(6)
  @VTID(12)
  public abstract String time();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IVersionItem
 * JD-Core Version:    0.7.0.1
 */