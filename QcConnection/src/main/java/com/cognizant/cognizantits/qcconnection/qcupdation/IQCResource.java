package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{BBE9102D-1929-469C-BCB0-B13C7CF51716}")
public abstract interface IQCResource
  extends IBaseFieldExMail
{
  @DISPID(15)
  @VTID(24)
  public abstract String fileName();
  
  @DISPID(15)
  @VTID(25)
  public abstract void fileName(String paramString);
  
  @DISPID(16)
  @VTID(26)
  public abstract int parentId();
  
  @DISPID(16)
  @VTID(27)
  public abstract void parentId(int paramInt);
  
  @DISPID(17)
  @VTID(28)
  public abstract String description();
  
  @DISPID(17)
  @VTID(29)
  public abstract void description(String paramString);
  
  @DISPID(18)
  @VTID(30)
  public abstract String creator();
  
  @DISPID(18)
  @VTID(31)
  public abstract void creator(String paramString);
  
  @DISPID(19)
  @VTID(32)
  public abstract void progress();
  
  @DISPID(20)
  @VTID(33)
  public abstract String location();
  
  @DISPID(21)
  @VTID(34)
  public abstract String resourceType();
  
  @DISPID(21)
  @VTID(35)
  public abstract void resourceType(String paramString);
  
  @DISPID(22)
  @VTID(36)
  public abstract String name();
  
  @DISPID(22)
  @VTID(37)
  public abstract void name(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IQCResource
 * JD-Core Version:    0.7.0.1
 */