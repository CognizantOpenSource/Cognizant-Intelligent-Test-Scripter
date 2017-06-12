package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{56799AB1-FA33-4ED4-BD4F-3CAB0E207EEB}")
public abstract interface IModule
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int id();
  
  @DISPID(2)
  @VTID(8)
  public abstract String name();
  
  @DISPID(2)
  @VTID(9)
  public abstract void name(String paramString);
  
  @DISPID(3)
  @VTID(10)
  public abstract String description();
  
  @DISPID(3)
  @VTID(11)
  public abstract void description(String paramString);
  
  @DISPID(4)
  @VTID(12)
  public abstract String guid();
  
  @DISPID(4)
  @VTID(13)
  public abstract void guid(String paramString);
  
  @DISPID(5)
  @VTID(14)
  public abstract String visible();
  
  @DISPID(5)
  @VTID(15)
  public abstract void visible(String paramString);
  
  @DISPID(7)
  @VTID(16)
  public abstract boolean updated();
  
  @DISPID(7)
  @VTID(17)
  public abstract void updated(boolean paramBoolean);
  
  @DISPID(8)
  @VTID(18)
  public abstract void visibleForGroup(int paramInt, boolean paramBoolean);
  
  @DISPID(9)
  @VTID(19)
  public abstract void numericVisible(int paramInt);
  
  @DISPID(10)
  @VTID(20)
  public abstract int order();
  
  @DISPID(10)
  @VTID(21)
  public abstract void order(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IModule
 * JD-Core Version:    0.7.0.1
 */