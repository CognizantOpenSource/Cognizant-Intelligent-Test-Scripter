package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{E93A887B-8FBC-400E-8BD0-ECC2B064D7A5}")
public abstract interface IAnalysisItemFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  public abstract IList getItemsIncludedInPages(IList paramIList, boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAnalysisItemFactory
 * JD-Core Version:    0.7.0.1
 */