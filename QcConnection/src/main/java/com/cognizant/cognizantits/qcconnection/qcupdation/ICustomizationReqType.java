package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{05518018-2339-4E08-87BE-D14C69527B7A}")
public abstract interface ICustomizationReqType
  extends ICustomizationType
{
  @DISPID(10)
  @VTID(20)
  public abstract boolean hasDirectCoverage();
  
  @DISPID(10)
  @VTID(21)
  public abstract void hasDirectCoverage(boolean paramBoolean);
  
  @DISPID(11)
  @VTID(22)
  public abstract int riskAnalysisType();
  
  @DISPID(11)
  @VTID(23)
  public abstract void riskAnalysisType(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationReqType
 * JD-Core Version:    0.7.0.1
 */