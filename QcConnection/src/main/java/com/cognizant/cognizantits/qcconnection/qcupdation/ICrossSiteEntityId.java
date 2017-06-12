package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{DCCDAFCD-99C0-45E1-BBCB-B83B724901C9}")
public abstract interface ICrossSiteEntityId
  extends Com4jObject
{
  @DISPID(16)
  @VTID(7)
  public abstract int domainId();
  
  @DISPID(17)
  @VTID(8)
  public abstract int projectId();
  
  @DISPID(18)
  @VTID(9)
  public abstract int entityID();
  
  @DISPID(19)
  @VTID(10)
  public abstract String entityType();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICrossSiteEntityId
 * JD-Core Version:    0.7.0.1
 */