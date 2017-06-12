package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{FFE8FF09-7522-448E-933E-724B6A149887}")
public abstract interface ITSTest
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract String status();
  
  @DISPID(14)
  @VTID(24)
  public abstract void status(String paramString);
  
  @DISPID(15)
  @VTID(25)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject runFactory();
  
  @DISPID(16)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject test();
  
  @DISPID(17)
  @VTID(27)
  public abstract String hostName();
  
  @DISPID(17)
  @VTID(28)
  public abstract void hostName(String paramString);
  
  @DISPID(18)
  @VTID(29)
  public abstract String name();
  
  @DISPID(19)
  @VTID(30)
  public abstract String type();
  
  @DISPID(20)
  @VTID(31)
  public abstract boolean hasSteps();
  
  @DISPID(21)
  @VTID(32)
  public abstract String executionParams();
  
  @DISPID(21)
  @VTID(33)
  public abstract void executionParams(String paramString);
  
  @DISPID(22)
  @VTID(34)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject lastRun();
  
  @DISPID(23)
  @VTID(35)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject params();
  
  @DISPID(24)
  @VTID(36)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject executionSettings();
  
  @DISPID(25)
  @VTID(37)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object testId();
  
  @DISPID(26)
  @VTID(38)
  public abstract int instance();
  
  @DISPID(27)
  @VTID(39)
  public abstract String testName();
  
  @DISPID(28)
  @VTID(40)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject testSet();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITSTest
 * JD-Core Version:    0.7.0.1
 */