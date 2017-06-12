package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{1754ECE8-1386-456C-AA7C-AD448412EDA3}")
public abstract interface IAuditRecord
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject auditPropertyFactory();
  
  @DISPID(12)
  @VTID(21)
  public abstract String action();
  
  @DISPID(13)
  @VTID(22)
  public abstract String entityType();
  
  @DISPID(14)
  @VTID(23)
  public abstract String entityID();
  
  @DISPID(15)
  @VTID(24)
  public abstract String userName();
  
  @DISPID(16)
  @VTID(25)
  public abstract int sessionID();
  
  @DISPID(17)
  @VTID(26)
  public abstract String time();
  
  @DISPID(18)
  @VTID(27)
  public abstract int contextID();
  
  @DISPID(19)
  @VTID(28)
  public abstract String description();
  
  @DISPID(20)
  @VTID(29)
  public abstract int actionID();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAuditRecord
 * JD-Core Version:    0.7.0.1
 */