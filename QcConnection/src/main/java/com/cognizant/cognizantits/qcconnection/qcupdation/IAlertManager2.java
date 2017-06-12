package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{AAA7D0A8-433C-4A92-8A8C-E160C743FD68}")
public abstract interface IAlertManager2
  extends IAlertManager
{
  @DISPID(5)
  @VTID(11)
  public abstract String getFilterText();
  
  @DISPID(6)
  @VTID(12)
  public abstract void deleteAlertsByFilter(String paramString1, String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAlertManager2
 * JD-Core Version:    0.7.0.1
 */