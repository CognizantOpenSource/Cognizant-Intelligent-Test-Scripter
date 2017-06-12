package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{584A90A3-490D-4661-B781-9845B2D57C92}")
public abstract interface IDashboardFolder
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
  public abstract Com4jObject dashboardFolderFactory();
  
  @DISPID(18)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject dashboardPageFactory();
  
  @DISPID(19)
  @VTID(28)
  public abstract String description();
  
  @DISPID(19)
  @VTID(29)
  public abstract void description(String paramString);
  
  @DISPID(20)
  @VTID(30)
  public abstract String ownerUser();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IDashboardFolder
 * JD-Core Version:    0.7.0.1
 */