package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{437A2A3C-00EB-4B53-89C8-BBC5DED2D52C}")
public abstract interface IDBManager
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void createDatabase(int paramInt, String paramString1, String paramString2);
  
  @DISPID(2)
  @VTID(8)
  public abstract void removeDatabase(String paramString);
  
  @DISPID(3)
  @VTID(9)
  public abstract String adminUserName();
  
  @DISPID(3)
  @VTID(10)
  public abstract void adminUserName(String paramString);
  
  @DISPID(4)
  @VTID(11)
  public abstract String domain();
  
  @DISPID(4)
  @VTID(12)
  public abstract void domain(String paramString);
  
  @DISPID(5)
  @VTID(13)
  public abstract String adminUserPassword();
  
  @DISPID(5)
  @VTID(14)
  public abstract void adminUserPassword(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IDBManager
 * JD-Core Version:    0.7.0.1
 */