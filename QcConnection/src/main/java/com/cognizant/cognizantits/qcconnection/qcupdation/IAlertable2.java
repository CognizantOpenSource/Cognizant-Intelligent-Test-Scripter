package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{B19C1039-D667-48D1-81B0-C864E9CC3109}")
public abstract interface IAlertable2
  extends IAlertable
{
  @DISPID(1610743808)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addAlert(String paramString1, int paramInt, String paramString2, String paramString3);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAlertable2
 * JD-Core Version:    0.7.0.1
 */