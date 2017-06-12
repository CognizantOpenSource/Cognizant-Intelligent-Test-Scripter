package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E21B9076-FA22-46E2-80FB-25EE98C6931C}")
public abstract interface IQCResourceFolder
  extends IBaseField
{
  @DISPID(14)
  @VTID(20)
  public abstract String name();
  
  @DISPID(14)
  @VTID(21)
  public abstract void name(String paramString);
  
  @DISPID(15)
  @VTID(22)
  public abstract int parentId();
  
  @DISPID(15)
  @VTID(23)
  public abstract void parentId(int paramInt);
  
  @DISPID(16)
  @VTID(24)
  public abstract String description();
  
  @DISPID(16)
  @VTID(25)
  public abstract void description(String paramString);
  
  @DISPID(17)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject qcResourceFolderFactory();
  
  @DISPID(18)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject qcResourceFactory();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IQCResourceFolder
 * JD-Core Version:    0.7.0.1
 */