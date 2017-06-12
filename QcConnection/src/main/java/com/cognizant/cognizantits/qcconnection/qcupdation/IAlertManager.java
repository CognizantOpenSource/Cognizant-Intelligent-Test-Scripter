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

@IID("{7A0B3B0B-60C4-4B84-8A35-1E9337AD055E}")
public abstract interface IAlertManager
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
  public abstract Com4jObject alert(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  public abstract IList alertList(String paramString, @Optional @DefaultValue("0") boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAlertManager
 * JD-Core Version:    0.7.0.1
 */