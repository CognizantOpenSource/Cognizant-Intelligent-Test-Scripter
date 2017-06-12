package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{70DF698A-FD62-4F14-AE2B-6A1206902B24}")
public abstract interface IExtensionData1
  extends IExtensionData
{
  @DISPID(8)
  @VTID(14)
  public abstract String otaNetDataProviderName();
  
  @DISPID(9)
  @VTID(15)
  public abstract String uiNetDataProviderName();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExtensionData1
 * JD-Core Version:    0.7.0.1
 */