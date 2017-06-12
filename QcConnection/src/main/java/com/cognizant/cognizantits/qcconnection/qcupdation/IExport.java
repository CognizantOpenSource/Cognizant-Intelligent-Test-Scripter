package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{08E8895B-686D-4F75-9F16-F9E130D99470}")
public abstract interface IExport
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void exportData(String paramString1, String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExport
 * JD-Core Version:    0.7.0.1
 */