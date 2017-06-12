package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{992BABA3-6360-4BD1-A337-B75F67BDB417}")
public abstract interface IStep
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract String name();
  
  @DISPID(14)
  @VTID(24)
  public abstract void name(String paramString);
  
  @DISPID(15)
  @VTID(25)
  public abstract String status();
  
  @DISPID(15)
  @VTID(26)
  public abstract void status(String paramString);
  
  @DISPID(16)
  @VTID(27)
  public abstract void creationMode(short paramShort);
  
  @DISPID(17)
  @VTID(28)
  public abstract int testSource();
  
  @DISPID(18)
  @VTID(29)
  public abstract int designStepSource();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IStep
 * JD-Core Version:    0.7.0.1
 */