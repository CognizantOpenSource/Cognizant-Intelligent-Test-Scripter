package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{2EEC167C-FBBF-4A2F-8DE6-DE8A05EDDB50}")
public abstract interface ICustomizationModules
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String name(int paramInt);
  
  @DISPID(1)
  @VTID(8)
  public abstract void name(int paramInt, String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract String guid(int paramInt);
  
  @DISPID(2)
  @VTID(10)
  public abstract void guid(int paramInt, String paramString);
  
  @DISPID(3)
  @VTID(11)
  public abstract String description(int paramInt);
  
  @DISPID(3)
  @VTID(12)
  public abstract void description(int paramInt, String paramString);
  
  @DISPID(4)
  @VTID(13)
  public abstract int visible(int paramInt);
  
  @DISPID(4)
  @VTID(14)
  public abstract void visible(int paramInt1, int paramInt2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationModules
 * JD-Core Version:    0.7.0.1
 */