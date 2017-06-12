package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{260EDCFF-BF72-4146-BC41-5B2280652ED0}")
public abstract interface IObjectLockingSupport
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract boolean isLocked();
  
  @DISPID(2)
  @VTID(8)
  public abstract boolean lockObject();
  
  @DISPID(3)
  @VTID(9)
  public abstract void unLockObject();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IObjectLockingSupport
 * JD-Core Version:    0.7.0.1
 */