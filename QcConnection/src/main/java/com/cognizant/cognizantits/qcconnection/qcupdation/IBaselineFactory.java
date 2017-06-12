package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{3D7543C1-9B84-457E-9A1A-CCB7D20663FA}")
public abstract interface IBaselineFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  public abstract IList baselineItems(IBaseField paramIBaseField);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaselineFactory
 * JD-Core Version:    0.7.0.1
 */