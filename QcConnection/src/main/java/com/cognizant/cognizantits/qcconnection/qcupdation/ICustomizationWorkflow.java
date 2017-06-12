package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{29FB4DA4-BD3B-47C3-AD0D-09EC7DF0D278}")
public abstract interface ICustomizationWorkflow
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract boolean projectScriptsUpdated();
  
  @DISPID(1)
  @VTID(8)
  public abstract void projectScriptsUpdated(boolean paramBoolean);
  
  @DISPID(2)
  @VTID(9)
  public abstract boolean templateScriptsUpdated();
  
  @DISPID(2)
  @VTID(10)
  public abstract void templateScriptsUpdated(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationWorkflow
 * JD-Core Version:    0.7.0.1
 */