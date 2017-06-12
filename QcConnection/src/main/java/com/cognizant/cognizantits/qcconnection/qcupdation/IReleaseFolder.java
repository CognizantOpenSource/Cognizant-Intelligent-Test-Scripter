package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{1D7BC0E7-454B-4F73-B693-F6B38763F8E2}")
public abstract interface IReleaseFolder
  extends IBaseFieldExMail
{
  @DISPID(15)
  @VTID(24)
  public abstract String name();
  
  @DISPID(15)
  @VTID(25)
  public abstract void name(String paramString);
  
  @DISPID(16)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject releaseFactory();
  
  @DISPID(17)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject releaseFolderFactory();
  
  @DISPID(18)
  @VTID(28)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject parent();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReleaseFolder
 * JD-Core Version:    0.7.0.1
 */