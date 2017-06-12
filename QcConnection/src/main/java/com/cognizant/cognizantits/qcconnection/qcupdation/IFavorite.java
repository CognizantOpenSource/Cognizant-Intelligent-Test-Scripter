package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{ECE59B8E-4FCB-4864-B9BF-C28EB628CFDB}")
public abstract interface IFavorite
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
  
  @DISPID(17)
  @VTID(25)
  public abstract String module();
  
  @DISPID(18)
  @VTID(26)
  public abstract String filterData();
  
  @DISPID(18)
  @VTID(27)
  public abstract void filterData(String paramString);
  
  @DISPID(19)
  @VTID(28)
  public abstract String layoutData();
  
  @DISPID(19)
  @VTID(29)
  public abstract void layoutData(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFavorite
 * JD-Core Version:    0.7.0.1
 */