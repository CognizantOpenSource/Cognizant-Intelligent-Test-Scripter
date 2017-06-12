package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{34AC6EC7-3E2D-4A15-90A0-DF789E91A966}")
public abstract interface IExtensionManager
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String loadedExtensions();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExtensionManager
 * JD-Core Version:    0.7.0.1
 */