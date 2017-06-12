package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.IID;
import com4j.VTID;

@IID("{DEBC6003-2ABE-4C93-A769-646F300A7986}")
public abstract interface ITDErrorInfo
  extends IErrorInfo
{
  @VTID(8)
  public abstract String details();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDErrorInfo
 * JD-Core Version:    0.7.0.1
 */