package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{F23D00D8-67CA-4B0E-B555-53CD2F226227}")
public abstract interface IAlertable2Dispatch
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void deleteAlert(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(8)
  public abstract void cleanAllAlerts();
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getAlert(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  public abstract IList getAlertList(@Optional @DefaultValue("0") boolean paramBoolean);
  
  @DISPID(5)
  @VTID(11)
  public abstract boolean hasAlerts();
  
  @DISPID(6)
  @VTID(12)
  public abstract boolean hasNewAlerts();
  
  @DISPID(7)
  @VTID(13)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addAlert(String paramString1, int paramInt, String paramString2, String paramString3);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAlertable2Dispatch
 * JD-Core Version:    0.7.0.1
 */