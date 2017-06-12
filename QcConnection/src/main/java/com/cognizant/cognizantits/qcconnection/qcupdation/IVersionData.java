package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{AC9FDB6A-A502-4A08-8976-7D90AEC9668B}")
public abstract interface IVersionData
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int versionNumber();
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object checkInDate();
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object checkOutDate();
  
  @DISPID(4)
  @VTID(10)
  public abstract String checkInComment();
  
  @DISPID(5)
  @VTID(11)
  public abstract String checkOutComment();
  
  @DISPID(6)
  @VTID(12)
  public abstract String checkedInBy();
  
  @DISPID(7)
  @VTID(13)
  public abstract String checkedOutBy();
  
  @DISPID(8)
  @VTID(14)
  public abstract boolean isCheckedOut();
  
  @DISPID(9)
  @VTID(15)
  public abstract boolean isCurrent();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IVersionData
 * JD-Core Version:    0.7.0.1
 */