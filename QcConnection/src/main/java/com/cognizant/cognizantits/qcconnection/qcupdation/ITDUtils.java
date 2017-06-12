package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{BB603787-CBD0-48CD-AA8A-B4532DC714D1}")
public abstract interface ITDUtils
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String encrypt(String paramString);
  
  @DISPID(3)
  @VTID(8)
  public abstract String currentTimeStamp();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDUtils
 * JD-Core Version:    0.7.0.1
 */