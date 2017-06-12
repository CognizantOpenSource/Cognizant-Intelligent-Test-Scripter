package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{0D6A3C6E-D8D9-4F10-BF51-FB7FBD3666A7}")
public abstract interface IAnalysisItemFolder
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
  public abstract boolean _public();
  
  @DISPID(16)
  @VTID(25)
  public abstract void _public(boolean paramBoolean);
  
  @DISPID(17)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject analysisItemFolderFactory();
  
  @DISPID(18)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject analysisItemFactory();
  
  @DISPID(19)
  @VTID(28)
  public abstract String description();
  
  @DISPID(19)
  @VTID(29)
  public abstract void description(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAnalysisItemFolder
 * JD-Core Version:    0.7.0.1
 */