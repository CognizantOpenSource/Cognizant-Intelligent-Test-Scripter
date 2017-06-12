package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{84F1A917-9318-46B2-8C36-00C184EE00C2}")
public abstract interface IHistory2
  extends IHistory
{
  @DISPID(4)
  @VTID(10)
  public abstract IList newListEx(String paramString1, String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IHistory2
 * JD-Core Version:    0.7.0.1
 */