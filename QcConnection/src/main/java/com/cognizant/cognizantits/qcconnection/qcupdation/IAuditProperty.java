package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{DD1C7F94-5C11-416D-B11D-DA062309D43A}")
public abstract interface IAuditProperty
  extends IBaseField
{
  @DISPID(11)
  @VTID(20)
  public abstract String tableName();
  
  @DISPID(12)
  @VTID(21)
  public abstract String fieldName();
  
  @DISPID(13)
  @VTID(22)
  public abstract String propertyName();
  
  @DISPID(14)
  @VTID(23)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object oldValue();
  
  @DISPID(15)
  @VTID(24)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object newValue();
  
  @DISPID(16)
  @VTID(25)
  public abstract int actionID();
  
  @DISPID(17)
  @VTID(26)
  public abstract String action();
  
  @DISPID(18)
  @VTID(27)
  public abstract String userName();
  
  @DISPID(19)
  @VTID(28)
  public abstract int sessionID();
  
  @DISPID(20)
  @VTID(29)
  public abstract String time();
  
  @DISPID(21)
  @VTID(30)
  public abstract String entityType();
  
  @DISPID(22)
  @VTID(31)
  public abstract String entityID();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAuditProperty
 * JD-Core Version:    0.7.0.1
 */