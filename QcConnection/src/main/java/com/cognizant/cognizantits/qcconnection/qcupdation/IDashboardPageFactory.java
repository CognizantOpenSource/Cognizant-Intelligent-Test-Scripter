package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{1001E71F-5744-4624-8000-633698EB940D}")
public abstract interface IDashboardPageFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  public abstract IList getPagesWithPrivateItems(IList paramIList);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IDashboardPageFactory
 * JD-Core Version:    0.7.0.1
 */