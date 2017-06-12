package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.Holder;
import com4j.IID;
import com4j.VTID;

@IID("{551A15F5-289D-4C25-AAFA-75CB0171668E}")
public abstract interface IWarningInfo
  extends Com4jObject
{
  @VTID(3)
  public abstract void setWarning(int paramInt, String paramString, Com4jObject paramCom4jObject);
  
  @VTID(4)
  public abstract void setWarningFromFrec(String paramString, Com4jObject paramCom4jObject);
  
  @VTID(5)
  public abstract boolean warningExists();
  
  @VTID(6)
  public abstract void getWarning(Holder<Integer> paramHolder, Holder<String> paramHolder1);
  
  @VTID(7)
  public abstract Com4jObject getCaller();
  
  @VTID(8)
  public abstract void clearWarning();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IWarningInfo
 * JD-Core Version:    0.7.0.1
 */