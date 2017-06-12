package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E99AC0C8-46AB-42C3-9CB2-9C9AEC35A861}")
public abstract interface ITSScheduler
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void run(@Optional @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(2)
  @VTID(8)
  public abstract void stop(@Optional @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean logEnabled();
  
  @DISPID(3)
  @VTID(10)
  public abstract void logEnabled(boolean paramBoolean);
  
  @DISPID(4)
  @VTID(11)
  public abstract String tdHostName();
  
  @DISPID(4)
  @VTID(12)
  public abstract void tdHostName(String paramString);
  
  @DISPID(5)
  @VTID(13)
  public abstract int hostTimeOut();
  
  @DISPID(5)
  @VTID(14)
  public abstract void hostTimeOut(int paramInt);
  
  @DISPID(6)
  @VTID(15)
  public abstract boolean runAllLocally();
  
  @DISPID(6)
  @VTID(16)
  public abstract void runAllLocally(boolean paramBoolean);
  
  @DISPID(7)
  @VTID(17)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject executionStatus();
  
  @DISPID(8)
  @VTID(18)
  public abstract String executionLog();
  
  @DISPID(9)
  @VTID(19)
  public abstract String runOnHost(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(9)
  @VTID(20)
  public abstract void runOnHost(@MarshalAs(NativeType.VARIANT) Object paramObject, String paramString);
  
  @DISPID(10)
  @VTID(21)
  public abstract String vM_Config(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(10)
  @VTID(22)
  public abstract void vM_Config(@MarshalAs(NativeType.VARIANT) Object paramObject, String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITSScheduler
 * JD-Core Version:    0.7.0.1
 */