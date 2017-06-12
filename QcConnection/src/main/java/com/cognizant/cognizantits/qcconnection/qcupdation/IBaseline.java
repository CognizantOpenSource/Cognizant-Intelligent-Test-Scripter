package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{EAC92EF2-C2A6-414E-9BEE-5525A9F64DC5}")
public abstract interface IBaseline
  extends IBaseFieldEx
{
  @DISPID(16)
  @VTID(23)
  public abstract String name();
  
  @DISPID(16)
  @VTID(24)
  public abstract void name(String paramString);
  
  @DISPID(17)
  @VTID(25)
  public abstract String description();
  
  @DISPID(17)
  @VTID(26)
  public abstract void description(String paramString);
  
  @DISPID(18)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject parent();
  
  @DISPID(19)
  @VTID(28)
  public abstract String creatorUser();
  
  @DISPID(20)
  @VTID(29)
  public abstract Date creationDate();
  
  @DISPID(21)
  @VTID(30)
  public abstract int captureState();
  
  @DISPID(22)
  @VTID(31)
  public abstract void capture();
  
  @DISPID(23)
  @VTID(32)
  public abstract int captureAsync();
  
  @DISPID(24)
  @VTID(33)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject baselineRootFactory();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseline
 * JD-Core Version:    0.7.0.1
 */