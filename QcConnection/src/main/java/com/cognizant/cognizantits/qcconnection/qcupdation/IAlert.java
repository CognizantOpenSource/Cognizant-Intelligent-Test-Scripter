package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;
import java.util.Date;

@IID("{A1314B45-32F6-4841-9EB6-922EC4A76CB2}")
public abstract interface IAlert
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String description();
  
  @DISPID(2)
  @VTID(8)
  public abstract Date alertDate();
  
  @DISPID(3)
  @VTID(9)
  public abstract int id();
  
  @DISPID(4)
  @VTID(10)
  public abstract int alertType();
  
  @DISPID(5)
  @VTID(11)
  public abstract boolean unread();
  
  @DISPID(5)
  @VTID(12)
  public abstract void unread(boolean paramBoolean);
  
  @DISPID(6)
  @VTID(13)
  public abstract String subject();
  
  @DISPID(7)
  @VTID(14)
  public abstract String parentEntityURL();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAlert
 * JD-Core Version:    0.7.0.1
 */