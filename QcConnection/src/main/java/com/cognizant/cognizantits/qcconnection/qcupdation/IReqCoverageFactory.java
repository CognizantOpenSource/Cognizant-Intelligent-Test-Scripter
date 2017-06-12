package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{3F004630-2A1E-4E7A-9133-6A0EA826C48F}")
public abstract interface IReqCoverageFactory
  extends ICoverageFactory
{
  @DISPID(8)
  @VTID(16)
  public abstract boolean fullCoverage();
  
  @DISPID(8)
  @VTID(17)
  public abstract void fullCoverage(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReqCoverageFactory
 * JD-Core Version:    0.7.0.1
 */