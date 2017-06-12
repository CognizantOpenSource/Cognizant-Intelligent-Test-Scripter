package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{42CB624E-00B7-4803-A465-6FBC156A976B}")
public abstract interface IDashboardPageItem
  extends IBaseField
{
  @DISPID(15)
  @VTID(20)
  public abstract int pageId();
  
  @DISPID(16)
  @VTID(21)
  public abstract int analysisItemId();
  
  @DISPID(16)
  @VTID(22)
  public abstract void analysisItemId(int paramInt);
  
  @DISPID(17)
  @VTID(23)
  public abstract int row();
  
  @DISPID(17)
  @VTID(24)
  public abstract void row(int paramInt);
  
  @DISPID(18)
  @VTID(25)
  public abstract int column();
  
  @DISPID(18)
  @VTID(26)
  public abstract void column(int paramInt);
  
  @DISPID(19)
  @VTID(27)
  public abstract int height();
  
  @DISPID(19)
  @VTID(28)
  public abstract void height(int paramInt);
  
  @DISPID(20)
  @VTID(29)
  public abstract int width();
  
  @DISPID(20)
  @VTID(30)
  public abstract void width(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IDashboardPageItem
 * JD-Core Version:    0.7.0.1
 */