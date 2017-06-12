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

@IID("{101CD251-91FB-4FB0-A440-DE755D905584}")
public abstract interface IAlertable
  extends Com4jObject
{
  @DISPID(1610678272)
  @VTID(3)
  public abstract void deleteAlert(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(1610678273)
  @VTID(4)
  public abstract void cleanAllAlerts();
  
  @DISPID(1610678274)
  @VTID(5)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getAlert(int paramInt);
  
  @DISPID(1610678275)
  @VTID(6)
  public abstract IList getAlertList(@Optional @DefaultValue("0") boolean paramBoolean);
  
  @DISPID(1610678276)
  @VTID(7)
  public abstract boolean hasAlerts();
  
  @DISPID(1610678277)
  @VTID(8)
  public abstract boolean hasNewAlerts();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAlertable
 * JD-Core Version:    0.7.0.1
 */