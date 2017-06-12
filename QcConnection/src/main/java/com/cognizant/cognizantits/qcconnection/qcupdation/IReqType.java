package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{F6B62ACC-B8F1-45EF-9387-3C9FC69B529D}")
public abstract interface IReqType
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int id();
  
  @DISPID(2)
  @VTID(8)
  public abstract String name();
  
  @DISPID(3)
  @VTID(9)
  public abstract IStream icon();
  
  @DISPID(4)
  @VTID(10)
  public abstract String editingControl();
  
  @DISPID(5)
  @VTID(11)
  public abstract boolean hasDirectCoverage();
  
  @DISPID(6)
  @VTID(12)
  public abstract int riskAnalysisType();
  
  @DISPID(7)
  @VTID(13)
  public abstract String prefix();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReqType
 * JD-Core Version:    0.7.0.1
 */