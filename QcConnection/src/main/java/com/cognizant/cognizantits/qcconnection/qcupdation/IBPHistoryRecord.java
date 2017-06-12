package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{E1582AF7-780E-4D93-9771-E196205F96C7}")
public abstract interface IBPHistoryRecord
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String description();
  
  @DISPID(2)
  @VTID(8)
  public abstract String time();
  
  @DISPID(3)
  @VTID(9)
  public abstract String changer();
  
  @DISPID(4)
  @VTID(10)
  public abstract String toXmlString();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBPHistoryRecord
 * JD-Core Version:    0.7.0.1
 */