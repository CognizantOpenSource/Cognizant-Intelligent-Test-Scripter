package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{C015CC00-5F0F-4DD6-9D8C-733B1412BB1B}")
public abstract interface ITableProperties
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String name();
  
  @DISPID(2)
  @VTID(8)
  public abstract String userLabel();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITableProperties
 * JD-Core Version:    0.7.0.1
 */