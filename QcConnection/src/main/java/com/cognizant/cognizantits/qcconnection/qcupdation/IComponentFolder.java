package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{7A6F279C-7729-4394-B5BB-BC3E8902DA56}")
public abstract interface IComponentFolder
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
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject componentFactory();
  
  @DISPID(16)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject componentFolderFactory();
  
  @DISPID(17)
  @VTID(27)
  public abstract String path();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComponentFolder
 * JD-Core Version:    0.7.0.1
 */