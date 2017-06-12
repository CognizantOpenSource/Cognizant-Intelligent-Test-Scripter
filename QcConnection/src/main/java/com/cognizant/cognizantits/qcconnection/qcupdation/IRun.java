package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{34023178-4154-4B16-80A4-6C610096648A}")
public abstract interface IRun
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract String resultLocation();
  
  @DISPID(15)
  @VTID(24)
  public abstract String name();
  
  @DISPID(15)
  @VTID(25)
  public abstract void name(String paramString);
  
  @DISPID(16)
  @VTID(26)
  public abstract String status();
  
  @DISPID(16)
  @VTID(27)
  public abstract void status(String paramString);
  
  @DISPID(17)
  @VTID(28)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject stepFactory();
  
  @DISPID(18)
  @VTID(29)
  public abstract int testId();
  
  @DISPID(19)
  @VTID(30)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject extendedStorage();
  
  @DISPID(20)
  @VTID(31)
  public abstract void copyDesignSteps();
  
  @DISPID(21)
  @VTID(32)
  public abstract void copyStepsToTest();
  
  @DISPID(22)
  @VTID(33)
  public abstract int testSetID();
  
  @DISPID(23)
  @VTID(34)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject params(int paramInt);
  
  @DISPID(24)
  @VTID(35)
  public abstract void resolveStepsParameters(@Optional @DefaultValue("-1") boolean paramBoolean);
  
  @DISPID(25)
  @VTID(36)
  public abstract int testInstance();
  
  @DISPID(26)
  @VTID(37)
  public abstract void cancelRun();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IRun
 * JD-Core Version:    0.7.0.1
 */