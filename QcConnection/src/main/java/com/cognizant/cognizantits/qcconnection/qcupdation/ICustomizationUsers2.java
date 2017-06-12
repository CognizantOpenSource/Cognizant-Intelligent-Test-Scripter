package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{A23C23B0-5705-409C-8FC3-842D5CFFBF5E}")
public abstract interface ICustomizationUsers2
  extends ICustomizationUsers
{
  @DISPID(11)
  @VTID(15)
  public abstract boolean userExistsInSite(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationUsers2
 * JD-Core Version:    0.7.0.1
 */