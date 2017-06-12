package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{FAEFC40D-CFBC-498F-AC63-BE17ED80D76D}")
public abstract interface IAnalysisItem
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
  public abstract String module();
  
  @DISPID(17)
  @VTID(27)
  public abstract void module(String paramString);
  
  @DISPID(18)
  @VTID(28)
  public abstract String type();
  
  @DISPID(18)
  @VTID(29)
  public abstract void type(String paramString);
  
  @DISPID(19)
  @VTID(30)
  public abstract String filterData();
  
  @DISPID(19)
  @VTID(31)
  public abstract void filterData(String paramString);
  
  @DISPID(20)
  @VTID(32)
  public abstract String layoutData();
  
  @DISPID(20)
  @VTID(33)
  public abstract void layoutData(String paramString);
  
  @DISPID(21)
  @VTID(34)
  public abstract String lastModified();
  
  @DISPID(22)
  @VTID(35)
  public abstract String modifiedBy();
  
  @DISPID(23)
  @VTID(36)
  public abstract String subType();
  
  @DISPID(23)
  @VTID(37)
  public abstract void subType(String paramString);
  
  @DISPID(24)
  @VTID(38)
  public abstract String description();
  
  @DISPID(24)
  @VTID(39)
  public abstract void description(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAnalysisItem
 * JD-Core Version:    0.7.0.1
 */