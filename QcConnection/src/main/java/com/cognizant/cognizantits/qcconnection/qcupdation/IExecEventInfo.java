package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{5377347E-3F8D-4B54-B962-18527B652EDD}")
public abstract interface IExecEventInfo
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int eventType();
  
  @DISPID(2)
  @VTID(8)
  public abstract String eventTime();
  
  @DISPID(3)
  @VTID(9)
  public abstract String eventDate();
  
  @DISPID(4)
  @VTID(10)
  public abstract String eventParam(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExecEventInfo
 * JD-Core Version:    0.7.0.1
 */