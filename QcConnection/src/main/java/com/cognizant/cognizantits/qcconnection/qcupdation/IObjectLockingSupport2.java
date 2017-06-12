package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.VTID;

@IID("{C4DFB67A-1AA4-11DD-B154-13D455D89593}")
public abstract interface IObjectLockingSupport2
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void getLockParams(Holder<String> paramHolder1, Holder<String> paramHolder2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IObjectLockingSupport2
 * JD-Core Version:    0.7.0.1
 */