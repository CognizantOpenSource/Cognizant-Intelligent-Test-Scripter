package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.VTID;

@IID("{B14CE979-E8D8-426B-AFCF-B8AA9AFE267B}")
public abstract interface ITDFilter2
  extends ITDFilter
{
  @DISPID(13)
  @VTID(28)
  public abstract void setXFilter(String paramString1, boolean paramBoolean, String paramString2);
  
  @DISPID(14)
  @VTID(29)
  public abstract String getXFilter(String paramString, Holder<Boolean> paramHolder);
  
  @DISPID(15)
  @VTID(30)
  public abstract boolean isClear();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDFilter2
 * JD-Core Version:    0.7.0.1
 */