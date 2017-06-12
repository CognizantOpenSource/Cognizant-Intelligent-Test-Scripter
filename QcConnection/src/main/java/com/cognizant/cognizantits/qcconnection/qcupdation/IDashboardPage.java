package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{5A33646F-DC23-45A7-9C4C-E20037C64461}")
public abstract interface IDashboardPage
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
  public abstract String description();
  
  @DISPID(17)
  @VTID(27)
  public abstract void description(String paramString);
  
  @DISPID(18)
  @VTID(28)
  public abstract String title();
  
  @DISPID(18)
  @VTID(29)
  public abstract void title(String paramString);
  
  @DISPID(19)
  @VTID(30)
  public abstract String lastModified();
  
  @DISPID(20)
  @VTID(31)
  public abstract String modifiedBy();
  
  @DISPID(21)
  @VTID(32)
  public abstract String ownerUser();
  
  @DISPID(22)
  @VTID(33)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject dashboardPageItemFactory();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IDashboardPage
 * JD-Core Version:    0.7.0.1
 */