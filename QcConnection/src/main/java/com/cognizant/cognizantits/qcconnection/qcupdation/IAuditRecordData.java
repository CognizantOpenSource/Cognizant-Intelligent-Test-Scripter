package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{F4EC0532-85B6-4F7D-872A-84AB8B2158E6}")
public abstract interface IAuditRecordData
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String action();
  
  @DISPID(1)
  @VTID(8)
  public abstract void action(String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract String entityID();
  
  @DISPID(2)
  @VTID(10)
  public abstract void entityID(String paramString);
  
  @DISPID(3)
  @VTID(11)
  public abstract String entityType();
  
  @DISPID(3)
  @VTID(12)
  public abstract void entityType(String paramString);
  
  @DISPID(4)
  @VTID(13)
  public abstract String description();
  
  @DISPID(4)
  @VTID(14)
  public abstract void description(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAuditRecordData
 * JD-Core Version:    0.7.0.1
 */