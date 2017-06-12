package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.Optional;
import com4j.VTID;

@IID("{615FBF36-3E96-4C0F-9827-12FA20D13C58}")
public abstract interface IExecEventNotifyByMailSettings
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String eMailTo();
  
  @DISPID(1)
  @VTID(8)
  public abstract void eMailTo(String paramString);
  
  @DISPID(2)
  @VTID(9)
  public abstract String userMessage();
  
  @DISPID(2)
  @VTID(10)
  public abstract void userMessage(String paramString);
  
  @DISPID(3)
  @VTID(11)
  public abstract boolean enabled(int paramInt);
  
  @DISPID(3)
  @VTID(12)
  public abstract void enabled(int paramInt, boolean paramBoolean);
  
  @DISPID(4)
  @VTID(13)
  public abstract void save(@Optional @DefaultValue("-1") boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExecEventNotifyByMailSettings
 * JD-Core Version:    0.7.0.1
 */