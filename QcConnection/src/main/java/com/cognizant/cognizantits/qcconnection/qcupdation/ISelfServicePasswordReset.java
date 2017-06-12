package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.VTID;

@IID("{EF6A4FF8-CA39-4537-8127-08DD1E0DF8F5}")
public abstract interface ISelfServicePasswordReset
  extends Com4jObject
{
  @VTID(3)
  public abstract void ssprSendMail(String paramString);
  
  @VTID(4)
  public abstract void ssprChangePassword(String paramString1, String paramString2, String paramString3);
  
  @VTID(5)
  public abstract boolean isSSPREnabled();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISelfServicePasswordReset
 * JD-Core Version:    0.7.0.1
 */